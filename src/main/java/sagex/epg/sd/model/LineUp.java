package sagex.epg.sd.model;

import java.util.Date;

/**
 * Created by seans on 07/12/15.
 */
public class LineUp {
    String lineup;
    Date modified;
    String uri;

    public LineUp() {
    }

    public String getLineup() {
        return lineup;
    }

    public void setLineup(String lineup) {
        this.lineup = lineup;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "LineUp{" +
                "lineup='" + lineup + '\'' +
                ", modified=" + modified +
                ", uri='" + uri + '\'' +
                '}';
    }
}
