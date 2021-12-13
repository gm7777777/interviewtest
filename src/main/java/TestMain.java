import com.common.TreeNode;
import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

import java.lang.ref.Reference;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.Scanner;
public class TestMain {
    public static void main(String[] args) {
        int[] a = {37,2,5,1,8,4,45,67,798,34,23};

        int start = (a.length-1)/2;
        for(int i = start;i>=0;i--){
            heapUp(a,a.length,i);
        }

        for(int i = a.length-1;i>=0;i--){
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            heapUp(a,i,0);
        }

        System.out.println(Arrays.toString(a));

    }

    public static void heapUp(int[] s ,int size,int index){

        int left = 2*index+1;
        int right = 2*index+2;
        int max = index;
        if(left<size && s[left]>s[max]){
            max = left;
        }
        if(right<size && s[right]>s[max]){
            max = right;
        }
        if(max!=index){
            int t = s[max];
            s[max] = s[index];
            s[index] = t;
            heapUp(s,size,max);
        }

    }
}
