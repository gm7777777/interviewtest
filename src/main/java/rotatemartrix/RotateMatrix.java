package rotatemartrix;

public class RotateMatrix {

    /** 转置
     * 1 2 3      1 4 7
     * 4 5 6   -> 2 5 8
     * 7 8 9      3 6 9
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        //原矩阵
//        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//
//        //行数
//        int n = a.length;
//        //列数
//        int m = a[0].length;
//        //转换后矩阵
//        int[][] arr = new int[n][m];
//        //转置
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = a[j][i];
//            }
//        }
//        //输出
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }


    // 逆时针旋转90度
    /**
     *1 2 3      3 6 9
     4 5 6  ->  2 5 8
     7 8 9      1 4 7
     *
     */
    public static void main(String[] args) {
        // 原矩阵
        int[][] a = { { 1, 2, 3 ,4}, { 5, 6, 7,8 }, { 9, 10, 11 ,12}, { 13, 14, 15 ,16}  };
        //行数
        int n = a.length;
        //列数
        int m = a[0].length;
        // 转换后矩阵
        int[][] arr = new int[n][m];

//        // 逆旋转
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m ; j++) {
//                arr[m - 1 - j][i] = a[i][j];
//            }
//        }
        // 顺旋转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                arr[j][n-1-i] = a[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void reverse(int temp [][]) {
                 for (int i = 0; i < temp.length; i++) {
                         for (int j = i; j < temp[i].length; j++) {
                                 int k = temp[i][j] ;
                                temp[i][j] = temp[j][i] ;
                                 temp[j][i] = k ;
                            } }
             }

}
