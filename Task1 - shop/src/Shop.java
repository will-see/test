import utils.ReadFileUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by W510 on 08.04.2017.
 */
public class Shop {
    final static String REPORRT = "report", RENT = "rent";
    static int fileReadCounter;
    private static Map<SportEquipment, Integer> goods = new HashMap<>();
   static RentUnit cart=new RentUnit();

    public static void main(String[] args) {
        // инициализация магазина
        String productsJson = getProducts();
        ArrayList<SportEquipment> products = ParseProductsUtil.parse(productsJson);
        for (int i = 0; i < products.size(); i++) {
            SportEquipment prod = products.get(i);
            goods.put(prod, prod.count);
        }
        listenUserCommands();
        // действияпользователя
    }

    private static void listenUserCommands() {
        System.out.println("inter your command");
        String command = readLine();
        switch (command){
            case RENT:
                doRent();
                break;
            case REPORRT:
                doReport();
                break;
            default:
                System.out.println("command, not detected inter your command again");
                System.out.println("commands: "+ RENT+", "+REPORRT);
                listenUserCommands();
        }

    }

    private static void doRent() {
        // show all products
        for (Map.Entry<SportEquipment,Integer> prod :goods.entrySet()) {
            SportEquipment equipment=prod.getKey();
            System.out.println(equipment.toString()+"count "+prod.getValue().toString());
        }
        System.out.println("inter product id for choice");
        ArrayList<Integer> ids = listentProdID();

        if (ids.size()>3){
            System.out.println("maximum 3");
            doRent();
        }
        ArrayList<SportEquipment> order=new ArrayList<>();
        for (Map.Entry<SportEquipment,Integer> prod :goods.entrySet()) {
            for (Integer id: ids){
                boolean selected= id.equals(prod.getKey().id);
                if(selected){
                    order.add(prod.getKey());
                    System.out.println("selected "+prod.getKey().toString());
                }
            }
        }
        if (order.size()>0){
            cart.setUnits(order);
            cart.showOrder();
        }else {
            System.out.println("products not found");
        }
        listenUserCommands();

    }

    private static ArrayList<Integer> listentProdID() {
        System.out.println("inter products ids");
        String idsStr=readLine();
        ArrayList<Integer>selectedIds=new ArrayList<>();
         ArrayList<String> ids= new ArrayList<String>(Arrays.asList(idsStr.split(","))) ;
        for (String idString:ids) {
            try {
                Integer id= Integer.parseInt(idString);
                selectedIds.add(id);
            }catch (NumberFormatException e){
                System.out.println("input error");
                listentProdID();
            }
        }
        return selectedIds;
    }

    private static void doReport() {
        System.out.println("in rent");
        cart.showOrder();
    }



    private static String getProducts() {
        String fileName;
        if (fileReadCounter > 1) {
            System.out.println("load default file");
            fileName = "products.txt";
            fileReadCounter = 0;
        } else {
            System.out.println("inter file name with products");
            fileName = readLine();
            fileReadCounter++;
        }
        File file = new File(fileName);
        String products = null;
        try {
            products = ReadFileUtil.readFileAsString(file);
        } catch (IOException e) {
            System.out.println("file not found, please try again");
            products = getProducts();
        }
        return products;
    }

    private static String readLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return fileName;
    }

//        Console c = System.console();
//        if (c == null) {
//            System.err.println("No console.");
//            System.exit(1);
//        }
//
//        String login = c.readLine("Enter your login: ");
//        char [] oldPassword = c.readPassword("Enter your old password: ");
//    }
}
