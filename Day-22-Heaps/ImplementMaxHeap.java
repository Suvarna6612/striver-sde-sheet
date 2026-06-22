import java.util.*;

class Solution {

    ArrayList<Integer> heap;

    public void initializeHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int key) {
        heap.add(key);

        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) < heap.get(i)) {
                Collections.swap(heap, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    public void changeKey(int index, int newVal) {
        heap.set(index, newVal);

        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(parent) < heap.get(index)) {
                Collections.swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }

        heapify(index);
    }

    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest))
            largest = left;

        if (right < heap.size() && heap.get(right) > heap.get(largest))
            largest = right;

        if (largest != i) {
            Collections.swap(heap, i, largest);
            heapify(largest);
        }
    }

    public void extractMax() {
        if (heap.isEmpty()) return;

        int last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heapify(0);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int getMax() {
        return heap.get(0);
    }

    public int heapSize() {
        return heap.size();
    }
}