class ArrayQueue {

    int[] arr;
    int front;
    int rear;
    int size;

    public ArrayQueue() {
        size = 100001;
        arr = new int[size];
        front = 0;
        rear = 0;
    }

    public void push(int x) {
        arr[rear++] = x;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front++];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }
}