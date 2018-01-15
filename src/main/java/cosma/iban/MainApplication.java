package cosma.iban;

import cosma.iban.generator.IBANGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(MainApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {

            Map<String, Boolean> storage = new ConcurrentHashMap<>();

            IBANGenerator generator = new IBANGenerator(storage);

            int count = 5;
            if (args.length > 1){
                count = Integer.parseInt(args[1]);
            }

            for (int i = 0; i < count; i++) {
                String IBANcode =  generator.generate(args[0]);
                System.out.println(IBANcode);
            }
        } else {
            System.out.println("Please set as argument the ISO country code ");
            System.exit(1);
        }
        System.exit(0);
    }
}
