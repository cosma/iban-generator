package cosma.iban.validator;

import cosma.iban.utils.Converter;

import java.math.BigInteger;

public class IBANValidator {


    /**
     * recursive function until finds a unique value of IBANCode
     *
     * @param IBANCode String
     * @return boolean
     */
    public boolean validate(String IBANCode) {

        String head = IBANCode.substring(0, 4);
        String tail = IBANCode.substring(4, IBANCode.length());

        String reverse = tail + head;

        String numericCode = Converter.alphaToNumeric(reverse);

        BigInteger bigIntegerCode = new BigInteger(numericCode);

        BigInteger remainder = bigIntegerCode.mod(new BigInteger("97"));

        return remainder.equals(new BigInteger("1"));
    }
}
