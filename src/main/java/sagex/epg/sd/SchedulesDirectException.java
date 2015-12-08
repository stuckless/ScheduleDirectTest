package sagex.epg.sd;

import sagex.epg.sd.model.BaseResponse;

import java.io.IOException;

/**
 * Created by seans on 07/12/15.
 */
public class SchedulesDirectException extends IOException {
    private final String url;
    private final BaseResponse response;

    public SchedulesDirectException(BaseResponse response, String url) {
        super("" + response);
        this.url = url;
        this.response = response;
    }

    public BaseResponse getResponse() {
        return response;
    }

    public String getUrl() {
        return url;
    }

}
