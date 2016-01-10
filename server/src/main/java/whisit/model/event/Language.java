package whisit.model.event;

import whisit.model.AbstractNamedIdElement;

/**
 * Created by dineshgurumurthy on 12/2/15.
 */
public class Language extends AbstractNamedIdElement {

    private String isoCode;

    public String getIsoCode() {
        return isoCode;
    }

    public Language setIsoCode(String isoCode) {
        this.isoCode = isoCode;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t");
        sb.append("Language{");
        sb.append("isoCode='").append(isoCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
