import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {
    MinHeap<Integer> subject;

    @Before
    public void setUp() {
        subject = new MinHeap<>();
    }

    @Test
    public void insert_shouldInsertInMinHeap() {
        subject.insert(5);
        subject.insert(8);
        subject.insert(4);
        subject.insert(7);
        subject.insert(9);
        subject.insert(2);
        subject.insert(1);
        subject.insert(3);

        subject.remove();

        System.out.print(subject.toString());
    }
}