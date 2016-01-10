package whisit.model;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by dinesh on 12/8/2015.
 */
@Document(collection = "geonames")
public class GeoName {

    private String id;
    private Long geonameId;
    private String name;
    private String asciiname;
    private String alternatenames;
    private Double latitude;
    private Double longitude;
    private String fclass;
    private String fcode;
    private String country;
    private String cc2;
    private String admin1;
    private String admin2;
    private String admin3;
    private String admin4;
    private Long population;
    private Long elevation;
    private String gtopo30;
    private TimeZone timezone;
    private Date modmoddateate;
    private GeoJsonPoint geolocation;

    public String getId() {
        return id;
    }

    public GeoName setId(String id) {
        this.id = id;
        return this;
    }

    public long getGeonameId() {
        return geonameId;
    }

    public GeoName setGeonameId(long geonameId) {
        this.geonameId = geonameId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GeoName setName(String name) {
        this.name = name;
        return this;
    }

    public String getAsciiname() {
        return asciiname;
    }

    public GeoName setAsciiname(String asciiname) {
        this.asciiname = asciiname;
        return this;
    }

    public String getAlternatenames() {
        return alternatenames;
    }

    public GeoName setAlternatenames(String alternatenames) {
        this.alternatenames = alternatenames;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public GeoName setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public GeoName setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getFclass() {
        return fclass;
    }

    public GeoName setFclass(String fclass) {
        this.fclass = fclass;
        return this;
    }

    public String getFcode() {
        return fcode;
    }

    public GeoName setFcode(String fcode) {
        this.fcode = fcode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public GeoName setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCc2() {
        return cc2;
    }

    public GeoName setCc2(String cc2) {
        this.cc2 = cc2;
        return this;
    }

    public String getAdmin1() {
        return admin1;
    }

    public GeoName setAdmin1(String admin1) {
        this.admin1 = admin1;
        return this;
    }

    public String getAdmin2() {
        return admin2;
    }

    public GeoName setAdmin2(String admin2) {
        this.admin2 = admin2;
        return this;
    }

    public String getAdmin3() {
        return admin3;
    }

    public GeoName setAdmin3(String admin3) {
        this.admin3 = admin3;
        return this;
    }

    public String getAdmin4() {
        return admin4;
    }

    public GeoName setAdmin4(String admin4) {
        this.admin4 = admin4;
        return this;
    }

    public long getPopulation() {
        return population;
    }

    public GeoName setPopulation(long population) {
        this.population = population;
        return this;
    }

    public long getElevation() {
        return elevation;
    }

    public GeoName setElevation(long elevation) {
        this.elevation = elevation;
        return this;
    }

    public String getGtopo30() {
        return gtopo30;
    }

    public GeoName setGtopo30(String gtopo30) {
        this.gtopo30 = gtopo30;
        return this;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public GeoName setTimezone(TimeZone timezone) {
        this.timezone = timezone;
        return this;
    }

    public Date getModmoddateate() {
        return modmoddateate;
    }

    public GeoName setModmoddateate(Date modmoddateate) {
        this.modmoddateate = modmoddateate;
        return this;
    }

    public GeoJsonPoint getGeolocation() {
        return geolocation;
    }

    public GeoName setGeolocation(GeoJsonPoint geolocation) {
        this.geolocation = geolocation;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeoName{");
        sb.append("id='").append(id).append('\'');
        sb.append(", geonameId=").append(geonameId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", asciiname='").append(asciiname).append('\'');
        sb.append(", alternatenames='").append(alternatenames).append('\'');
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", fclass='").append(fclass).append('\'');
        sb.append(", fcode='").append(fcode).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", cc2='").append(cc2).append('\'');
        sb.append(", admin1='").append(admin1).append('\'');
        sb.append(", admin2='").append(admin2).append('\'');
        sb.append(", admin3='").append(admin3).append('\'');
        sb.append(", admin4='").append(admin4).append('\'');
        sb.append(", population=").append(population);
        sb.append(", elevation=").append(elevation);
        sb.append(", gtopo30='").append(gtopo30).append('\'');
        sb.append(", timezone=").append(timezone);
        sb.append(", modmoddateate=").append(modmoddateate);
        sb.append(", geolocation=").append(geolocation);
        sb.append('}');
        return sb.toString();
    }
}
