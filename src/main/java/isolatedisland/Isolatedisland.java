package isolatedisland;

public class Isolatedisland {

    public static void main(String[] args) {

        int[][] island = {{1,1,0,0,0},{0,1,0,0,1},{0,0,1,0,0},{0,0,0,1,0}};
        System.out.println(findMaxAssoIsland(island));
    }


    public static int findMaxAssoIsland(int[][] area){
        Integer max = new Integer(0);
        for(int i =0;i<area.length;i++){
            for(int j = 0 ; j<area[0].length;j++){
                if(area[i][j]==1){
                    int temp = stepforward(area,i,j,0);
                    if(temp>max){
                        max = temp;
                    }
                }
            }

        }
        return max;
    }

    public static int  stepforward(int[][]area,int x ,int y,int temp){
        if(0<=x&&x<area.length&&y>=0&&y<area[0].length&&area[x][y]==1){
            area[x][y] = area[x][y]+1;
            temp++;
            int t = stepforward(area,x,y-1,temp);
            int t1 = stepforward(area,x,y+1,temp);
            int t2 = stepforward(area,x-1,y,temp);
            int t3 = stepforward(area,x+1,y,temp);
            return Math.max(Math.max(Math.max(t,t1),t2),t3);
        }
        return temp;
    }
}
