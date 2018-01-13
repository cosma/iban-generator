package cosma.iban;

import cosma.iban.generator.bban.BasicBankAccountNumber;
import cosma.iban.generator.bban.countries.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {


    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(MainApplication.class);
        app.run(args);
    }



    @Override
    public void run(String... args) throws Exception {
        BasicBankAccountNumber NL = new NL();

        String bban = NL.generate();
        String ISOCode = NL.getISOCode();


        System.exit(0);

    }
}
