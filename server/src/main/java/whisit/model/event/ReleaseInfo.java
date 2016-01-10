package whisit.model.event;

import whisit.model.AbstractIdElement;

/**
 * Created by dineshgurumurthy on 12/2/15.
 */
public class ReleaseInfo extends AbstractIdElement {

    private String country;
    private String certification;
    private String releaseDate;

    public String getCountry() {
        return country;
    }

    public ReleaseInfo setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCertification() {
        return certification;
    }

    public ReleaseInfo setCertification(String certification) {
        this.certification = certification;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public ReleaseInfo setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("ReleaseInfo{");
        sb.append("country='").append(country).append('\'');
        sb.append(", certification='").append(certification).append('\'');
        sb.append(", releaseDate='").append(releaseDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
