package entities.response;

import entities.request.Tags;
import entities.request.Category;

public class createPetResponse {

    private Tags[] tags;
    private int id;
    private String name;
    private Category category;
    private String status;
    private String[] photoUrls;


    public Tags[] getTags() {
        return tags;
    }

    public void setTags(Tags[] tags) {
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStatus() {
        return name;
    }

    public void setStatus(String status) {
        this.name = status;
    }

    public Category getCategory() {
        return category;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }



}
