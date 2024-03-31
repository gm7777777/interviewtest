package stackcalstringdecode;

import java.util.Stack;

public class StackCalStringdecode {

    //1. 输入String只包含左右括号，字母，数字
//2. 括号中只包含字母
//3. 左括号前是数字
//    Input: s = “2[b]3[cd]”
//    Output: “bbcdcdcd”
//    Input: s = “2[b2[cd]]”
//    Output: “bcdcdbcdcd”
//    Input: s = “3[ab]2[c]ef”
//    Output: “abababccef”
    public static void main(String[] args) {
        System.out.println(outputStr("2[b]3[cd]"));
        System.out.println(outputStr("2[b2[cd]]"));
        System.out.println(outputStr("3[ab]2[c]ef"));
    }

    public static String outputStr(String str){
        if(str==null||str.length()<1){
            return "";
        }
//        List tempTime = new ArrayList();
        StringBuffer tempOutPut = new StringBuffer();
        StringBuffer foutput = new StringBuffer();
        StringBuffer times = new StringBuffer();
        Stack strStack = new Stack();
        char left = '[';
        char right = ']';
        for(int i=0;i<str.length();i++){
            char t = str.charAt(i);
            if (right == t){
                while(!strStack.isEmpty()){
                    char s = (char) strStack.pop();
                    if(Character.isDigit(s)){
                        times.append(s);
                    } else if(Character.isAlphabetic(s)&&times.length()>0){
                        strStack.push(s);
                        for(int j  = 0;j<new Integer(times.toString());j++){
                            for(int m = 0; m<tempOutPut.length();m++){
                                strStack.push(tempOutPut.charAt(m));
                            }
                        }

                        times = new StringBuffer();
                        tempOutPut = new StringBuffer();
                        break;
                    }else if (left == s){
                        tempOutPut = tempOutPut.reverse();
                    }else{
                        tempOutPut.append(s);
                    }
                }
                if(times!=null&&times.length()>0){
                    for(int j  = 0;j<new Integer(times.toString());j++){
                        for(int m = 0; m<tempOutPut.length();m++) {
                            strStack.push(tempOutPut.charAt(m));
                        }
                    }
                    times = new StringBuffer();
                    tempOutPut = new StringBuffer();
                }
            }else{
                strStack.push(t);
            }

        }

        while(!strStack.isEmpty()){
            foutput.append(strStack.pop());
        }
        return foutput.reverse().toString();
    }

}
