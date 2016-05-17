package org.springframework.social.jandi.type;

/**
 * Created by allbegray on 2016-05-17.
 */
public class ConnectInfo {

    private String title;
    private String description;
    private String imageUrl;

    public ConnectInfo() {
    }

    public ConnectInfo(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
