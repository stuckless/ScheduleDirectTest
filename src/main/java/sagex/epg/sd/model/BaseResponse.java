package sagex.epg.sd.model;

import java.util.Date;

/**
 * Created by seans on 07/12/15.
 */
public class BaseResponse {
    String response;
    int code;
    String serverID;
    String message;
    Date datetime;

    public BaseResponse() {
    }

    public String getResponse() {
        return response;
    }

    public int getCode() {
        return code;
    }

    public String getServerID() {
        return serverID;
    }

    public String getMessage() {
        return message;
    }

    public Date getDatetime() {
        return datetime;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "response='" + response + '\'' +
                ", code=" + code +
                ", serverID='" + serverID + '\'' +
                ", message='" + message + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
