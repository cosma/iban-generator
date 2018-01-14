package cosma.iban.generator;

import cosma.iban.generator.BBAN.BasicBankAccountNumber;

import java.math.BigInteger;
import java.util.Map;

public class IBAN {

    private Map<String, Integer> storage;

    private BasicBankAccountNumber BBAN = null;

    /**
     * @param storage Map<String, Integer>
     */
    public IBAN(Map<String, Integer> storage) {
        this.storage = storage;
    }


    /**
     * recursive function until finds a unique value of IBANCode
     * @param countryCode String
     * @return String
     */
    public String generate(String countryCode) {

        lazyLoadBBAN(countryCode);

        BBAN.generate();

        String CheckDigits = calculateCheckDigits();

        String code = BBAN.getCountryCode() + CheckDigits + BBAN.getCode();

        if (isInStorage(code)) {
            return generate(countryCode);
        }

        addToStorage(code);

        return code;
    }

    /**
     * lazy load BBAN only is wasn't loaded or the countryCode changed
     *
     * @param countryCode String
     */
    private void lazyLoadBBAN(String countryCode) {
        countryCode = countryCode.toUpperCase();

        if (this.BBAN == null || !this.BBAN.getCountryCode().equals(countryCode)) {
            try {
                ClassLoader classLoader = BasicBankAccountNumber.class.getClassLoader();
                Class BBANClass = classLoader.loadClass("cosma.iban.generator.BBAN.countries." + countryCode);
                this.BBAN = (BasicBankAccountNumber) BBANClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param code String
     * @return boolean
     */
    private boolean isInStorage(String code) {
        return this.storage.containsKey(code);
    }

    /**
     *
     * @param code String
     */
    private void addToStorage(String code) {
        this.storage.put(code, 1);
    }


    /**
     * See https://en.wikipedia.org/wiki/International_Bank_Account_Number#Generating_IBAN_check_digits
     *
     * @return String
     */
    private String calculateCheckDigits() {

        String code = this.BBAN.getCode() + this.BBAN.getCountryCode() + "00";

        String numericCode = convertAlphaToNumeric(code);

        BigInteger bigIntegerCode = new BigInteger(numericCode);

        String remainder = bigIntegerCode.mod(new BigInteger("97")).toString();

        int intCheckDigits = 98 - Integer.parseInt(remainder);

        String checkDigits = Integer.toString(intCheckDigits);

        return "00".substring(checkDigits.length()) + checkDigits;

    }

    /**
     *
     * @param toConvert String
     * @return String
     */
    private String convertAlphaToNumeric(String toConvert) {

        String converted = toConvert;

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
