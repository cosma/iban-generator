package cosma.iban.generator.BBAN.countries;

import cosma.iban.generator.BBAN.BasicBankAccountNumber;

public class AT extends BasicBankAccountNumber {

    /**
     * @return int
     */
    public int getLength() {
        return 16;
    }

    /**
     * @return String
     */
    protected String generateBankIdentifier() {
        return generateRandomNumberWithFixedLength(5);
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
        return generateRandomNumberWithFixedLength(11);
    }
}
