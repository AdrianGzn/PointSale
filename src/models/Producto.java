package models;

public class Producto {
    private int id;
    private int precio;
    private int cantidad;

    public void setId(int id) {this.id = id;}
    public void setPrecio(int precio) {this.precio = precio;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public int returnId(){return id;}
    public int returnPrecio(){return precio;}
    public int returnCantidad(){return cantidad;}
    public void actualizarCantidad(int cantidadIngresada){
        cantidad -= cantidadIngresada;
    }
}
