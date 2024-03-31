package allbrackets;

import java.util.ArrayList;
import java.util.List;

//回溯法
//示例 1：
//
//        输入：n = 3
//        输出：["((()))","(()())","(())()","()(())","()()()"]
//        示例 2：
//
//        输入：n = 1
//        输出：["()"]
public class AllBrackets {
    private static final List<String> parenthesis = new ArrayList<>();
    private static int totalNum;

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        totalNum = 2 * n;
        backtrack("", 2 * n, 0, 0);
        return parenthesis;
    }

    /**
     * 回溯法
     * 关键是确定下一个可以选择的节点,
     * @param path 已经选择好的路径
     * @param n 还要选择多少个字符
     * @param left 左括号数量
     * @param right 右括号数量
     */
    public static void backtrack(String path, int n, int left, int right){
        if(n == 0){
            parenthesis.add(path);
            return;
        }
        // 确定下一个可以选择的括号
        if(left > right){ // 左括号多余右括号, 可以加一个右括号
            backtrack(path + ')', n - 1, left, right + 1);
        }
        if(left < totalNum / 2){ // 左括号不大于总括号数的一半, 可以加一个左括号
            backtrack(path + '(', n - 1, left + 1, right);
        }
    }
}
