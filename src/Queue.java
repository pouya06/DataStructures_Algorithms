import java.util.NoSuchElementException;

public class Queue<T> {
    private QueueNode<T> first;
    private QueueNode<T> rear;

    public Queue() {
        first = null;
        rear = null;
    }

    public void add(T data) {
        QueueNode<T> newNode = new QueueNode<>(data, null);
        if (rear == null) {
            first = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;

        if (first == null) {
            rear = null;
        }

        return data;
    }

    public boolean isEmpty() {
        return first == null && rear == null;
    }

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data, QueueNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
