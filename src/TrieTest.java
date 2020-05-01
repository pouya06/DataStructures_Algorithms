import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    private Trie subject;

    @Before
    public void setUp() {
        subject = new Trie();
    }

    @Test
    public void insert_shouldAddTheNewWord() {
        subject.insert("pouya");
        subject.insert("po");
        subject.insert("ali");
        subject.insert("poop");

        System.out.println("pouya is " + subject.search("pouya"));
        System.out.println("falon is " + subject.search("falon"));
    }
}