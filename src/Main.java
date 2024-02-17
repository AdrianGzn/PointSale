import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class Main {
    private static Administrador administrador = new Administrador(111,123);
    private static Cajero cajero = new Cajero(222,123);
    private static Scanner key =  new Scanner(System.in);
    private static Ventas ventas = new Ventas();
    private static Inventario inventario = new Inventario();
    private static Ingresos ingresos = new Ingresos();
    public static void main(String[] args) {
        int idU, passwordU;
        int opcion;
        String continuar;

        System.out.println("Bienvenido al Sistema de Punto de venta.");

        do{
            opcion = 0;
            System.out.print("\nIngrese su Id: ");
            idU = key.nextInt();
            System.out.print("Ingrese su contraseña: ");
            passwordU = key.nextInt();

            while (opcion != 3){

                if(administrador.getId() == idU && administrador.getPassword() == passwordU){
                    System.out.println("\nMenu de administrador:");
                    System.out.println("1.Apertura de la caja");
                    System.out.println("2.Realizar arqueo");
                    System.out.println("3.Cerrar sesion");
                    System.out.print("Seleccione una opcion: ");
                    opcion = key.nextInt();

                    switch (opcion){
                        case 1:
                            initCaja();
                            break;
                        case 2:
                            arqueo();
                            break;
                    }

                }else if(cajero.getId() == idU && cajero.getPassword() == passwordU){
                    System.out.println("\nMenu de cajero:");
                    System.out.println("1.Registrar venta");
                    System.out.println("2.Alta de un producto");
                    System.out.println("3.Cerrar sesion");
                    System.out.print("Seleccione una opcion: ");
                    opcion = key.nextInt();

                    switch (opcion){
                        case 1:
                            addVenta();
                            break;
                        case 2:
                            addProducto();
                            break;
                    }

                }else {
                    System.out.println("\nError, hay un dato incorrecto, intentelo de nuevo.");
                    break;
                }

            }
            key.nextLine();
            System.out.print("\n¿Desea continuar? (si/no) ");
            continuar = key.nextLine();
        }while (continuar.equals("si"));
    }
    //Metodos para administrador
    public static void initCaja(){
        System.out.print("\nIntroduzca el monto inicial: $");
        int monto = key.nextInt();
        ingresos.setMontoInicial(monto);
        ingresos.iniciarMonto();
    }
    public static void arqueo(){
        ItemVenta productos = new ItemVenta();
        ItemProducto producto = new ItemProducto();

        System.out.println("\nEl monto inicial de la caja es: $" + ingresos.getMontoInicial());
        for (int i = 0; i< ventas.tamaño(); i++){
            productos = ventas.get(i);
            int total = 0;
            System.out.println("\nEn la venta " + (i+1) + " se vendió:");
            for (int j = 0; j <productos.tamaño(); j++){
                producto = productos.getProducto(j);
                int id = producto.getId();
                int cantidad = producto.getCantidad();
                int monto = producto.getMonto();
                total += monto;
                System.out.println("-" + cantidad + " del producto " + id + ": $" + monto);
            }
            System.out.println("El total de la venta " + (i+1) + " es: $" + total);
        }
        System.out.println("\nEl monto final de la caja es: $" + ingresos.getMontoFinal());
    }
    //Metodos para cajero
    public static void addVenta(){
        ItemVenta itemVenta = new ItemVenta();
        int id, cantidad, temporal, ingreso, cambio;
        int totalVenta = 0;
        String continuar;

        do{
            System.out.print("\nIngrese id del producto: ");
            id = key.nextInt();
            System.out.print("Ingrese cantidad del producto: ");
            cantidad = key.nextInt();
            ItemProducto itemProducto = new ItemProducto();
            itemProducto.setId(id);
            itemProducto.setCantidad(cantidad);
            itemVenta.addItemProducto(itemProducto);

            ArrayList<Producto> inventary = inventario.getInventario();
            Producto producto = new Producto();
            boolean flag = false;
            for (int i = 0; i < inventary.size() && flag == false; i++){
                producto = inventary.get(i);
                if(producto.returnId() == id){
                    producto.actualizarCantidad(cantidad);
                    itemProducto.setMonto(producto.returnPrecio());
                    ingresos.setMontoFinal(cantidad, producto.returnPrecio());
                    temporal = cantidad * producto.returnPrecio();
                    totalVenta += temporal;
                    flag = true;
                }
            }
            key.nextLine();
            System.out.println("\n¿Agregar otro producto a la venta? (si/no)");
            continuar = key.nextLine();
        }while (continuar.equals("si"));

        System.out.println("\nEl total de la venta es: $" + totalVenta);
        System.out.print("Introduzca la cantidad de dinero a pagar: $");
        ingreso = key.nextInt();
        cambio = ingreso - totalVenta;
        System.out.println("El cambio es: $" + cambio);


        if(ventas.addVenta(itemVenta)){
            System.out.println("\nVenta realizada con exito");
        }else {
            System.out.println("\nError en la transaccion.");
        }
    }
    public static void addProducto(){
        int id, precio, cantidad;
        System.out.print("\nIntroduzca el id del producto: ");
        id = key.nextInt();
        System.out.print("Introduzca el precio del producto: $");
        precio = key.nextInt();
        System.out.print("Introduzca la cantidad del producto: ");
        cantidad = key.nextInt();
        Producto producto = new Producto();
        producto.setId(id);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);

        if(inventario.addProducto(producto)){
            System.out.println("Producto añadido con exito.");
        }else {
            System.out.println("Error en la transaccion.");
        }
    }
}