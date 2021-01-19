package numarrange;

//输出所有组合
public class NumArrange {

    //排列数组
    public static void sq(char data[], int k) {
        if (k == data.length) {
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = k; i < data.length; i++) {
            {
                char temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }

            sq(data, k + 1);
            {
                char temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String yy ;

        char data[] = "ABCD".toCharArray();
        sq(data, 0);
    }

}
