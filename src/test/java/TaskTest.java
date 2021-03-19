import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testValidator() {
        assertFalse(Task.isValid("3"));
        assertFalse(Task.isValid("["));
        assertFalse(Task.isValid("]"));
        assertFalse(Task.isValid("[]"));
        assertFalse(Task.isValid("3[]"));
        assertFalse(Task.isValid("3[a["));
        assertFalse(Task.isValid("2[a]]"));

        assertTrue(Task.isValid("x"));
        assertTrue(Task.isValid("x2[a]"));
        assertTrue(Task.isValid("x2[a]y"));
        assertTrue(Task.isValid("12[a2[y]b]"));
        assertTrue(Task.isValid("12[a2[y]b]z"));
        assertTrue(Task.isValid("12[a2[y]b3[c]d]"));
    }

    @Test
    public void testGetString() {
        assertEquals("x", Task.getString("x"));
        assertEquals("x", Task.getString("1[x]"));
        assertEquals("xxz", Task.getString("2[x]z"));
        assertEquals("xzzxzz", Task.getString("2[x2[z]]"));
        assertEquals("axzzaxzza", Task.getString("a2[x2[z]a]"));
        assertEquals("xyzqqqzqqqexyzqqqzqqqep", Task.getString("2[xy2[z3[q]]e]p"));
    }
}
