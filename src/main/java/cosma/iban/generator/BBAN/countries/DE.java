package cosma.iban.generator.BBAN.countries;

import cosma.iban.generator.BBAN.BasicBankAccountNumber;

public class DE extends BasicBankAccountNumber {

    /**
     * @return String
     */
    protected String generateBankIdentifier() {
        return generateRandomNumberWithFixedLength(8);
    }

    /**
     * @return String
     */
    protected String generateBranchIdentifier() {
        return "";
    }

    /**
     * @return String
     */
    protected String generateAccountNumber() {
        return generateRandomNumberWithFixedLength(10);
    }
}
