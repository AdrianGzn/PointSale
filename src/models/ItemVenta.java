package models;
import java.util.ArrayList;

public class ItemVenta {
    private ArrayList<ItemProducto> item = new ArrayList<>();
    public void addItemProducto(ItemProducto item){
        this.item.add(item);
    }
    public ItemProducto getProducto(int position){
        return item.get(position);
    }
    public int tamaño(){
        return item.size();
    }
}