package dynamicProgramming.media;

/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。


提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */

import org.junit.jupiter.api.Test;

public class DivideEqualSumSubsets {

    @Test
    public void test() {
        int[] arr = new int[]{0, 2, 1};
        boolean b = canPartition(arr);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;

        return true;
    }

}
