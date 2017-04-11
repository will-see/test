import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by W510 on 09.04.2017.
 */
public class ParseProductsUtil {
    public static ArrayList<SportEquipment> parse(String s){
        Type listType = new TypeToken<ArrayList<SportEquipment>>(){}.getType();
        ArrayList<SportEquipment> products = null;
        try {
            products = new Gson().fromJson(s, listType);
        } catch (Exception e) {
            System.out.println("Incorrect file");
        }
        return products;
    }
}
