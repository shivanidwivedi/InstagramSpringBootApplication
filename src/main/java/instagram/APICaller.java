package instagram;

import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramTagFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 05/06/20
 * @project Facebook
 */
public class APICaller {

    public static InstagramUser userByHandle(String handle) throws IOException {
        InstagramSearchUsernameResult userResult = Instagram4jAPIInstance.getInstance().sendRequest(new InstagramSearchUsernameRequest(handle));
        System.out.println("ID is " + userResult.getUser().getPk());
        System.out.println("Number   of followers: " + userResult.getUser().getFollower_count());
        return userResult.getUser();
    }
    public static InstagramFeedResult getFeedForHashtag(String hashtag) throws IOException {
        InstagramFeedResult tagFeed = Instagram4jAPIInstance.getInstance().sendRequest(new InstagramTagFeedRequest(hashtag));
        List<Long> PostIdList = new ArrayList<>();
        System.out.println("feed count: "+tagFeed.getItems().size());
        for (InstagramFeedItem feedResult : tagFeed.getItems()) {
             //System.out.println("Post ID: " + );
             PostIdList.add(feedResult.getPk());
        }
        return tagFeed;
    }
}
