package instagram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shivanidwivedi on 05/06/20
 * @project Facebook
 */
@SpringBootApplication
public class InstagramApplication {
    private static final Logger log = LoggerFactory.getLogger(InstagramApplication.class);
    public static void main(String[] args) {
        try {
            log.info("Starting up application ...");
            Instagram4jAPIInstance.getInstance(); //initiate
            SpringApplication.run(InstagramApplication.class, args);

        }
        catch (Exception e){
            log.error("Error during login: "+e);
        }
    }
}
