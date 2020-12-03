package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/11/23 20:39
 * @version: 1.0
 */
public class 好数对的数目1512 {
    /*
     给你一个整数数组 nums 。

     如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。

     返回好数对的数目。

     示例 1：

     输入：nums = [1,2,3,1,1,3]
     输出：4
     解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     示例 2：

     输入：nums = [1,1,1,1]
     输出：6
     解释：数组中的每组数字都是好数对
     示例 3：

     输入：nums = [1,2,3]
     输出：0
              

     提示：

             1 <= nums.length <= 100
             1 <= nums[i] <= 100
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ++count;
                }
            }
        }

        return count;
    }

    public int numIdenticalPairs1(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            // 根据排列组合，得公式：v * (v - 1) / 2
            ans += v * (v - 1) / 2;
        }

        return ans;
    }

}
