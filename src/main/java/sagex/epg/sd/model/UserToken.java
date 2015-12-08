package sagex.epg.sd.model;

import java.util.Date;

/**
 * Created by seans on 07/12/15.
 */
public class UserToken extends BaseResponse {
    String token;

    public UserToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "token='" + token + '\'' +
                "} " + super.toString();
    }
}
