import java.util.ArrayList;

/**
 * Created by W510 on 08.04.2017.
 */
public class RentUnit {
    private SportEquipment[] units;
    void setUnits(ArrayList<SportEquipment> arrayList){
        units=arrayList.toArray(new SportEquipment[arrayList.size()]);
    }
   public void showOrder(){
       System.out.println("in rent now:");
       for (SportEquipment unit:units) {
           System.out.println(unit.toString());
       }

      //  вывестисписок в консоль units
   }
}
