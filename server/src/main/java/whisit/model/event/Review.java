package whisit.model.event;

import whisit.model.AbstractIdElement;

/**
 * Created by dinesh on 12/4/2015.
 */
public class Review extends AbstractIdElement {

    private String author;
    private String content;
    private String url;

    public String getAuthor() {
        return author;
    }

    public Review setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Review setContent(String content) {
        this.content = content;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Review setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("Review{");
        sb.append("author='").append(author).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
