import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by W510 on 09.04.2017.
 */
public class ParseProductsUtil {
    public static ArrayList<SportEquipment> parse(String s){
        Type listType = new TypeToken<ArrayList<SportEquipment>>(){}.getType();
        ArrayList<SportEquipment> products = new Gson().fromJson(s, listType);
        // todo обработатьошибку парсинга
        return products;
    }
}
