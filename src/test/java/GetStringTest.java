import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetStringTest {

    @Test
    public void shouldDecodeToString() {
        assertEquals("x", Task.getString("x"));
        assertEquals("x", Task.getString("1[x]"));
        assertEquals("xxz", Task.getString("2[x]z"));
        assertEquals("xzzxzz", Task.getString("2[x2[z]]"));
        assertEquals("axzzaxzza", Task.getString("a2[x2[z]a]"));
        assertEquals("xyzqqqzqqqexyzqqqzqqqep", Task.getString("2[xy2[z3[q]]e]p"));
    }

}