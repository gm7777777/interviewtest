package longestPalindrome;

//最长回文字符串
public class LongestPalindrome {


    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        //存储左区间索引
        int start=0;
        //存储右区间索引
        int end=0;
        //提前获取字符串长度提升效率
        int n=s.length();
        for(int i=0;i<n;i++){
            //注意奇偶字符串要分别进行扩散
            //使用函数进行重复的扩散操作
            int l1=length(s,i,i);
            int l2=length(s,i,i+1);
            //比较每次获取的奇偶字符串长度
            int len=Math.max(l1,l2);
            //更新最大长度
            if(len>end-start){
                //根据获取的长度和中心索引获取左右区间的索引
                //注意要对长度进行调整
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        //截断源字符串返回最大子回文串并直接返回
        return s.substring(start,end+1);
    }
    public static int length(String s,int a,int b){
        while(a>=0&&b<=s.length()&&s.charAt(a)==s.charAt(b)){
            a--;
            b++;
        }
        return b-a-1;
    }


        /**
         * 使用常规方法, 以字符串的每一个字符作为中心进行判断, 包括奇数和偶数的情况
         * 最坏时间复杂度为O(N^2) , 空间复杂度O(1)
         */
        public static int longestPalidrome2(String s)
        {
            if(s == null || s.length() <= 0)
                return 0 ;

            int max = 0 ;

            for(int i=0 ; i<s.length() ; i++)
            {
                for(int time=0 ; time<2 ; time++)
                {
                    int length = getMax(s , i , time+i) ;
                    if(max < length)
                        max = length ;
                }
            }

            return max ;
        }

        private static int getMax(String s, int left , int right) {
            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                left--;
                right++;
            }

            return right - left - 1;
        }


}
