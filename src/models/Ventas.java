package models;
import java.util.ArrayList;
public class Ventas {
    private ArrayList<ItemVenta> ventas= new ArrayList<>();
    public boolean addVenta(ItemVenta toAdd){
        boolean status;
        status = ventas.add(toAdd);
        return status;
    }
    public int tamaño(){
        return ventas.size();
    }
    public ItemVenta get(int position){
        return ventas.get(position);
    }
}