package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/9 21:53
 * @version: 1.0
 */
public class 分割平衡字符串1221 {
/*
    在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。

    给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。

    返回可以通过分割得到的平衡字符串的最大数量。

    示例 1：

    输入：s = "RLRRLLRLRL"
    输出：4
    解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
    示例 2：

    输入：s = "RLLLLRRRLR"
    输出：3
    解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
    示例 3：

    输入：s = "LLLLRRRR"
    输出：1
    解释：s 只能保持原样 "LLLLRRRR".
             

    提示：

    1 <= s.length <= 1000
    s[i] = 'L' 或 'R'
    分割得到的每个字符串都必须是平衡字符串。
*/

    public static void main(String[] args) {
        System.out.println(balancedStringSplit1("RLLLLRRRLR"));
    }

    public static int balancedStringSplit(String s) {
        int count = 0;
        Deque<String> stack = new LinkedList<String>();
        for (int i = 0; i < s.length(); i++) {
            String temp = stack.size() > 0 ? stack.getLast() : null;
            if (temp == null || String.valueOf(s.charAt(i)).equals(temp)) {
                stack.add(String.valueOf(s.charAt(i)));
            } else {
                stack.pollLast();
            }
            if (stack.size() == 0) {
                count++;
            }
        }

        return count;
    }


    public static int balancedStringSplit1(String s) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                temp++;
            } else {
                temp--;
            }
            if (temp == 0) {
                count++;
            }
        }
        return count;
    }

    // byte8 shot16 int32 long64 float32 double64 char16 boolean1
}
