package instagram;

import lombok.Data;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramTagFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.brunocvcunha.instagram4j.storymetadata.StorySliderItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 05/06/20
 * @project Facebook
 */
@Data
public class InstagramCaller {
    public static Instagram4j instagram;

    private final long id;
    private final String name;

    public InstagramCaller(long id, String name){
        this.id = id;
        this.name = name;
    }

    public static InstagramCaller instagramLogin() throws IOException {
        instagram = Instagram4j.builder().username("shivani_dwivedi08").password("Sharpedge@123").build();
        instagram.setup();
        instagram.login();
        return new InstagramCaller((int) instagram.getUserId(), instagram.getUsername());
    }

    public static int searchByHandle(String handle) throws IOException {
        InstagramSearchUsernameResult userResult = instagram.sendRequest(new InstagramSearchUsernameRequest(handle));
        System.out.println("ID is " + userResult.getUser().getPk());
        System.out.println("Number of followers: " + userResult.getUser().getFollower_count());
        return userResult.getUser().getFollower_count();
    }
    /*public static int searchByHandleC(String handle) throws IOException {
        InstagramSearchUsernameResult userResult = instagram.sendRequest(new InstagramSearchUsernameRequest(handle));
        //System.out.println("ID is " + userResult.getUser().getPk());
        System.out.println("Number of followers: " + userResult.getUser().getFollower_count());
        return userResult.getUser().getUsertags_count();
    }*/
    public static List<Long> getFeedForHashtag(String hashtag) throws IOException {
        InstagramFeedResult tagFeed = instagram.sendRequest(new InstagramTagFeedRequest(hashtag));
        List<Long> PostIdList = new ArrayList<>();
        System.out.println("feed count: "+tagFeed.getItems().size());
        for (InstagramFeedItem feedResult : tagFeed.getItems()) {
             //System.out.println("Post ID: " + );
             PostIdList.add(feedResult.getPk());
        }
        return PostIdList;
    }
}
