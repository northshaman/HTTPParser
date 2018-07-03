package model;

import java.util.Date;

/**
 * Entity class for store in DB
 */
public class Target {

    private String title;
    private String location;
    private Date datePost;
    private float price;

    public Target(String title, String location, Date datePost, float price) {
        this.title = title;
        this.location = location;
        this.datePost = datePost;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
