package instagram;

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
public class InstaController {
    private static final String template = "Hello, instagram!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/handle")
    public String instagramMethod(@RequestParam(value = "name", defaultValue = "github") String handle) {
        try {
            int followerCount = InstagramCaller.searchByHandle(handle);
            return "<h1>Follower count: "+followerCount+ "</h1>";
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return "default";
    }
    @GetMapping("/hashtag")
    public String instagramMethodPost(@RequestParam(value = "hashtag", defaultValue = "travel") String hashtag) {
        try {
            List<Long> list = InstagramCaller.getFeedForHashtag(hashtag);
            return "<h1>PostID list: "+list+"</h1>";
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return "default";
    }
}
