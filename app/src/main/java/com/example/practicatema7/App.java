package com.example.practicatema7;

import android.content.Context;

import com.example.practicatema7.Model.Sitios;

import java.util.ArrayList;
import java.util.List;

public class App {

    public final static int INSERTAR = 1;
    public final static int EDITAR = 2;
    public final static int INFORMACION = 3;
    public static int SALIDA;
    public static int accion;
    public static Sitios sitiosActivo;

    public static List<String> getCategoria(Context context) {
        List<String> list = new ArrayList<String>();
        list.add(context.getResources().getString(R.string.cat1));
        list.add(context.getResources().getString(R.string.cat2));
        list.add(context.getResources().getString(R.string.cat3));
        list.add(context.getResources().getString(R.string.cat4));
        list.add(context.getResources().getString(R.string.cat5));
        return list;

    }
}
