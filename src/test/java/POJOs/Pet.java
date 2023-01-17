package POJOs;

import Resources.StatusEnum;

import java.util.ArrayList;

public class Pet {

    long id;
    Category category;
    String name;
    ArrayList<String> photoUrls;
    ArrayList<Tag> tags;
    String status;

    public Pet() {

    }

    public Pet(long id, Category category, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags, StatusEnum status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status.getStatus();
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(StatusEnum statusEnum) {
        status = statusEnum.getStatus();
    }

    public boolean equals(Object pet) {
        //add instanceOf check
        return this.id == ((Pet)pet).getId();
    }
}
