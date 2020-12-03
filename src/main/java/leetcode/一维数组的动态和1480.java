package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/11/11 20:33
 * @version: 1.0
 */
public class 一维数组的动态和1480 {
    /*给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

    请返回 nums 的动态和。
   

    示例 1：

    输入：nums = [1,2,3,4]
    输出：[1,3,6,10]
    解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
    示例 2：

    输入：nums = [1,1,1,1,1]
    输出：[1,2,3,4,5]
    解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
    示例 3：

    输入：nums = [3,1,2,10,1]
    输出：[3,4,6,16,17]
             

    提示：

            1 <= nums.length <= 1000
            -10^6 <= nums[i] <= 10^6
    */


    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(runningSum1(nums)));
    }

    public static int[] runningSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += map.get(j);
            }

            nums[i] = sum;
        }

        return nums;
    }

    public static int[] runningSum1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
