import java.util.HashMap;
import java.util.Map;

/**
 * Created by W510 on 08.04.2017.
 */
public class Shop {
//    private Map<SportEquipment,Integer> goods = new HashMap<SportEquipment,Integer>();
    private Map<SportEquipment,Integer> goods;
    //Map-value - количетво определенного товара
//        static {
//            Map goods = new HashMap();
//            SportEquipment eq1 = new SportEquipment("ball",20);
//            SportEquipment eq2 = new SportEquipment("bag",10);
//            SportEquipment eq3 = new SportEquipment("shoes",30);
//            goods.put(eq1,1);
//            goods.put(eq2,2);
//            goods.put(eq3,3);
//        }
    public void fillingMap(){
        Map goods = new HashMap();
            SportEquipment eq1 = new SportEquipment("ball",20);
            SportEquipment eq2 = new SportEquipment("bag",10);
            SportEquipment eq3 = new SportEquipment("shoes",30);
            goods.put(eq1,1);
            goods.put(eq2,2);
            goods.put(eq3,3);
    }
    public void printMap(){
        for (Map.Entry<SportEquipment,Integer> pair : goods.entrySet())
        {
            SportEquipment key = pair.getKey();                      //ключ
            Integer value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
        System.out.println(goods);
    }
    public static void main(String[] args) {
//        printMap();
    }
}
