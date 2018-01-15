package cosma.iban.generator.BBAN;

import cosma.iban.generator.BBAN.countries.AT;
import cosma.iban.generator.BBAN.countries.DE;
import cosma.iban.generator.BBAN.countries.NL;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class BasicBankAccountNumberTests {

    @Test
    public void generateGermanBBAN(){

        BasicBankAccountNumber bban = new DE();
        bban.generate();

        assertEquals( "DE", bban.getCountryCode());
        assertTrue( "German BBAN have 18 numeric characters",  bban.getCode().matches("\\d{18}"));

    }

    @Test
    public void generateAustrianBBAN(){

        BasicBankAccountNumber bban = new AT();
        bban.generate();

        assertEquals( "AT", bban.getCountryCode());
        assertTrue( "Austrian BBAN have 16 numeric characters",  bban.getCode().matches("\\d{16}"));

    }

    @Test
    public void generateDutchnBBAN(){

        BasicBankAccountNumber bban = new NL();
        bban.generate();

        assertEquals( "NL", bban.getCountryCode());
        assertTrue( "Dutch BBAN starts with 4 letters and ends with 10 numbers",  bban.getCode().matches("[A-Z]{4}\\d{10}"));
    }
}
