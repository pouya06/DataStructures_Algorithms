import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    HashTable<String> subject;

    @Before
    public void setUp() {
        subject = new HashTable<>();
    }

    @Test
    public void add_shouldAddTheNewStringIntoTheRightSpot() {
        subject.add("Aa");
        subject.add("BB");

        assertTrue(subject.contains("Aa"));

        System.out.println(subject.toString());
    }
}