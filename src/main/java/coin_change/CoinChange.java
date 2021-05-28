package coin_change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class CoinChange {
    // 求解多少种coin change 组合
    public int change(int[] coins, int amount) {
        return -1;
    }

    // 动态规划
    public int getMinCoinChange(int[] coins, int amount) {
        // dp[i] 表示当兑换目标金额为i时，至少需要dp[i]个硬币才能凑出
        // dp 问题的特性：
        // 1. 重叠子问题
        // 2. 无后效性
        // 3. 最优子结构
        var dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (var i = 0; i < amount+1; i++) {
            // 模拟无穷大， 这里不用 Integer.MAX_VALUE, 其数值+1会越界
            var minCount = amount + 1;
            for (var j = 0; j < coins.length; j++) {
                var currentValue = coins[j];
                // 如果当前面值大于总额，则跳过
                if (currentValue > i) continue;
                // 假如使用了当前面值，那可以得到剩余面值总额及其所需的最少硬币个数
                var rest = i - currentValue;
                var restCount = dp[rest];
                // 假如剩余面值组合不可信，直接跳过
                if (restCount == -1) continue;

                // 迭代挑出最小硬币数
                var currentCount = restCount + 1;
                if (currentCount < minCount) minCount = currentCount;
            }
            // 这一轮决策结束，写回dp数组以便后续继续迭代
            if (minCount != amount+1) dp[i] = minCount;
        }
        return dp[amount];
    }

    // 暴力递归， 找到所有组合
    void getAllCombinations(int total, int[] values, List<Integer> currentCounts,
                        List<List<Integer>> combinations) {
        if (0 == total) { // 如果余额为0，说明当前组合成立，将组合假如待选数组中
            combinations.add(new ArrayList<>(currentCounts));
            return;
        }
        for (var i = 0; i < values.length; i ++) {
            var currentValue = values[i];
            if (currentValue > total) {// 当前面值大于总额，直接跳过
                continue;
            }
            // 用一个当前的硬币
            var newCounts = new ArrayList<>(currentCounts);
            newCounts.set(i, newCounts.get(i)+1);
            var rest = total - currentValue;
            getAllCombinations(rest, values, newCounts, combinations);
        }
    }

    int getMinCoinChangeByForce(int[] coins, int amount) {
        var initialCounts = new ArrayList<>(Collections.nCopies(coins.length, 0));
        List<List<Integer>> combinations = new ArrayList<>();
        getAllCombinations(amount, coins, initialCounts, combinations);
        if (combinations.size() == 0) return -1; // 无有效组合
        var minCount = Integer.MAX_VALUE;
        for (var counts : combinations) {
            System.out.println(counts);
            var total = 0;
            for (var count : counts) total += count;
            if (total < minCount) minCount = total;
        }
        return minCount;
    }

    public static void main(String[] args) {
        var amount = 100;
        var coins = new int[]{1, 2, 5};
//        var minCount = new CoinChange().getMinCoinChangeByForce(coins, amount);
        var minCount = new CoinChange().getMinCoinChange(coins, amount);
        System.out.println(minCount);
    }

}

