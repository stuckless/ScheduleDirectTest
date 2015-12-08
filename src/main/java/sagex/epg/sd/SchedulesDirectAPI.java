package sagex.epg.sd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import sagex.epg.sd.model.BaseResponse;
import sagex.epg.sd.model.Status;
import sagex.epg.sd.model.User;
import sagex.epg.sd.model.UserToken;

import java.io.IOException;

/**
 * Created by seans on 07/12/15.
 */
public class SchedulesDirectAPI {
    private final User user;
    private final Gson gson;

    // user token, needs to be set after a call to getUserToken()
    private UserToken token = null;

    SchedulesDirectService service;

    public SchedulesDirectAPI(String username, String password) {
        this.user = new User(username, password);

        // configure GSON
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        // we need to configure OkHttp to inject some headers
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder();

                if (request.header("token") != null) {
                    if (token == null) {
                        throw new IOException("token is required, but it is not set for " + request.url());
                    }
                    requestBuilder.removeHeader("token").addHeader("token", token.getToken());
                }

                // set the custom user agent
                requestBuilder.addHeader("User-Agent", "SageTV9/EPG/V1");

                Response response = chain.proceed(requestBuilder.build());
                return response;
            }
        });

        // configure the annotated Retrofit service
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://json.schedulesdirect.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(SchedulesDirectService.class);
    }

    /**
     * Call the GetUserToken service
     *
     * @return
     */
    public UserToken getUserToken() throws IOException {
        Call<UserToken> userTokenCall = service.getUserToken(user);
        retrofit.Response<UserToken> response = userTokenCall.execute();
        // if you want to handle the bad response case..
        if (!response.isSuccess()) {
            // UserToken extends the base response, which will have our error
            throw new SchedulesDirectException(
                    gson.fromJson(response.errorBody().string(), BaseResponse.class),
                    response.raw().request().url().toExternalForm());
        }
        // set the token, so we can use it in requests that need it.
        return token = response.body();
    }

    public void setUserToken(UserToken token) {
        this.token = token;
    }

    public Status getStatus() throws IOException {
        Call<Status> status = service.getStatus();
        retrofit.Response<Status> response = status.execute();
        if (!response.isSuccess()) {
            // UserToken extends the base response, which will have our error
            throw new SchedulesDirectException(
                    gson.fromJson(response.errorBody().string(), BaseResponse.class),
                    response.raw().request().url().toExternalForm());
        }
        return response.body();
    }
}
