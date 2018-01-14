package cosma.iban.generator.BBAN;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * Basic Bank Account Number
 */
abstract public class BasicBankAccountNumber {

    private String code;

    public abstract int getLength();

    protected abstract String generateBankIdentifier();

    protected abstract String generateBranchIdentifier();

    protected abstract String generateAccountNumber();

    public void generate() {
        code = generateBankIdentifier() + generateBranchIdentifier() + generateAccountNumber();
    }

    /**
     *
     * @return String
     */
    public String getCountryCode() {
        return this.getClass().getSimpleName();
    }

    /**
     *
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param length int
     * @return String
     */
    protected String generateRandomNumberWithFixedLength(int length) {
        String chars = "0123456789";
        return new Random().ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
    }
}
