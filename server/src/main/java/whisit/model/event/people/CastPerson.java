package whisit.model.event.people;

import whisit.model.AbstractNamedIdElement;

/**
 * Created by dineshgurumurthy on 12/2/15.
 */
public class CastPerson extends AbstractNamedIdElement {

    protected String profilePath;
    private int castId;
    private String creditId;

    public String getProfilePath() {
        return profilePath;
    }

    public CastPerson setProfilePath(String profilePath) {
        this.profilePath = profilePath;
        return this;
    }

    public int getCastId() {
        return castId;
    }

    public CastPerson setCastId(int castId) {
        this.castId = castId;
        return this;
    }

    public String getCreditId() {
        return creditId;
    }

    public CastPerson setCreditId(String creditId) {
        this.creditId = creditId;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("CastPerson{");
        sb.append("creditId='").append(creditId).append('\'');
        sb.append(", castId=").append(castId);
        sb.append(", profilePath='").append(profilePath).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
