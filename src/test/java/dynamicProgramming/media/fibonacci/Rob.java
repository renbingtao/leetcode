package dynamicProgramming.media.fibonacci;

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
偷窃到的最高金额 = 2 + 9 + 1 = 12 。


提示：

        1 <= nums.length <= 100
        0 <= nums[i] <= 400
*/

import org.junit.jupiter.api.Test;

public class Rob {

    @Test
    public void test() {
        int[] arr = new int[]{2, 7, 9, 3, 1};

        int rob = rob(arr);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxNums = new int[nums.length];
        for (int i = 0; i < maxNums.length; i++) {
            maxNums[i] = -1;
        }
        return Math.max(getMax(0, nums, maxNums), getMax(1, nums, maxNums));
    }


    private int getMax(int index, int[] nums, int[] maxNums) {
        //最后一个则退出
        if (index == nums.length - 1) {
            return nums[index];
        }

        if (maxNums[index] != -1) {
            return maxNums[index];
        }

        int left = index + 2 > nums.length - 1 ? 0 : getMax(index + 2, nums, maxNums);
        int right = index + 3 > nums.length - 1 ? 0 : getMax(index + 3, nums, maxNums);

        int res = nums[index] + Math.max(left, right);
        maxNums[index] = res;
        return res;
    }

}
