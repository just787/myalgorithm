package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/7 23:47
 * @version: 1.0
 */
public class 统计位数为偶数的数字1295 {
    /*
    给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。

    示例 1：

    输入：nums = [12,345,2,6,7896]
    输出：2
    解释：
            12 是 2 位数字（位数为偶数） 
            345 是 3 位数字（位数为奇数）  
            2 是 1 位数字（位数为奇数） 
            6 是 1 位数字 位数为奇数） 
            7896 是 4 位数字（位数为偶数）  
    因此只有 12 和 7896 是位数为偶数的数字
    示例 2：

    输入：nums = [555,901,482,1771]
    输出：1
    解释：
    只有 1771 是位数为偶数的数字。
             
    提示：

    1 <= nums.length <= 500
    1 <= nums[i] <= 10^5
*/

    public static void main(String[] args) {
        System.out.println(findNumbers1(new int[]{12,345,2,6,7896}));
    }

    public static int findNumbers(int[] nums) {

        int count = 0;
        for (int n : nums) {
            int c = 0;
            while (n != 0) {
                n /= 10;
                c++;
            }
            if (c % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static int findNumbers1(int[] nums) {

        int count = 0;
        for (int n : nums) {
           String s = String.valueOf(n);
            if (s.length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
