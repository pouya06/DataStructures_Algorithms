import java.util.NoSuchElementException;

public class DoublyLinkedList<AnyType> {
    private Node<AnyType> head;
    private int size;

    public DoublyLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(AnyType data) {
        if (head == null) {
            head = new Node(data, null, null);
        } else {
            Node<AnyType> temp = head;
            head = new Node(data, head, null);
            temp.prev = head;
        }
        size++;
    }

    public AnyType getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        return head.data;
    }

    // remove first
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        head = head.next;
        size--;
    }

    // add last
    public void addLast(AnyType data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node<AnyType> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            Node<AnyType> newNode = new Node<>(data, null, temp);
            temp.next = newNode;
            size++;
        }
    }

    // get last
    public AnyType getLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<AnyType> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.data;
    }

    // remove last
    public void removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<AnyType> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }

    public void addBefore(AnyType key, AnyType data) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<AnyType> temp = head;

        while (temp != null) {
            if (temp.data.equals(key)) {
                Node<AnyType> newNode = new Node<>(data, temp, temp.prev);
                temp.prev.next = newNode;
                temp.prev = newNode;
                size++;
                break;
            }
            temp = temp.next;
        }
    }

    public void addAfter(AnyType key, AnyType data) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<AnyType> temp = head;

        while (temp != null) {
            if (temp.data.equals(key)) {
                Node<AnyType> newNode = new Node<>(data, temp.next, temp);
                temp.next = newNode;
                temp.next.prev = newNode;
                size++;
            }
            temp = temp.next;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer string = new StringBuffer();

        Node<AnyType> temp = head;

        while (temp != null) {
            string.append(temp.data + " -- ");
            temp = temp.next;
        }

        return string.toString();
    }

    private static class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> next;
        private Node<AnyType> prev;

        public Node(AnyType data, Node<AnyType> next, Node<AnyType> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
