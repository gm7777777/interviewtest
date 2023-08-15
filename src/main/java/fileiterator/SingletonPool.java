package fileiterator;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.*;

public class SingletonPool {

    private static ExecutorService threadPool=null;

    //文件分类key是文件后缀，value是分类的类型
    private ConcurrentHashMap<String,String> fileTypeMap = new ConcurrentHashMap();

    private static class InnerClass{
        private static final SingletonPool singleton = new SingletonPool();
    }

    public static SingletonPool getInstance(){
        return InnerClass.singleton;
    }

    public void createThreadPool(int coreSize,int maxSize,int concurrencyTaskSize){
        threadPool = new ThreadPoolExecutor(coreSize, maxSize, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(concurrencyTaskSize), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public void classifiedFileType(String classify,String[] filetype){
        for(String type:filetype){
            this.fileTypeMap.put(type,classify);
        }
    }

    public ConcurrentHashMap<String,String> getFileTypeMap() {
        return fileTypeMap;
    }
}
