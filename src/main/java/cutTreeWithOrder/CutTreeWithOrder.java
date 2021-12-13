package cutTreeWithOrder;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class CutTreeWithOrder {

    static int[][] dirs = {{1,2,3},{0,4,0},{5,6,7}};
    public static void main(String[] args) {
            System.out.println(cutTreeSteps(dirs));
    }
    public static int cutTreeSteps(int[][] forest){
        if(forest == null||forest.length==0||forest[0].length==0){
            return 0;
        }

        int m = forest.length;
        int n = forest[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(forest[i][j]>1){
                    minHeap.add(new int[]{i,j,forest[i][j]});
                }
            }
        }

        int[] start = new int[2];
        int res = 0;
        while(!minHeap.isEmpty()){
            int[] lowest = (int[]) minHeap.peek();
            int step = minStep(forest,start,lowest,m,n);
            if(step<0){
                return -1;
            }
            res +=step;
            start[0] = lowest[0];
            start[1] = lowest[1];
        }
        return res;
    }


    private static int minStep(int[][] forest,int[] start,int[] lowest ,int m,int n){
        int step = 0;
        LinkedList<int[]> que = new LinkedList<int[]>();
        boolean[][] used = new boolean[m][n];
        que.add(start);
        used[start[0]][start[1]]=true;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0;i<size;i++){
                int[] cur = que.poll();
                if(cur[0] == lowest[0]&&cur[1]==lowest[1]){
                    return step;
                }
                for(int[] dir : dirs){
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if(nx<0||nx>m||ny<0||ny>=n||used[nx][ny]||forest[nx][ny]==0){
                        continue;
                    }
                    que.add(new int[]{nx,ny});
                    used[nx][ny] = true;
                }

            }

            step++;

        }
            return -1;
    }
}
