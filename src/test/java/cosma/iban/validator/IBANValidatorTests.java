package cosma.iban.validator;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class IBANValidatorTests {

    @Test
    public void validIBANs(){

        IBANValidator validator = new IBANValidator();

        assertTrue(validator.validate("DE89370400440532013000"));
        assertTrue(validator.validate("DE76123456781234567894"));
        assertTrue(validator.validate("DE14530501801239723976"));


        assertTrue(validator.validate("AT260119420111776879"));
        assertTrue(validator.validate("AT212229947357400335"));
        assertTrue(validator.validate("AT129347159050353800"));


        assertTrue(validator.validate("NL57BLGW8791788281"));
        assertTrue(validator.validate("NL71HHBA7879387797"));
        assertTrue(validator.validate("AT129347159050353800"));
    }


    @Test
    public void inValidIBANs(){

        IBANValidator validator = new IBANValidator();

        assertFalse(validator.validate("DE4443072"));
        assertFalse(validator.validate("DE78123456781234567894"));
        assertFalse(validator.validate("DE19149268739119308346"));


        assertFalse(validator.validate("AT885697094509708550"));
        assertFalse(validator.validate("AT860410497479314540"));
        assertFalse(validator.validate("AT990188466359477935"));


        assertFalse(validator.validate("NL47HHB827426467434234343242343424342"));
        assertFalse(validator.validate("NL63BICK2835254282"));
        assertFalse(validator.validate("NL14BICK17528650415"));
    }
}
