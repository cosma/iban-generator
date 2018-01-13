package cosma.iban;

import cosma.iban.generator.IBAN;
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
        if (args.length > 0) {
            IBAN IBANGenerator = new IBAN(args[0]);

            int count = 5;
            if (args.length > 1){
                count = Integer.parseInt(args[1]);
            }

            for (int i = 0; i < count; i++) {
                String code =  IBANGenerator.generate();
                System.out.println(code);
            }
        } else {
            System.out.println("Please set as argument the ISO country code ");
        }
        System.exit(0);
    }
}
