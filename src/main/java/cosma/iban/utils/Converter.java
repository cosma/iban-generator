package cosma.iban.utils;

public class Converter {
    /**
     * @param toConvert String
     * @return String
     */
    public static String alphaToNumeric(String toConvert) {

        String converted = toConvert.toUpperCase();

        converted = converted.replaceAll("A", "10");
        converted = converted.replaceAll("B", "11");
        converted = converted.replaceAll("C", "12");
        converted = converted.replaceAll("D", "13");
        converted = converted.replaceAll("E", "14");
        converted = converted.replaceAll("F", "15");
        converted = converted.replaceAll("G", "16");
        converted = converted.replaceAll("H", "17");
        converted = converted.replaceAll("I", "18");
        converted = converted.replaceAll("J", "19");
        converted = converted.replaceAll("K", "20");
        converted = converted.replaceAll("L", "21");
        converted = converted.replaceAll("M", "22");
        converted = converted.replaceAll("N", "23");
        converted = converted.replaceAll("O", "24");
        converted = converted.replaceAll("P", "25");
        converted = converted.replaceAll("Q", "26");
        converted = converted.replaceAll("R", "27");
        converted = converted.replaceAll("S", "28");
        converted = converted.replaceAll("T", "29");
        converted = converted.replaceAll("U", "30");
        converted = converted.replaceAll("V", "31");
        converted = converted.replaceAll("W", "32");
        converted = converted.replaceAll("X", "33");
        converted = converted.replaceAll("Y", "34");
        converted = converted.replaceAll("Z", "35");

        return converted;

    }
}
