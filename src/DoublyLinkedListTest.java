import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    private DoublyLinkedList<String> subject;

    @Before
    public void setUp() {
        subject = new DoublyLinkedList<>();
    }

    @Test
    public void addFirst_AddAnObjectAtFirst() {
        subject.addFirst("Ali");
        subject.addFirst("behnam");

        System.out.println(subject.toString());
    }

    @Test
    public void addLast_AddAnObjectToLast() {
        subject.addFirst("Ali");
        subject.addLast("behnam");
        subject.addLast("Pouya");

        System.out.println(subject.toString());
    }

    @Test
    public void addBefore_AddAnObjectBeforeAKey() {
        subject.addFirst("Ali");
        subject.addLast("Behnam");
        subject.addLast("Pouya");
        subject.addBefore("Pouya", "Falon");

        System.out.println(subject.toString());
    }

    @Test
    public void addAfter_AddAnObjectAfterAKey() {
        subject.addFirst("Ali");
        subject.addLast("Behnam");
        subject.addLast("Pouya");
        subject.addAfter("Pouya", "Falon");

        System.out.println(subject.toString());
    }
}