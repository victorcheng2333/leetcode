package dp;

public class CoinChange {

  // https://leetcode.com/problems/coin-change-2/
  // 多少种组合方式，不能重复
  public int change(int amount, int[] coins) {
    int[][] d = new int[coins.length+1][amount+1];
    for (int i = 0; i <= coins.length; ++i) d[i][0] = 1;

    for (int i = 1; i <= coins.length; ++i) {
      for (int j = 1; j <= amount; ++j) {
        int useCurCoin = j >= coins[i-1] ? d[i][j-coins[i-1]] : 0;
        d[i][j] = d[i-1][j] + useCurCoin;
      }
    }
    return d[coins.length][amount];
  }

  public int coinCombination(int[] coins, int start, int sum) {
    if (sum == 0) return 1;
    if (sum < 0) return 0;
    int result = 0;
    for (int i = start; i < coins.length; i++) {
      result += coinCombination(coins, i, sum - coins[i]);
    }
    return result;
  }

  public int coinChangeRecursive(int amount, int[] coins) {
    return coinCombination(coins, 0, amount);
  }
}
