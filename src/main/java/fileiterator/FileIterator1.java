package fileiterator;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileIterator1 {

    //统计类型集合
    static Map<String,AtomicInteger> statisticsMap = new ConcurrentHashMap();

    /**
     *分类文件类型
     *确定文件类型四种分类：TEXT-文本,MEDIA-流媒体,PIC-图片,FILE-文件,OTHER-其他
     */
    public static void initClassifiedFileType(){

        SingletonPool.getInstance().classifiedFileType("TEXT",new String[]{"log","txt","xml","xlsx",
                "doc","html","css","java","json","conf"});
        statisticsMap.put("TEXT",new AtomicInteger(0));

        SingletonPool.getInstance().classifiedFileType("MEDIA",new String[]{"wmv","mp3","avi","mov",
                "rmvb","rm","flv","mp4","3gp"});
        statisticsMap.put("MEDIA",new AtomicInteger(0));

        SingletonPool.getInstance().classifiedFileType("PIC",new String[]{"bmp","dib","jpg","jpeg",
                "jpe","jfif","gif","tif","tiff","png","heic"});
        statisticsMap.put("PIC",new AtomicInteger(0));

        SingletonPool.getInstance().classifiedFileType("FILE",new String[]{"exe","rar","zip","dll",
                "bin","prx","dat","mui","ini","inf","sys","cat","cgf","url","pdf"});
        statisticsMap.put("FILE",new AtomicInteger(0));

        SingletonPool.getInstance().classifiedFileType("OTHER",new String[]{});
        statisticsMap.put("OTHER",new AtomicInteger(0));
    }

//    static String BASE_FILE="D:\\YmsFileTemp";
    //需要统计的文件路径
    static String BASE_FILE="D:\\";
    //需要监听的文件类型
    static String LISTENER_TYPE="PIC";

    static int THREADPOOL_CORESIZE = 5;
    static int THREADPOOL_MAXSIZE = 200;
    static int THREADPOOL_CONCURRENCYTASKSIZE = 1024000;

    public static void main(String[] args) {
        //控制线程并发数，与等待任务数
        SingletonPool.getInstance().createThreadPool(THREADPOOL_CORESIZE,THREADPOOL_MAXSIZE,THREADPOOL_CONCURRENCYTASKSIZE);

        //确定需要统计的文件分类
        initClassifiedFileType();
//        classifiedFileType();

        //开启文件遍历统计
        FileIterator1 iteratorEngine =new  FileIterator1();
        iteratorEngine.startCalculation(BASE_FILE);
    }

    private void startCalculation(String path){
        classifiedFile(new File(path));

    }

    /**
     * 统计线程
     */
    class DirectoryIteratorThread implements Runnable{

        File directory = null;
        DirectoryIteratorThread(File directory){
            this.directory = directory;
        }

        @Override
        public void run() {
            File[] fs = directory.listFiles();
            if(fs!=null){
                for(int i = 0; i<fs.length;i++){
                    classifiedFile(fs[i]);
                }
                showStatistics();
            }
        }
    }
    private void showStatistics(){
        for(Map.Entry<String,AtomicInteger> entry:statisticsMap.entrySet()){
            System.out.println("FileType : "+entry.getKey()+" , Size is : "+entry.getValue().intValue());
        }
    }
    private void classifiedFile(File tempf){
        if(tempf.isDirectory()){
            try {
            while(((ThreadPoolExecutor)SingletonPool.getInstance().getThreadPool()).getQueue().size()>(THREADPOOL_CONCURRENCYTASKSIZE*0.95)){
                    Thread.sleep(1000);
                System.out.println("线程数接近满员，等待线程池释放资源");
            }

                //统计文件线程
                SingletonPool.getInstance().getThreadPool().execute(new DirectoryIteratorThread(tempf));
//                if(tempf.exists()){
//                    SingletonPool.getInstance().getThreadPool().execute(new FileWatcherThread(tempf,LISTENER_TYPE));
//                }
            } catch (Exception e) {
                System.out.println("异常-线程数接近满员，等待线程池释放资源");
            }

            //不用线程池的原因是因为 watchservice.take() 是阻塞方法，如果所有线程都阻塞会塞满线程池
            try {
            //监听线程
                new Thread(new FileWatcherThread(tempf,LISTENER_TYPE)).start();
            } catch (Exception e) {
                System.out.println("线程数接近满员，等待线程池释放资源");
            }
        }else{
            String fileType = null;
            try {
            String fname = tempf.getName();
            String suffix = fname.substring(fname.lastIndexOf(".")+1,fname.length()).toLowerCase();
            fileType = SingletonPool.getInstance().getFileTypeMap().get(suffix);
            if(fileType==null){
                fileType = "OTHER";
                SingletonPool.getInstance().getFileTypeMap().put(suffix,fileType);
            }

            statisticsMap.get(fileType).getAndIncrement();
            } catch (Exception e) {
                System.out.println("有问题的 filetype "+fileType+","+statisticsMap.get(fileType));
            }
        }
    }

    /**
     * 监听文件变化线程
     */
    class FileWatcherThread implements Runnable {

        File watchFile = null;
        String listenerFileType = null;
        FileWatcherThread(File watchFile,String listenerFileType){
            this.watchFile = watchFile;
            this.listenerFileType = listenerFileType;
        }

        @Override
        public void run() {
            try {
                addFileWatcherListener(watchFile,listenerFileType);
            } catch (IOException e) {
            System.err.println(e);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }

        private void addFileWatcherListener(File watchFile,String listenerFileType) throws IOException, InterruptedException {
          WatchService watchService = FileSystems.getDefault().newWatchService();
                //给path路径加上文件观察服务
                watchFile.toPath().register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_MODIFY,
                        StandardWatchEventKinds.ENTRY_DELETE);
                while (true) {
//                    Thread.sleep(5000);
                    final WatchKey key = watchService.take();

                    for (WatchEvent<?> watchEvent : key.pollEvents()) {

                        final WatchEvent.Kind<?> kind = watchEvent.kind();
                        final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
                        final Path filename = watchEventPath.context();
                        if(filename!=null&&!"".equals(filename)){
                            String fnam = filename.getFileName().toString();
                            String suffix = fnam.substring(fnam.lastIndexOf(".")+1,fnam.length()).toLowerCase();
                            if(listenerFileType!=null&&!"".equals(listenerFileType)
                                    &&listenerFileType.equals(SingletonPool.getInstance().getFileTypeMap().get(suffix))){
                                if (kind == StandardWatchEventKinds.OVERFLOW) {
                                    continue;
                                }
                                //创建事件
                                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
//                        System.out.println("[新建]");
                                    System.out.println("文件:"+listenerFileType+"新增");
                                }
                                //修改事件
                                if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
//                        System.out.println("修改]");
                                    System.out.println("文件:"+listenerFileType+"修改");
                                }
                                //删除事件
                                if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
//                        System.out.println("[删除]");
                                    System.out.println("文件:"+listenerFileType+"删除");
                                }
                            }
                        }

//                        showStatistics();
                    }
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }



        }
    }


}
