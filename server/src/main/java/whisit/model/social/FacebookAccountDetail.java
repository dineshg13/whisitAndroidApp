package whisit.model.social;

import whisit.model.AbstractIdElement;

/**
 * Created by dinesh on 11/20/2015.
 */
public class FacebookAccountDetail extends AbstractIdElement {

    private String details;


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("FacebookAccountDetail{");
        sb.append(", details='").append(details).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
