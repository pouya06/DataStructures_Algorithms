import java.util.NoSuchElementException;

public class Stack<T> {
    private StackNode<T> top;

    public Stack() {
        top = null;
    }

    public void push(T data) {
        StackNode<T> newNode = new StackNode<>(data, top);
        top = newNode;
    }

    public T pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }

        StackNode<T> temp = top;
        top = top.next;
        return temp.data;
    }

    public T peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data, StackNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
