package cosma.iban.generator.bban.countries;

import cosma.iban.generator.bban.BasicBankAccountNumber;

public class DE extends BasicBankAccountNumber {

    protected int getLength() {
        return 18;
    }

    protected String generateBankIdentifier() {
        return generateRandomNumberWithFixedLength(8);
    }

    protected String generateBranchIdentifier() {
        return "";
    }

    protected String generateAccountNumber() {
        return generateRandomNumberWithFixedLength(10);
    }
}
