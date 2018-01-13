package cosma.iban.generator.bban.countries;

import cosma.iban.generator.bban.BasicBankAccountNumber;

import java.util.Random;

public class NL extends BasicBankAccountNumber {

    public int getLength() {
        return 14;
    }

    protected String generateBankIdentifier() {
        String[] banks = {
                "ABNA", "FTSB", "INGB", "SOGE", "BCIT", "BNPA", "CITI"
        };

        int randomBank = new Random().nextInt(banks.length);

        return banks[randomBank];
    }

    protected String generateBranchIdentifier() {
        return "";
    }

    protected String generateAccountNumber() {
        return generateRandomNumberWithFixedLength(10);
    }
}
