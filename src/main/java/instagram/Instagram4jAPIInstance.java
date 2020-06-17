package instagram;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.bytedeco.javacv.FrameFilter;

import java.io.IOException;

/**
 * Singleton class that returns instagram instance
 * @author shivanidwivedi on 05/06/20
 * @project Facebook
 */
public class Instagram4jAPIInstance {
    private final static Instagram4j instagram4j = instagramLogin();

    private Instagram4jAPIInstance() {}

    public static Instagram4j getInstance() {
        return instagram4j;
    }

    public static Instagram4j instagramLogin() {
        Instagram4j instagram = null;
        try {
            instagram = Instagram4j.builder().username("****")
                    .password("****").build();
            instagram.setup();
            instagram.login();
        }
        catch (Exception e) {

        }
        return instagram;
    }
}
