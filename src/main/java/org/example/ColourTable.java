package org.example;
import java.util.Arrays;
public class ColourTable {
    private int capacity;
    private int size;
    private RGBColor[] palette;

    public ColourTable(int numberOfColors) {
        if (!isValidPaletteSize(numberOfColors)) {
            throw new IllegalArgumentException("Invalid palette size");
        }
        capacity = numberOfColors;
        size = 0;
        palette = new RGBColor[capacity];
    }

    public void add(int red, int green, int blue) {
        if (size >= capacity) {
            throw new IllegalStateException("Exceeded palette capacity");
        }
        palette[size++] = new RGBColor(red, green, blue);
    }

    private boolean isValidPaletteSize(int numberOfColors) {
        return numberOfColors > 1 && numberOfColors < 1025 && (numberOfColors & (numberOfColors - 1)) == 0;
    }

    public void printPalette() {
        for (int i = 0; i < size; i++) {
            System.out.println("Color " + (i + 1) + ": " + palette[i]);
        }
    }
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ColourTable table = new ColourTable(8);

        table.add(255, 0, 0);
        table.add(0, 255, 0);
        table.add(0, 0, 255);
        table.add(255, 255, 0);

        table.printPalette();
    }
}

class RGBColor {
    private int red;
    private int green;
    private int blue;

    public RGBColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "RGB(" + red + ", " + green + ", " + blue + ")";
    }
}
