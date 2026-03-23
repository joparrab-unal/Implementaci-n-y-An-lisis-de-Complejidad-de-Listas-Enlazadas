public class MyQueue<T> {
    private Object[] data;
    private int front;
    private int size;
    public MyQueue() {
        data = new Object[10];
        front = 0;
        size = 0;
    }
    private void resize() {
        Object[] nuevo = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            nuevo[i] = data[(front + i) % data.length];
        }
        data = nuevo;
        front = 0;
    }
    public void enqueue(T x) {
        if (size == data.length) resize();
        int rear = (front + size) % data.length;
        data[rear] = x;
        size++;
    }
    public T dequeue() {
        if (isEmpty()) return null;
        T val = (T) data[front];
        front = (front + 1) % data.length;
        size--;
        return val;
    }
    public T front() {
        if (isEmpty()) return null;
        return (T) data[front];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void delete(T x) {
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % data.length;
            if (data[idx].equals(x)) {
                for (int j = i; j < size - 1; j++) {
                    int curr = (front + j) % data.length;
                    int next = (front + j + 1) % data.length;
                    data[curr] = data[next];
                }
                size--;
                return;
            }
        }
    }
}
