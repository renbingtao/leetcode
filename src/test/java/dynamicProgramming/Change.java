package dynamicProgramming;

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。



示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0


提示：

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */

import org.junit.jupiter.api.Test;

public class Change {

    @Test
    public void test() {
        int[] coins = new int[]{1};
        int amount = 0;
        int i = coinChange(coins, amount);
        System.out.println(i);


        int[] sq = new int[100];
        for (int k = 1; k <= 100; k++) {
            sq[k - 1] = k;
        }
    }

    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        for (int i = 0; i < minCoins.length; i++) {
            minCoins[i] = amount + 1;
        }

        for (int i = 0; i <= amount; i++) {
            if (i == 0) {
                minCoins[i] = 0;
            }
            for (int j = 0; j < coins.length; j++) {
                int curCoin = coins[j];
                if (i >= curCoin) {
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - curCoin] + 1);
                }
            }
        }

        return minCoins[amount] == amount + 1 ? -1 : minCoins[amount];
    }

}
