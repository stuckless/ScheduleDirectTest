package sagex.epg.sd.model;

import java.util.Date;

/**
 * Created by seans on 07/12/15.
 */
public class SystemStatus {
    Date date;
    String status;
    String message;

    public SystemStatus() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SystemStatus{" +
                "date=" + date +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
