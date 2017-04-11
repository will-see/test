import com.google.gson.annotations.SerializedName;

/**
 * Created by W510 on 09.04.2017.
 */
public class Category {
    @SerializedName("categoryTitle")
    public String categoryName;
    @SerializedName("categoryId")
    public String categoryId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "category "+ categoryName;
    }
}
