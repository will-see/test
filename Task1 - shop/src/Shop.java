import utils.ReadFileUtil;

import java.io.*;
import java.util.*;

/**
 * Created by W510 on 08.04.2017.
 */
public class Shop {
    final static String REPORRT = "report", RENT = "rent", INSTOCK = "instock", EXIT = "exit";
    static int fileReadCounter;
    private static Map<SportEquipment, Integer> goods = new HashMap<>();
    static RentUnit cart = new RentUnit();
    static ArrayList<Integer> selectedIds = new ArrayList<>();
    static ArrayList<SportEquipment> order = new ArrayList<>();

    public static void main(String[] args) {
        // инициализация магазина
        String productsJson = getProducts();
        ArrayList<SportEquipment> products = ParseProductsUtil.parse(productsJson);
        for (int i = 0; i < products.size(); i++) {
            SportEquipment prod = products.get(i);
            goods.put(prod, prod.count);
        }
        listenUserCommands();
    }
    // команды
    private static void listenUserCommands() {
        System.out.println("enter your command: rent, report, instock, exit");
        String command = readLine();
        switch (command) {
            case RENT:
                if (selectedIds.size() < 3)
                    doRent();
                else {
                    System.out.println("you can get only 3 products");
                    listenUserCommands();
                }
                break;
            case REPORRT:
                doReport();
                listenUserCommands();
                break;
            case INSTOCK:
                doInstock();
                listenUserCommands();
                break;
            case EXIT:
                doExit();
                break;
            default:
                System.out.println("command, not detected inter your command again");
                listenUserCommands();
        }
    }

    private static void doRent() {
        // show all products
        doInstock();
//        System.out.println("Available:");
//        for (Map.Entry<SportEquipment, Integer> prod : goods.entrySet()) {
//            SportEquipment equipment = prod.getKey();
//            System.out.println(equipment.toString() + " count:" + prod.getValue().toString());
//        }
        Integer id = listentProdID();
        for (Map.Entry<SportEquipment, Integer> prod : goods.entrySet()) {
            boolean selected = id.equals(prod.getKey().id);
            if (selected) {
                order.add(prod.getKey());
                System.out.println("selected " + prod.getKey().toString());
                selectedIds.add(id);
                prod.setValue(prod.getValue() - 1);
            }
        }
        cart.setUnits(order);
//        System.out.println(selectedIds.toString());
//        if (order.size() > 0) {
//
////        cart.showOrder();
//        } else {
//            System.out.println("products not found");
//        }
        listenUserCommands();

    }


    private static Integer listentProdID() {
        System.out.println("enter products ID");
        String idStr = readLine();
        Integer id = null;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.out.println("input error");
            listenUserCommands();
        }
        return id;
    }

    private static void doReport() {
//      предметы взяты в аренду
        cart.showOrder();
//        listenUserCommands();
    }

    private static void doInstock() {
        // предметы в наличии
        System.out.println("Available:");
        for (Map.Entry<SportEquipment, Integer> prod : goods.entrySet()) {
            SportEquipment equipment = prod.getKey();
            System.out.println(equipment.toString() + " count:" + prod.getValue().toString());
        }
//        listenUserCommands();
    }

    private static void doExit() {
        System.out.println("Programm finished");
    }

    private static String getProducts() {
        String fileName;
        if (fileReadCounter > 1) {
            System.out.println("loaded default file");
            fileName = "products.txt";
            fileReadCounter = 0;
        } else {
            System.out.println("enter file name with products");
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
        String readCommand = null;
        try {
            readCommand = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return readCommand;
    }

}
