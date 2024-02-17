package models;

public class Ingresos {
    private int montoInicial;
    private int montoFinal;

    public void iniciarMonto() {montoFinal = montoInicial;}
    public int getMontoInicial() {return montoInicial;}
    public void setMontoInicial(int entrada) {montoInicial = entrada;}
    public int getMontoFinal() {return montoFinal;}
    public void setMontoFinal(int cantidad, int precio) {montoFinal += (cantidad * precio);}
}