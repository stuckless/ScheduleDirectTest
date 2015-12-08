package sagex.epg.sd;

import org.junit.Test;
import sagex.epg.sd.model.Status;
import sagex.epg.sd.model.SystemStatus;
import sagex.epg.sd.model.UserToken;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by seans on 07/12/15.
 */
public class SchedulesDirectAPITest {

    @Test
    public void simpleTest() {
        SchedulesDirectAPI api = new SchedulesDirectAPI("testuser", "testpass");
        // get the token
        UserToken token = null;
        // call the getUserToken to ensure it is set
        try {
            token = api.getUserToken();
            System.out.println(token);
        } catch (SchedulesDirectException sde) {
            System.out.println("Got an error for Schedules Direct for url: " + sde.getUrl() + "; response: " + sde.getResponse());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        if (token == null) {
            // setting dummy token, so the next call call be attempted
            token = new UserToken();
            token.setToken("testtoken");
            api.setUserToken(token);
        }

        try {
            // cal get status
            Status status = api.getStatus();
            System.out.println(status);
            if (status.getSystemStatus() != null) {
                System.out.println(status.getSystemStatus().getStatus());
            }
        } catch (SchedulesDirectException sde) {
            sde.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}