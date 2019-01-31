package model;

import java.util.Objects;

public class ImageRecord {
    String url;
    String caption;
    Boolean rotate;

    public ImageRecord(String url, String caption, Boolean rotate) {
        this.url = url;
        this.caption = caption;
        this.rotate = rotate;
    }

    public ImageRecord(String url, String caption) {
        this(url, caption, false);
    }

    public String getUrl() {
        return url;
    }

    public String getCaption() {
        return caption;
    }

    public Boolean getRotate() {
        return rotate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageRecord that = (ImageRecord) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(caption, that.caption) &&
                Objects.equals(rotate, that.rotate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, caption, rotate);
    }
}
