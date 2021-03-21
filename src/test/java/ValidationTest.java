import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationTest {

    @Test
    public void shouldReturnFalseOnInvalidString() {
        assertFalse(Task.isValid("3"));
        assertFalse(Task.isValid("["));
        assertFalse(Task.isValid("]"));
        assertFalse(Task.isValid("[]"));
        assertFalse(Task.isValid("3[]"));
        assertFalse(Task.isValid("3[a["));
        assertFalse(Task.isValid("2[a]]"));
    }

    @Test
    public void shouldReturnTrueOnValidString(){
        assertTrue(Task.isValid("x"));
        assertTrue(Task.isValid("x2[a]"));
        assertTrue(Task.isValid("x2[a]y"));
        assertTrue(Task.isValid("12[a2[y]b]"));
        assertTrue(Task.isValid("12[a2[y]b]z"));
        assertTrue(Task.isValid("12[a2[y]b3[c]d]"));
    }
}