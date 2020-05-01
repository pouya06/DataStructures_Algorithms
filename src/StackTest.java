import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private Stack<String> subject;

    @Before
    public void setUp() {
        subject = new Stack<>();
    }

    @Test
    public void push_shouldPushDataIntoStack() {
        subject.push("Behnam");
        subject.push("Pouya");
        subject.push("Ali");

        subject.pop();
    }
}
