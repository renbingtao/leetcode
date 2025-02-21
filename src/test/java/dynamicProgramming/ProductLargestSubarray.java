package dynamicProgramming;

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
子数组
（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

测试用例的答案是一个 32-位 整数。



示例 1:

输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。


提示:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
nums 的任何子数组的乘积都 保证 是一个 32-位 整数
*/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ProductLargestSubarray {

    @Test
    public void test() {
        int[] arr = new int[]{0, -2, 0};
        int i = maxProduct(arr);
        System.out.println(i);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        ArrayList<Integer> partitionList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(0, max);
                if (!partitionList.isEmpty()) {
                    max = Math.max(max, getMaxByList(partitionList));
                    partitionList.clear();
                }
            } else {
                partitionList.add(nums[i]);
            }
        }
        if (!partitionList.isEmpty()) {
            max = Math.max(max, getMaxByList(partitionList));
            max = Math.max(0, max);
        }
        return max;
    }

    private int getMaxByList(ArrayList<Integer> partitionList) {
        if (partitionList.size() == 1) {
            return partitionList.get(0);
        }
        boolean isZheng = true;
        int multi = 1;
        int firstFu = -1;
        int lastFu = -1;
        for (int i = 0; i < partitionList.size(); i++) {
            Integer cur = partitionList.get(i);
            multi = multi * cur;
            isZheng = isZheng == cur > 0;
            if (cur < 0) {
                if (firstFu == -1) {
                    firstFu = i;
                }
                lastFu = i;
            }
        }
        if (isZheng) {
            return multi;
        }
        int frontMulti = 1;
        if (firstFu != -1) {
            for (int i = 0; i <= firstFu; i++) {
                frontMulti = frontMulti * partitionList.get(i);
            }
        }
        int backMulti = 1;
        if (lastFu != -1) {
            for (int i = lastFu; i < partitionList.size(); i++) {
                backMulti = backMulti * partitionList.get(i);
            }
        }
        if (frontMulti > backMulti) {
            return multi / frontMulti;
        }
        return multi / backMulti;
    }

}
