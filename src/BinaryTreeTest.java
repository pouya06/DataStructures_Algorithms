import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    private BinaryTree<Integer> subject;

    @Before
    public void setUp() {
        subject = new BinaryTree<>();
    }

    @Test
    public void insert_shouldInsertNodeInTheRightPlace() {
        subject.insert(10);
        subject.insert(5);
        subject.insert(20);
        subject.insert(3);
        subject.insert(7);
        subject.insert(30);

        subject.inOrderTraversal();
    }
}