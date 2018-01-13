package cosma.iban.generator.bban.countries;

import cosma.iban.generator.bban.BasicBankAccountNumber;

public class AT extends BasicBankAccountNumber {

    public int getLength() {
        return 16;
    }

    protected String generateBankIdentifier() {
        return generateRandomNumberWithFixedLength(5);
    }

    protected String generateBranchIdentifier() {
        return "";
    }

    protected String generateAccountNumber() {
        return generateRandomNumberWithFixedLength(11);
    }
}
