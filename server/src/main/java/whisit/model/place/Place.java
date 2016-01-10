package whisit.model.place;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import whisit.model.AbstractNamedIdElement;
import whisit.model.Picture;

import java.util.List;

/**
 * Created by dinesh on 12/5/2015.
 */
public class Place extends AbstractNamedIdElement {

    private GeoJsonPoint point;
    private String country;
    private List<String> searchLocality;
    private String address;
    private List<Picture> pictures;

    public GeoJsonPoint getPoint() {
        return point;
    }

    public void setPoint(GeoJsonPoint point) {
        this.point = point;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getSearchLocality() {
        return searchLocality;
    }

    public void setSearchLocality(List<String> searchLocality) {
        this.searchLocality = searchLocality;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public Place setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("Place{");
        sb.append("point=").append(point);
        sb.append(", country='").append(country).append('\'');
        sb.append(", searchLocality=").append(searchLocality);
        sb.append(", address='").append(address).append('\'');
        sb.append(", pictures=").append(pictures);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (!getPoint().equals(place.getPoint())) return false;
        if (getCountry() != null ? !getCountry().equals(place.getCountry()) : place.getCountry() != null) return false;
        if (getSearchLocality() != null ? !getSearchLocality().equals(place.getSearchLocality()) : place.getSearchLocality() != null)
            return false;
        return !(getAddress() != null ? !getAddress().equals(place.getAddress()) : place.getAddress() != null);

    }

    @Override
    public int hashCode() {
        int result = getPoint().hashCode();
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getSearchLocality() != null ? getSearchLocality().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }
}

