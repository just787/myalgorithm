package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/10 21:54
 * @version: 1.0
 */
public class 转换成小写字母709 {
/*
    实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

    示例 1：

    输入: "Hello"
    输出: "hello"
    示例 2：

    输入: "here"
    输出: "here"
    示例 3：

    输入: "LOVELY"
    输出: "lovely"
*/


    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public String toLowerCase1(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            // a-z：97-122  A-Z：65-90  0-9：48-57
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + 'a'));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
