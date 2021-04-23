package queue;

class MyCircularQueue {

    private int[] q;
    private int k;
    private int head;
    private int tail;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        q = new int[k];
        this.k = k;
        head = -1;
        tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;

        if (isEmpty()) head++;
        tail = (tail+1) % k;
        q[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        q[head] = 0;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head+1) % k;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : q[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : q[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (head == tail) && (head == -1);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((tail+1)%k) == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */