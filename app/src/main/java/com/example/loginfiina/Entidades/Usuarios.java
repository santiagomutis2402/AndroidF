package com.example.loginfiina.Entidades;

public class Usuarios {
    private int id;
    private String correo;
    private String password;
    private String nombre;

    public Usuarios(int i, String u, String p, String n){
        id = i;
        correo = u;
        password = p;
        nombre = n;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
