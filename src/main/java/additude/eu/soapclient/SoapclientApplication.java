package additude.eu.soapclient;

import eu.additude.consumingwebservice.wsdl.GetPersoonResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapclientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(PersoonClient quoteClient) {
        return args -> {
            Long id = 1L;

            if (args.length > 0) {
                id = Long.parseLong(args[0]);
            }
            GetPersoonResponse response = quoteClient.getPersoon(id);
            System.err.println(response.getPersoon().getId() + " - " + response.getPersoon().getNaam());
        };
    }
}