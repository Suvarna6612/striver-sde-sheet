import java.util.*;

class Solution {

    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, long cap) {

        int n = val.length;

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(items, (a, b) ->
            Double.compare(
                (double)b.value / b.weight,
                (double)a.value / a.weight
            )
        );

        double totalValue = 0.0;

        for (Item item : items) {

            if (cap >= item.weight) {

                totalValue += item.value;
                cap -= item.weight;

            } else {

                totalValue += ((double)item.value / item.weight) * cap;
                break;
            }
        }

        return totalValue;
    }
}