package com.example.admin.practica_pueblo;

import com.example.admin.practica_pueblo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de datos estático para alimentar la aplicación
 */
public class Comida {
    private String precio;
    private String nombre;
    private int idDrawable;

    public Comida(String precio, String nombre, int idDrawable) {
        this.precio = precio;
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public static final List<Comida> COMIDAS_POPULARES = new ArrayList<Comida>();
    public static final List<Comida> BEBIDAS = new ArrayList<>();
    public static final List<Comida> POSTRES = new ArrayList<>();
    public static final List<Comida> PLATILLOS = new ArrayList<>();

    static {
        COMIDAS_POPULARES.add(new Comida("Historia", "Titiribi", R.drawable.logotiti));
        COMIDAS_POPULARES.add(new Comida("Recursos", "Titiribi", R.drawable.mina));
        COMIDAS_POPULARES.add(new Comida("Ubicacion", "Titiribi", R.drawable.lameseta));
        COMIDAS_POPULARES.add(new Comida("Fiestas", "Titiribi", R.drawable.titiribi));


        BEBIDAS.add(new Comida("H", "Plaza de Toros", R.drawable.tb5));
        BEBIDAS.add(new Comida("H", "Mina", R.drawable.mina));
        BEBIDAS.add(new Comida("H", "Meseta", R.drawable.lameseta));
        BEBIDAS.add(new Comida("H", "Iglesia", R.drawable.tb5));

        POSTRES.add(new Comida("H", "Plaza de Toros", R.drawable.tb5));
        POSTRES.add(new Comida("H", "Mina", R.drawable.mina));
        POSTRES.add(new Comida("H", "Meseta", R.drawable.lameseta));
        POSTRES.add(new Comida("H", "Iglesia", R.drawable.tb5));

        PLATILLOS.add(new Comida("H", "Plaza de Toros", R.drawable.tb5));
        PLATILLOS.add(new Comida("h", "Mina", R.drawable.mina));
        PLATILLOS.add(new Comida("H", "Meseta", R.drawable.lameseta));
        PLATILLOS.add(new Comida("H", "Iglesia", R.drawable.tb5));




    }

    public String getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
}
