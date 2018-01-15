package cosma.iban.utils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ConverterTests {

    @Test
    public void convertAlphaToNumeric(){
        assertEquals("10", Converter.alphaToNumeric("A"));
        assertEquals("11", Converter.alphaToNumeric("b"));
        assertEquals("12", Converter.alphaToNumeric("c"));
        assertEquals("13", Converter.alphaToNumeric("D"));
        assertEquals("14", Converter.alphaToNumeric("E"));
        assertEquals("15", Converter.alphaToNumeric("F"));
        assertEquals("16", Converter.alphaToNumeric("G"));
        assertEquals("17", Converter.alphaToNumeric("H"));
        assertEquals("18", Converter.alphaToNumeric("I"));
        assertEquals("19", Converter.alphaToNumeric("J"));
        assertEquals("20", Converter.alphaToNumeric("K"));
        assertEquals("21", Converter.alphaToNumeric("L"));
        assertEquals("22", Converter.alphaToNumeric("M"));
        assertEquals("23", Converter.alphaToNumeric("N"));
        assertEquals("24", Converter.alphaToNumeric("O"));
        assertEquals("25", Converter.alphaToNumeric("P"));
        assertEquals("26", Converter.alphaToNumeric("Q"));
        assertEquals("27", Converter.alphaToNumeric("R"));
        assertEquals("28", Converter.alphaToNumeric("S"));
        assertEquals("29", Converter.alphaToNumeric("T"));
        assertEquals("30", Converter.alphaToNumeric("U"));
        assertEquals("31", Converter.alphaToNumeric("V"));
        assertEquals("32", Converter.alphaToNumeric("W"));
        assertEquals("33", Converter.alphaToNumeric("X"));
        assertEquals("34", Converter.alphaToNumeric("y"));
        assertEquals("35", Converter.alphaToNumeric("z"));
        assertEquals("1", Converter.alphaToNumeric("1"));
        assertEquals("2", Converter.alphaToNumeric("2"));
        assertEquals("3", Converter.alphaToNumeric("3"));
        assertEquals("4", Converter.alphaToNumeric("4"));
        assertEquals("5101315161734", Converter.alphaToNumeric("5ADfgh34"));
    }
}
