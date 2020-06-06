package instagram;

import facebook4j.FacebookException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author shivanidwivedi on 05/06/20
 * @project Facebook
 */
@SpringBootApplication
public class InstagramApplication {
    private static final Logger log = LoggerFactory.getLogger(InstagramApplication.class);
    public static void main(String[] args) throws FacebookException, IOException {
        try {
            InstagramCaller.instagramLogin();
            log.info("Instagramlogin method");
            SpringApplication.run(InstagramApplication.class, args);

        }
        catch (Exception e){
            System.out.println(e);
        }
        //insta.instagramLogin();
        //insta.searchByHandle("shivani_dwivedi08");
        //insta.getFeedForHashtag("travel");
        //insta.sendRequest("http://localhost:8080/insta");
    }
}
