import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<AnyType> implements Iterable<AnyType> {
    private Node<AnyType> head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(AnyType item) {
        head = new Node(item, head);
    }

    public AnyType getFirst() {
        if (head == null) {
            throw new NoSuchElementException("don't exist");
        }

        return head.data;
    }

    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("don't exist");
        }

        head = head.next;
    }

    public void addLast(AnyType item) {
        if (head == null) {
            addFirst(item);
        } else {
            Node<AnyType> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            Node<AnyType> last = new Node(item, null);
            temp.next = last;
        }
    }

    public AnyType getLast() {
        Node<AnyType> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.data;
    }

    public void removeLast() {
        Node<AnyType> temp = head;
        Node<AnyType> beforeLast = temp;

        while (temp.next != null) {
            beforeLast = temp;
            temp = temp.next;
        }

        beforeLast.next = null;
    }

    public boolean contains(AnyType item) {

        for (AnyType data : this) {
            if (data.equals(item)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        int counter = 0;

        for (AnyType node : this) {
            counter++;
        }

        return counter;
    }

    public AnyType get(int position) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<AnyType> temp = head;

        for (int i = 0; i < position && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            throw new IndexOutOfBoundsException();
        }

        return temp.data;
    }

    public void insertAfter(AnyType key, AnyType toInsert) {
        if (head == null) return;

        Node<AnyType> temp = head;

        while (temp.next != null) {
            if (temp.data.equals(key)) {
                Node<AnyType> newNode = new Node<>(toInsert, temp.next);
                temp.next = newNode;
            }

            temp = temp.next;
        }
    }

    public void insertBefore(AnyType key, AnyType toInsert) {
        if (head == null) return;

        Node<AnyType> temp = head;
        Node<AnyType> nodeBefore = head;

        while (temp.next != null) {
            if (temp.data.equals(key)) {
                nodeBefore.next = new Node<>(toInsert, temp);
            }

            nodeBefore = temp;
            temp = temp.next;
        }
    }

    public void remove(AnyType key) {
        if (head == null) return;

        Node<AnyType> temp = head;
        Node<AnyType> nodeBefore = head;

        while (temp.next != null) {
            if (temp.data.equals(key)) {
                nodeBefore.next = temp.next;
            }

            nodeBefore = temp;
            temp = temp.next;
        }
    }

    public LinkedList<AnyType> reverse() {
        LinkedList<AnyType> reverse = new LinkedList<>();

        Node<AnyType> temp = head;
        while (temp != null) {
            reverse.addFirst(temp.data);

            temp = temp.next;
        }

        return reverse;
    }

    public LinkedList<AnyType> deepCopyOne() {
        LinkedList<AnyType> deepCopy = new LinkedList<>();

        Node<AnyType> temp = head;
        while (temp != null) {
            deepCopy.addLast(temp.data);

            temp = temp.next;
        }

        return deepCopy;
    }

    public LinkedList<AnyType> deepCopyTwo() {
        LinkedList<AnyType> deepCopy = new LinkedList<>();

        Node<AnyType> temp = head;
        while (temp != null) {
            deepCopy.addFirst(temp.data);

            temp = temp.next;
        }

        return deepCopy.reverse();
    }

    public LinkedList<AnyType> deepCopyImmutable() {
        LinkedList<AnyType> deepCopyImmutable = new LinkedList<>();

        if (head == null) return null;

        Node<AnyType> temp = head;

        deepCopyImmutable.head = new Node<>(head.data, null);

        Node<AnyType> tempDeepCopyImmutable = deepCopyImmutable.head;

        while (temp.next != null) {
            tempDeepCopyImmutable.next = new Node<>(temp.data, null);
            tempDeepCopyImmutable = tempDeepCopyImmutable.next;
            temp = temp.next;
        }

        return deepCopyImmutable;
    }

    private static class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> nodeNext;

        public LinkedListIterator() {
            nodeNext = head;
        }

        @Override
        public boolean hasNext() {
            return nodeNext != null;
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AnyType result = nodeNext.data;
            nodeNext = nodeNext.next;
            return result;
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for(AnyType o : this) {
            result.append(o + " ");
        }

        return result.toString();
    }
}
