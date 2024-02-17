package models;

public class Usuario {
    private int id;
    private int password;

    public Usuario(int id, int password) {
        this.id = id;
        this.password = password;
    }
    public int getId() {return id;}
    public int getPassword() {return password;}
}