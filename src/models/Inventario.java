package models;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> product = new ArrayList<>();
    public boolean addProducto(Producto toAdd){
        boolean status;
        status = product.add(toAdd);
        return status;
    }
    public void add(int position, Producto product){this.product.add(position, product);}
    public ArrayList<Producto> getInventario(){
        return product;
    }
}