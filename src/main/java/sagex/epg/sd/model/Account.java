package sagex.epg.sd.model;

import java.util.Date;
import java.util.List;

/**
 * Created by seans on 07/12/15.
 */
public class Account {
    Date expires;
    List<String> messages;
    int maxLineups;

    public Account() {
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public int getMaxLineups() {
        return maxLineups;
    }

    public void setMaxLineups(int maxLineups) {
        this.maxLineups = maxLineups;
    }

    @Override
    public String toString() {
        return "Account{" +
                "expires=" + expires +
                ", messages=" + messages +
                ", maxLineups=" + maxLineups +
                '}';
    }

}
