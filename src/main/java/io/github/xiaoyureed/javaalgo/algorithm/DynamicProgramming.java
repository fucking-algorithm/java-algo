package io.github.xiaoyureed.javaalgo.algorithm;

/**
 * @author : xiaoyureed
 * 2020/7/12
 */
public class DynamicProgramming {


}

/**
 * 斐波那契数列
 */
class Fib {
    /**
     * 暴力递归
     *
     * O(2^n)
     */
    int fib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n  - 2);
    }

    /**
     * 使用一个数组作为备忘录
     */
    int fibMemo(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 0;
        }
        if (memo[n] != 0) return memo[n];
        memo[n] = fib(n);
        return memo[n];
    }

    /**
     * 使用一个数组直接存储 fib 数列
     */
    int fibDpTable(int n) {
        int[] dp_table = new int[n + 1];
        dp_table[0] = 0;
        dp_table[1] = 1;
        dp_table[2] = 1;
        for (int i = 3; i <= dp_table.length - 1; i++) {
            dp_table[i] = dp_table[i - 1] + dp_table[i - 2];
        }

        return dp_table[n];
    }

}

class CoinsProblem {
    /**
     * 硬币问题：各种面值的硬币无限个，凑出 amount，最少需要多少个硬币
     * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1
     *
     * @author xiaoyu
     * Date 2020-6-16
     */
    // 由于硬币数量无限，所以唯一的状态就是目标金额 amount
    // 状态方程 coins_dp(amount)
    int coinsChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int result = Integer.MAX_VALUE;
        // 尝试每个面值的硬币， 找到凑足 amount 所需个数最少的那个面值
        for (int i = 0; i < coins.length - 1; i++) {
            int coin = coins[i];

            // 子问题 （要符合「最优子结构」，子问题间必须互相独立）
            final int sub_problem = coinsChange(coins, amount - coin);

            // # 子问题无解，跳过
            if (sub_problem == -1) continue;

            result = Math.min(result, sub_problem + 1);
        }

        if (result != Integer.MAX_VALUE) {
            return result;
        } else return -1;
    }

    int coins_dp_table(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // initial dp table
        //为啥 dp 数组初始化为 amount + 1 呢，因为凑成 amount 金额的硬币数最多
        // 只可能等于 amount（全用 1 元面值的硬币），所以初始化为 amount + 1
        // 就相当于初始化为正无穷，便于后续取最小值
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 在求所有子问题 + 1 的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) continue;

                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];

    }
}