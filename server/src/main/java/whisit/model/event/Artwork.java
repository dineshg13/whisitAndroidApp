package whisit.model.event;

import whisit.model.AbstractIdElement;
import whisit.types.PictureType;

/**
 * Created by dinesh on 12/5/2015.
 */
public class Artwork extends AbstractIdElement {

    private String language;
    private String filePath;
    private float aspectRatio;
    private int height;
    private int width;
    private float voteAverage;
    private int voteCount;
    private String flag;
    private PictureType type;


    public String getLanguage() {
        return language;
    }

    public Artwork setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public Artwork setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    public Artwork setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Artwork setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Artwork setWidth(int width) {
        this.width = width;
        return this;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public Artwork setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public Artwork setVoteCount(int voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public Artwork setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public PictureType getType() {
        return type;
    }

    public Artwork setType(PictureType type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("Artwork{");
        sb.append("language='").append(language).append('\'');
        sb.append(", filePath='").append(filePath).append('\'');
        sb.append(", aspectRatio=").append(aspectRatio);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", voteAverage=").append(voteAverage);
        sb.append(", voteCount=").append(voteCount);
        sb.append(", flag='").append(flag).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
