package sagex.epg.sd;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import sagex.epg.sd.model.Status;
import sagex.epg.sd.model.User;
import sagex.epg.sd.model.UserToken;

/**
 * Created by seans on 07/12/15.
 */
public interface SchedulesDirectService {
    @POST("/20141201/token")
    Call<UserToken> getUserToken(@Body User user);

    @Headers("token: empty") // token placeholder so we can inject the token into the call
    @GET("/20141201/status")
    Call<Status> getStatus();
}
