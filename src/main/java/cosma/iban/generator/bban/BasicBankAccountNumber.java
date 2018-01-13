package cosma.iban.generator.bban;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * Basic Bank Account Number
 */
abstract public class BasicBankAccountNumber {

    protected abstract int getLength();

    protected abstract String generateBankIdentifier();

    protected abstract String generateBranchIdentifier();

    protected abstract String generateAccountNumber();

    public String generate() {
        return generateBankIdentifier() + generateBranchIdentifier() + generateAccountNumber();
    }

    public String getISOCode() {
        return this.getClass().getSimpleName();
    }

    protected String generateRandomNumberWithFixedLength(int length) {
        String chars = "0123456789";
        String randomNumber = new Random().ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());

        return randomNumber;
    }
}
