package print1tonsitenum;

//打印从1到n位的所有数

public class Print1toNsiteNum {

    static void Print1ToMaxOfNDigits(int n)
    {
        if (n <= 0)
        {
            return;
        }
        // memset(number,'0',n);
        char[] number = new char[n + 1];
        for (int i = 0; i < n; i++)
        {
            number[i] = '0';
        }
        number[n] = '\0';

        // Increment实现在表示数字的字符串number上增加1
        while (!Increment(number))
        {
            // PrintNumber负责打印出number
            PrintNumber(number);
        }

        number = null;
    }

    static boolean Increment(char[] number)
    {
        boolean isOverflow = false;
        int takeOver = 0;
        int length = number.length - 1;

        for (int i = length - 1; i >= 0; i--)
        {
            int sum = number[i] - '0' + takeOver;
            if (i == length - 1)
            {
                sum++;
            }

            if (sum >= 10)
            {
                if (i == 0)
                {
                    // 标识已经溢出了
                    isOverflow = true;
                }
                else
                {
                    sum -= 10;
                    takeOver = 1;
                    number[i] = (char)('0' + sum);
                }
            }
            else
            {
                number[i] = (char)('0' + sum);
                break;
            }
        }

        return isOverflow;
    }

    static void PrintNumber(char[] number)
    {
        boolean isBeginning0 = true;

        for (int i = 0; i < number.length; i++)
        {
            if (isBeginning0 && number[i] != '0')
            {
                isBeginning0 = false;
            }

            if (!isBeginning0)
            {
                System.out.println( number[i]);
            }
        }

        System.out.println("\t");
    }
}
