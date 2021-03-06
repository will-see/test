import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by W510 on 08.04.2017.
 */
public class SportEquipment {
    @SerializedName("title")
    private String title;
    @SerializedName("price")
    private int price;
    @SerializedName("id")
    int id;
    @SerializedName("count")
    int count;
    @SerializedName("Category")
    Category category;

    public SportEquipment() {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ""+ category+ " id:"+ id+ " product:"+ title + " price:"+ price;
    }
}
