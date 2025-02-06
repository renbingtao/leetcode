package greedy;

import org.junit.jupiter.api.Test;

public class Jump2 {

    @Test
    public void test() {
        int jump = jump(new int[]{2, 2, 2, 1, 1, 10, 1, 1, 1});
        System.out.println(jump);
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int totalSteps = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < maxPos) {
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) {
                    return totalSteps + 1;
                }
                if ((i + j + nums[i + j]) > maxPos + nums[maxPos]) {
                    maxPos = i + j;
                }
            }
            totalSteps++;
        }
        return totalSteps;
    }

}
