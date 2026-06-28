import java.util.Stack;

public class StockSpanner {

    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }

    public static void main(String[] args) {

        StockSpanner spanner = new StockSpanner();

        System.out.println(spanner.next(100)); // 1
        System.out.println(spanner.next(80));  // 1
        System.out.println(spanner.next(60));  // 1
        System.out.println(spanner.next(70));  // 2
        System.out.println(spanner.next(60));  // 1
        System.out.println(spanner.next(75));  // 4
        System.out.println(spanner.next(85));  // 6
    }
}