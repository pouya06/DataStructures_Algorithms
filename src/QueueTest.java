import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue<String> subject;

    @Before
    public void setUp() {
        subject = new Queue<>();
    }

    @Test
    public void add_shouldAddDataToTheBeginningOfQueue() {
        subject.add("Ali");
        subject.add("Pouya");
        subject.add("behnam");

        subject.remove();
    }
}