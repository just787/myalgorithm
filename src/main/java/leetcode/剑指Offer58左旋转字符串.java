package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/8 23:32
 * @version: 1.0
 */
public class 剑指Offer58左旋转字符串 {
/*

    字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

    示例 1：

    输入: s = "abcdefg", k = 2
    输出: "cdefgab"
    示例 2：

    输入: s = "lrloseumgh", k = 6
    输出: "umghlrlose"

    限制：

    1 <= k < s.length <= 10000
*/


    public static void main(String[] args) {
        System.out.println(reverseLeftWords1("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {

        return s.substring(n).concat(s.substring(0, n));
    }

    public static String reverseLeftWords1(String s, int n) {

        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (i < n) {
                sb1.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.append(sb1).toString();
    }
}
