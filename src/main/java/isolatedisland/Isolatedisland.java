package isolatedisland;

//计算岛的数量
public class Isolatedisland {

    public static void main(String[] args) {

        int[][] island = {{1,1,1,0,0},{0,1,0,0,1},{0,0,1,0,0},{0,0,0,1,0}};
        System.out.println(findMaxAssoIsland(island));
    }


    public static int findMaxAssoIsland(int[][] area){
        Integer max = new Integer(0);
        for(int i =0;i<area.length;i++){
            for(int j = 0 ; j<area[0].length;j++){
                if(area[i][j]==1){
                    int temp = stepforward(area,i,j);
                    if(temp>max){
                        max = temp;
                    }
                }
            }

        }
        return max;
    }

    public static int  stepforward(int[][]area,int x ,int y){
        if(0<=x&&x<area.length&&y>=0&&y<area[0].length&&area[x][y]==1){
            area[x][y] = area[x][y]+1;
            return  stepforward(area,x,y-1)+stepforward(area,x,y+1)+stepforward(area,x-1,y)+stepforward(area,x+1,y)+1;
        }
        return 0;
    }
}
