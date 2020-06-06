package instagram;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

import java.io.IOException;

/**
 * @author shivanidwivedi on 29/05/20
 * @project Facebook
 */
public class Caller extends Thread{


    public static void main(String[] args) throws FacebookException, IOException {

        facebookLogin();
    }

    public static void facebookLogin() throws FacebookException {
        Facebook facebook = new FacebookFactory().getInstance();

        facebook.setOAuthAppId("", "");
        // Get an access token from:
        // https://developers.facebook.com/tools/explorer
        // Copy and paste it below.
        String accessTokenString = "EAAtZBnggb9DgBAIxzpNZAnhhZCvZBFyOaZCyDZAbK5gke4RmyLcrSV0hRgRJvtMaXyG1A2TpoYzQ6dERZCBwcaI0LqpT0ZAdFPs6iZAE1eAl3XIIP4ITyiLVFXUzF6DOv7OuNBWiAI6Ihn42PtTcmUpMKRTHRHGwqThZBIuJ9ZCCl18ZCHplpRvaaAvF0ZBsxaqU7rhs5izO9lePjdHmZCBIengQ7FdUrtCrhO2XjXKyh8622a5wZDZD";
        AccessToken at = new AccessToken(accessTokenString);
        // Set access token.
        facebook.setOAuthAccessToken(at);
        System.out.println(facebook.getName());
        System.out.println(facebook.getId());

    }


}
