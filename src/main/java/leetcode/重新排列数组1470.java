package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/11/19 20:14
 * @version: 1.0
 */
public class 重新排列数组1470 {
    /*
    给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

    请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

    示例 1：

    输入：nums = [2,5,1,3,4,7], n = 3
    输出：[2,3,5,4,1,7]
    解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
    示例 2：

    输入：nums = [1,2,3,4,4,3,2,1], n = 4
    输出：[1,4,2,3,3,2,4,1]
    示例 3：

    输入：nums = [1,1,2,2], n = 2
    输出：[1,2,1,2]
             

    提示：

    1 <= n <= 500
    nums.length == 2n
    1 <= nums[i] <= 10^3
    */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(Arrays.toString(shuffle(nums, 4)));
    }


    public static int[] shuffle(int[] nums, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && i != nums.length - 1) {
                if (i < n) {
                    nums[i + i] = map.get(i);
                } else {
                    nums[i - (--n)] = map.get(i);
                }
            }
        }

        return nums;
    }


    public static int[] shuffle1(int[] nums, int n) {
        // x1,y1,x2,y2, x3,y3,x4,y4,xn,yn 

        int[] ret = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ret[i * 2] = nums[i];
            ret[i * 2 + 1] = nums[n + i];
        }

        return ret;
    }
}
