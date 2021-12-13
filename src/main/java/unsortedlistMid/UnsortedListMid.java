package unsortedlistMid;

import java.util.PriorityQueue;

public class UnsortedListMid {

    public static void main(String[] args) {
        median(new int[]{4, 5, 8, 9, 1, 3, 2, 0, 7, 6});
    }

    public static double median(int[] array){
             int heapSize = array.length/2 + 1;
             PriorityQueue<Integer> heap = new PriorityQueue<Integer>(heapSize);
             for(int i=0; i<heapSize; i++){
                     heap.add(array[i]);
                 }
             for(int i=heapSize; i<array.length; i++){
                     if(heap.peek()<array[i]){
                             heap.poll();
                             heap.add(array[i]);
                         }
                 }
             if(array.length % 2 == 1){
                     return (double)heap.peek();
                 }
            else{
                     return (double)(heap.poll()+heap.peek())/2.0;
            }
         }
}
