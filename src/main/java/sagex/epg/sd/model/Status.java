package sagex.epg.sd.model;

import java.util.Date;
import java.util.List;

/**
 * Created by seans on 07/12/15.
 */
public class Status extends BaseResponse {
    Account account;
    List<LineUp> lineups;
    Date lastDataUpdate;
    List<Notification> notifications;
    SystemStatus systemStatus;

    public Status() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<LineUp> getLineups() {
        return lineups;
    }

    public void setLineups(List<LineUp> lineups) {
        this.lineups = lineups;
    }

    public Date getLastDataUpdate() {
        return lastDataUpdate;
    }

    public void setLastDataUpdate(Date lastDataUpdate) {
        this.lastDataUpdate = lastDataUpdate;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public SystemStatus getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(SystemStatus systemStatus) {
        this.systemStatus = systemStatus;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Status{" +
                "account=" + account +
                ", lineups=" + lineups +
                ", lastDataUpdate=" + lastDataUpdate +
                ", notifications=" + notifications +
                ", systemStatus=" + systemStatus +
                "} " + super.toString();
    }
}
