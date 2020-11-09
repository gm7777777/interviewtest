package bucketsort;

public class BucketSort {
    private int[] buckets;
    private int[] array;

    public BucketSort(int range,int[] array){
        this.buckets = new int[range];
        this.array = array;
    }

    /*排序*/
    public void sort(){
        if(array!=null && array.length>1){
            for(int i=0;i<array.length;i++){
                buckets[array[i]]++;
            }
        }
    }

    /*排序输出*/
    public void sortOut(){
        //倒序输出数据
        for (int i=buckets.length-1; i>=0; i--){
            for(int j=0;j<buckets[i];j++){
                System.out.print(i+"\t");
            }
        }
    }

    public static void main(String[] args) {
        testBucketsSort();
    }

    private static void testBucketsSort(){
        int[] array = {5,7,3,5,4,8,6,4,1,2};
        BucketSort bs = new BucketSort(10, array);
        bs.sort();
        bs.sortOut();//输出打印排序
    }
}
