package cosma.iban.generator;

import cosma.iban.validator.IBANValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class IBANGeneratorTests {

    @Test
    public void generateValidIBANs(){

        Map<String, Boolean> storage = new ConcurrentHashMap<>();

        IBANGenerator generator = new IBANGenerator(storage);
        IBANValidator validator = new IBANValidator();

        for (int i=0; i< 1000; i++){
            String code = generator.generate("de");
            assertEquals(22, code.length());
            assertTrue(validator.validate(code));
        }

        for (int i=0; i< 1000; i++){
            String code = generator.generate("NL");
            assertEquals(18, code.length());
            assertTrue(validator.validate(code));
        }

        for (int i=0; i< 1000; i++){
            String code = generator.generate("At");
            assertEquals(20, code.length());
            assertTrue(validator.validate(code));
        }
    }
}
