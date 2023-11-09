package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTest {

    @Test
    public void testConstructorWithValidPaletteSize() {
        ColourTable table = new ColourTable(8);
        assertNotNull(table);
    }

    @Test
    public void testConstructorWithInvalidPaletteSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(7));
    }

    @Test
    public void testAddColorToPalette() {
        ColourTable table = new ColourTable(4);
        table.add(255, 0, 0);
        assertEquals(1, table.getSize());
    }

    @Test
    public void testAddColorToFullPalette() {
        ColourTable table = new ColourTable(2);
        table.add(255, 0, 0);
        table.add(0, 255, 0);
        assertThrows(IllegalStateException.class, () -> table.add(0, 0, 255));
    }

    // You can add more test cases as needed to cover various scenarios.

}
