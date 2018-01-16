package cosma.iban.validator;

import cosma.iban.generator.BBAN.BasicBankAccountNumber;
import cosma.iban.utils.Converter;

import java.math.BigInteger;

public class IBANValidator {

    private BasicBankAccountNumber BBAN = null;

    /**
     * recursive function until finds a unique value of IBANCode
     *
     * @param IBANCode String
     * @return boolean
     */
    public boolean validate(String IBANCode) {

        IBANCode = IBANCode.trim().replaceAll(" +", "");

        lazyLoadBBAN(extractCountryCode(IBANCode));

        if (!hasCorrectLength(IBANCode)) {
            return false;
        }

        String head = IBANCode.substring(0, 4);
        String tail = IBANCode.substring(4, IBANCode.length());

        String reverse = tail + head;

        String numericCode = Converter.alphaToNumeric(reverse);

        BigInteger bigIntegerCode = new BigInteger(numericCode);

        BigInteger remainder = bigIntegerCode.mod(new BigInteger("97"));

        return remainder.equals(new BigInteger("1"));
    }

    /**
     *
     * @param IBANCode String
     * @return boolean
     */
    private boolean hasCorrectLength(String IBANCode) {
        return (this.BBAN.getLength() + 4) == IBANCode.length();
    }

    private String extractCountryCode(String code) {
        return code.substring(0, 2);
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
}
