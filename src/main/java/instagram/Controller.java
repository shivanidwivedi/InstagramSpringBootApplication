package instagram;

import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author shivanidwivedi on 05/06/20
 * @project Facebook
 */
@RestController
public class Controller {
    @GetMapping("/handle")
    public InstagramUser user(@RequestParam(value = "name", defaultValue = "shivani_dwivedi08") String handle) {
        try {
            InstagramUser user = APICaller.userByHandle(handle);
            return user;
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    @GetMapping("/hashtag")
    public InstagramFeedResult feed(@RequestParam(value = "hashtag", defaultValue = "github") String hashtag) {
        try {
            return APICaller.getFeedForHashtag(hashtag);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
