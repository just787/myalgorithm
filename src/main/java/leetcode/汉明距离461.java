package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/10 22:35
 * @version: 1.0
 */
public class 汉明距离461 {
/*
    两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

    给出两个整数 x 和 y，计算它们之间的汉明距离。

    注意：
            0 ≤ x, y < 231.

    示例:

    输入: x = 1, y = 4

    输出: 2

    解释:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑

    上面的箭头指出了对应二进制位不同的位置。
*/

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance1(1, 4));
        System.out.println(hammingDistance2(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        // 异或 之后得到二进制不同位数 的整数值
        int z = x ^ y;
        while (z != 0) {
            // 和1做与运算 当二进制数的最后一位是1时得到的结果也是1
            if ((z & 1) == 1) {
                count++;
            }

            // 右移1位
            z = z >> 1;
        }
        return count;
    }

    public static int hammingDistance1(int x, int y) {
        // 异或 之后得到二进制不同位数 的整数值
        int z = x ^ y;
        return Integer.bitCount(z);
    }

    public static int hammingDistance2(int x, int y) {
        int count = 0;
        // 异或 之后得到二进制不同位数 的整数值
        int z = x ^ y;
        while (z != 0) {
            if (z % 2 != 0) {
                count++;
            }

            // 右移1位
            z = z >> 1;
        }
        return count;
    }
}
