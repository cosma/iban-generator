package cosma.iban.generator;

import cosma.iban.generator.BBAN.BasicBankAccountNumber;
import cosma.iban.utils.Converter;

import java.math.BigInteger;
import java.util.Map;

public class IBANGenerator {

    private Map<String, Boolean> storage;

    private BasicBankAccountNumber BBAN = null;

    /**
     * @param storage Map<String, Boolean>
     */
    public IBANGenerator(Map<String, Boolean> storage) {
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
        this.storage.put(code, true);
    }


    /**
     * See https://en.wikipedia.org/wiki/International_Bank_Account_Number#Generating_IBAN_check_digits
     *
     * @return String
     */
    private String calculateCheckDigits() {

        String code = this.BBAN.getCode() + this.BBAN.getCountryCode() + "00";

        String numericCode = Converter.alphaToNumeric(code);

        BigInteger bigIntegerCode = new BigInteger(numericCode);

        String remainder = bigIntegerCode.mod(new BigInteger("97")).toString();

        int intCheckDigits = 98 - Integer.parseInt(remainder);

        String checkDigits = Integer.toString(intCheckDigits);

        return "00".substring(checkDigits.length()) + checkDigits;

    }
}
