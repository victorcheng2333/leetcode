package coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MyCode {

    public static void main (String[] args) {
        List<Integer> coins = new ArrayList(Arrays.asList(1, 2, 5));
        int amount = 11;

        System.out.println(new MyCode().minCombines(coins, amount, 0, 0));
    }

    int minCombines(List<Integer> coins, int amount, int count, int coinMax) {
        Collections.sort(coins, (a, b) -> b - a);
        System.out.println(coins);
        if (amount == 0) {
            return count;
        } else if (amount < 0) {
            if(coinMax == coins.size()) return -1;
            amount += coins.get(coinMax);
            count--;
            coinMax++;
            minCombines(coins, amount - coins.get(coinMax), count, coinMax);
        } else if (amount > 0) {
            count++;
            minCombines(coins, amount - coins.get(coinMax), count, coinMax);
        }
        return 0;
    }

}

