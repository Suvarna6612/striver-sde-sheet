
import java.util.Stack;

class Solution {

    public void sortStack(Stack<Integer> st) {

        if (st.isEmpty())
            return;

        int top = st.pop();

        sortStack(st);

        insertSorted(st, top);
    }

    private void insertSorted(Stack<Integer> st, int num) {

        if (st.isEmpty() || st.peek() <= num) {
            st.push(num);
            return;
        }

        int top = st.pop();

        insertSorted(st, num);

        st.push(top);
    }
}