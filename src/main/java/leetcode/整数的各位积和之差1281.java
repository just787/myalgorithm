package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/1 21:31
 * @version: 1.0
 */
public class 整数的各位积和之差1281 {
/*
    给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。

    示例 1：

    输入：n = 234
    输出：15
    解释：
    各位数之积 = 2 * 3 * 4 = 24
    各位数之和 = 2 + 3 + 4 = 9
    结果 = 24 - 9 = 15
    示例 2：

    输入：n = 4421
    输出：21
    解释：
    各位数之积 = 4 * 4 * 2 * 1 = 32
    各位数之和 = 4 + 4 + 2 + 1 = 11
    结果 = 32 - 11 = 21

    提示：

    1 <= n <= 10^5
*/

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        int a = 1;
        int b = 0;

        for (; n != 0; n = n / 10) {
            int c = n % 10;
            a *= c;
            b += c;
        }

        return a - b;
    }
}
