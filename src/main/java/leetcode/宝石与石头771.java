package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/11/26 20:37
 * @version: 1.0
 */
public class 宝石与石头771 {
  /*   
    给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

    J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

    示例 1:

    输入: J = "aA", S = "aAAbbbb"
    输出: 3
    示例 2:

    输入: J = "z", S = "ZZ"
    输出: 0
    注意:

    S 和 J 最多含有50个字母。
    J 中的字符不重复。
    */

    public static void main(String[] args) {
        System.out.println(numJewelsInStones1("aAb", "aAAbbbb"));
    }

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (String.valueOf(J.charAt(i)).equals(String.valueOf(S.charAt(j)))) {
                    ++count;
                }
            }
        }

        return count;
    }

    public static int numJewelsInStones1(String J, String S) {
        int count = 0;
        Set<Character> jSet = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jSet.add(J.charAt(i));
        }

        for (int i = 0; i < S.length(); i++) {
            if (jSet.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}
