package cosma.iban.generator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
public class IBANTests {

    @Test
    public void generateGermanIBANs(){

        Map<String, Boolean> storage = new ConcurrentHashMap<>();

        IBAN IBANgenerator = IBAN(storage);

        IBANgenerator.



    }


    private boolean validateIBAN(String IBANcode){

    }


}
