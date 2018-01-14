package cosma.iban.generator.BBAN.countries;

import cosma.iban.generator.BBAN.BasicBankAccountNumber;

import java.util.Random;

public class NL extends BasicBankAccountNumber {

    /**
     * @return int
     */
    public int getLength() {
        return 14;
    }

    /**
     * See https://www.betaalvereniging.nl/aandachtsgebieden/giraal-betalingsverkeer/bic-sepa-transacties/
     * @return String
     */
    protected String generateBankIdentifier() {
        String[] banks = {
                "ABNA","FTSB", "ADYB", "AEGO", "ANAA", "ANDL", "ARBN", "ARSN", "ASNB", "ATBA", "BCDM", "BCIT", "BICK",
                "BINK", "BKCH", "BKMG", "BLGW", "BMEU", "BNDA", "BNGH", "BNPA", "BOFA", "BOFS", "BOTK", "BUNQ", "CHAS",
                "CITC", "CITI", "COBA", "DEUT", "DHBN", "DLBK", "DNIB", "FBHL", "FLOR", "FRGH", "FVLB", "GILL", "HAND",
                "HHBA", "HSBC", "ICBK", "INGB", "ISBK", "KABA", "KASA", "KNAB", "KOEX", "KRED", "LOCY", "LOYD", "LPLN",
                "MHCB", "MOYO", "NNBA", "NWAB", "PCBC", "RABO", "RBRB", "SNSB", "SOGE", "TEBU", "TRIO", "UBSW", "UGBI",
                "VOWA", "ZWLB"
        };

        int randomBank = new Random().nextInt(banks.length);

        return banks[randomBank];
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
