
package entity;

public class Cake {
    private int id;
    private String name, picture, shortDescription, detailDescription;
    private String price;

    public Cake() {
    }

    public Cake(int id, String name, String picture, String shortDescription) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.shortDescription = shortDescription;
    }

    public Cake(int id, String name, String picture, String detailDescription, String price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.detailDescription = detailDescription;
        this.price = price;
    }
    
    public Cake(int id, String name, String picture, String shortDescription, String detailDescription, String price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.shortDescription = shortDescription;
        this.detailDescription = detailDescription;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

   
    
    
}
