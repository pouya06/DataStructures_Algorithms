import java.util.Arrays;

public class MinHeap<T extends Number> {
    private Integer[] heap;
    private int size;

    public MinHeap() {
        heap = new Integer[10];
        size = 0;
    }


    public void insert(int data) {
        if (size > heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size++] = data;
        shiftingUp();
    }

    public int remove() {
        int returnValue = heap[0];
        heap[0] = heap[--size];
        heap[size] = null;

        shiftingDown();
        return returnValue;
    }

    private void shiftingDown() {
        int posOfParent = 0;
        int posLeftChild;
        int posRightChild;

        while (posOfParent < size) {
            posLeftChild = leftChild(posOfParent);
            posRightChild = rightChild(posOfParent);
            if (heap[posLeftChild] != null && heap[posRightChild] != null) {
                if (heap[posLeftChild] < heap[posRightChild]) {
                    if (heap[posOfParent] > heap[posLeftChild]) {
                        swap(posLeftChild, posOfParent);
                        posOfParent = posLeftChild;
                        continue;
                    }
                } else {
                    if (heap[posOfParent] > heap[posRightChild]) {
                        swap(posRightChild, posOfParent);
                        posOfParent = posRightChild;
                        continue;
                    }
                }
            } else if (heap[posLeftChild] != null && heap[posRightChild] == null) {
                if (heap[posLeftChild] < heap[posRightChild]) {
                    if (heap[posOfParent] > heap[posLeftChild]) {
                        swap(posLeftChild, posOfParent);
                        posOfParent = posLeftChild;
                        continue;
                    }
                }
            } else {
                break;
            }
        }
    }

    private void shiftingUp() {
        int positionOfAddedChild = size - 1;
        int parentOfThatChild = parent(positionOfAddedChild);

        while (positionOfAddedChild > 0) {
            if (heap[positionOfAddedChild] < heap[parentOfThatChild]) {
                swap(positionOfAddedChild, parentOfThatChild);
            }

            positionOfAddedChild = parentOfThatChild;
            parentOfThatChild = parent(positionOfAddedChild);
        }
    }


    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (pos * 2) + 1;
    }

    private int rightChild(int pos) {
        return (pos * 2) + 2;
    }

    private void swap(int nodeOne, int nodeTwo) {
        int temp = heap[nodeOne];
        heap[nodeOne] = heap[nodeTwo];
        heap[nodeTwo] = temp;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(heap[i] + " ");
        }

        return stringBuffer.toString();
    }
}
