package models;
public class ItemProducto {
    private int id;
    private int cantidad;
    private int monto;

    public void setId(int key){id = key;}
    public void setCantidad(int key){cantidad = key;}
    public void setMonto(int precio) {this.monto = cantidad*precio;}
    public int getId(){return id;}
    public int getCantidad(){return cantidad;}
    public int getMonto() {return monto;}
}