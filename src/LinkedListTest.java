import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.*;

public class LinkedListTest {
    LinkedList<String> stringLinkedList;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        stringLinkedList = new LinkedList<>();
    }

    @Test
    public void isEmpty_whenItIsEmpty_returnTrue() {
        assertTrue(stringLinkedList.isEmpty());
    }

    @Test
    public void isEmpty_whenThereIsAnElement_returnFalse() {
        stringLinkedList.addFirst("Pouya");

        assertFalse(stringLinkedList.isEmpty());
    }

    @Test
    public void getFirst_shouldReturnTheFirstNodeElement() {
        stringLinkedList.addFirst("Pouya");

        assertEquals(stringLinkedList.getFirst(), "Pouya");
    }

    @Test
    public void removeFirst_shouldRemoveTheFistElement() {
        stringLinkedList.addFirst("Pouya");

        stringLinkedList.removeFirst();

        assertTrue(stringLinkedList.isEmpty());
    }

    @Test
    public void removeFirst_shouldRemoveTheFistElement2() {
        stringLinkedList.addFirst("Falon");
        stringLinkedList.addFirst("Pouya");

        stringLinkedList.removeFirst();

        assertEquals(stringLinkedList.getFirst(), "Falon");
    }

    @Test
    public void addLast_shouldAddToEndOfLinkedList() {
        stringLinkedList.addLast("Falon");
        stringLinkedList.addLast("Pouya");

        assertEquals(stringLinkedList.size(), 2);

        stringLinkedList.removeFirst();

        assertEquals(stringLinkedList.size(), 1);

        assertEquals(stringLinkedList.getFirst(), "Pouya");
    }

    @Test
    public void getLast_shouldReturnTheLastItem() {
        stringLinkedList.addLast("Falon");
        stringLinkedList.addLast("Pouya");

        assertEquals(stringLinkedList.size(), 2);

        assertEquals(stringLinkedList.getLast(), "Pouya");
    }

    @Test
    public void removeLast_shouldRemoveTheLastItem() {
        stringLinkedList.addLast("Falon");
        stringLinkedList.addLast("Pouya");

        assertEquals(stringLinkedList.size(), 2);

        stringLinkedList.removeLast();

        assertEquals(stringLinkedList.size(), 1);

        assertEquals(stringLinkedList.getLast(), "Falon");
    }

    @Test
    public void contains_shouldReturnTrueIfItContainsTheItem() {
        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        assertTrue(stringLinkedList.contains("Pouya"));
        assertFalse(stringLinkedList.contains("Edwin"));
    }

    @Test
    public void get_shouldReturnTheValueOfThatPosition() {
        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        assertEquals(stringLinkedList.get(1), "Pouya");
    }

    @Test
    public void get_ifThePositionIsBiggerThanArray_shouldThrowException() {
        thrown.expect(IndexOutOfBoundsException.class);

        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        stringLinkedList.get(5);
    }

    @Test
    public void insertAfter_whenInsertAfterAKeyToFind_shouldInsertItAfterThat() {
        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        stringLinkedList.insertAfter("Pouya", "Edwin");

        assertEquals(stringLinkedList.get(2), "Edwin");
    }

    @Test
    public void insertAfter_whenInsertAfterAKeyThatDoesNotExist_shouldDoNothing() {
        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        stringLinkedList.insertAfter("pk", "Edwin");

        assertEquals(stringLinkedList.get(2), "Behnam");
    }

    @Test
    public void insertBefore_whenInsertAfterAKeyToFind_shouldInsertItAfterThat() {
        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        stringLinkedList.insertBefore("Pouya", "Edwin");

        assertEquals(stringLinkedList.get(1), "Edwin");
    }

    @Test
    public void insertBefore_whenInsertAfterAKeyThatDoesNotExist_shouldDoNothing() {
        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        stringLinkedList.insertBefore("pk", "Edwin");

        assertEquals(stringLinkedList.get(2), "Behnam");
    }

    @Test
    public void remove_whenAKeyPass_shouldRemoveThatNode() {
        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        stringLinkedList.remove("Pouya");

        assertEquals(stringLinkedList.get(0), "Ali");
        assertEquals(stringLinkedList.get(1), "Behnam");
    }

    @Test
    public void toString_shouldReturnTheToStringOfTheLinkedList() {
        stringLinkedList.addLast("Ali");
        stringLinkedList.addLast("Pouya");
        stringLinkedList.addLast("Behnam");

        System.out.println(stringLinkedList.toString());
    }
}