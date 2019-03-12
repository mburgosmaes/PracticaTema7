package com.example.practicatema7.Logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.practicatema7.DataBaseManager.DB_SQLite;
import com.example.practicatema7.DataBaseManager.Esquema;
import com.example.practicatema7.Model.Sitios;

import java.util.ArrayList;
import java.util.List;

public class LogicSitios {

    public static void insertarSitios(Context context, Sitios p) {
        ContentValues content = new ContentValues();
        content.put(Esquema.Sitios.COLUMN_NAME_NOMBRE, p.getNombre());
        content.put(Esquema.Sitios.COLUMN_NAME_COMENTARIOS, p.getComentarios());
        content.put(Esquema.Sitios.COLUMN_NAME_CATEGORIA, p.getCategoria());
        content.put(Esquema.Sitios.COLUMN_NAME_VALORACION, p.getValoracion());
        content.put(Esquema.Sitios.COLUMN_NAME_LONGITUD, p.getLongitud());
        content.put(Esquema.Sitios.COLUMN_NAME_LATITUD, p.getLatitud());

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.insert(Esquema.Sitios.TABLE_NAME, null, content);
        DB_SQLite.desconectar(conn);
    }

    public static void eliminarSitios(Context context, Sitios p) {
        String sqlWhere = Esquema.Sitios.COLUMN_NAME_ID + " = " + p.getId();
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.delete(Esquema.Sitios.TABLE_NAME, sqlWhere, null);
        DB_SQLite.desconectar(conn);
    }

    public static void editarSitios(Context context, Sitios p) {
        ContentValues content = new ContentValues();
        content.put(Esquema.Sitios.COLUMN_NAME_NOMBRE, p.getNombre());
        content.put(Esquema.Sitios.COLUMN_NAME_COMENTARIOS, p.getComentarios());
        content.put(Esquema.Sitios.COLUMN_NAME_CATEGORIA, p.getCategoria());
        content.put(Esquema.Sitios.COLUMN_NAME_VALORACION, p.getValoracion());
        content.put(Esquema.Sitios.COLUMN_NAME_LONGITUD, p.getLongitud());
        content.put(Esquema.Sitios.COLUMN_NAME_LATITUD, p.getLatitud());

        String sqlWhere = Esquema.Sitios.COLUMN_NAME_ID + " = " + p.getId();
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.update(Esquema.Sitios.TABLE_NAME, content, sqlWhere, null);
        DB_SQLite.desconectar(conn);
    }

    public static List listaSitios(Context context) {
        List prod = new ArrayList<>();
        String[] sqlFields = {Esquema.Sitios.COLUMN_NAME_ID, Esquema.Sitios.COLUMN_NAME_NOMBRE, Esquema.Sitios.COLUMN_NAME_COMENTARIOS, Esquema.Sitios.COLUMN_NAME_CATEGORIA, Esquema.Sitios.COLUMN_NAME_VALORACION, Esquema.Sitios.COLUMN_NAME_LONGITUD, Esquema.Sitios.COLUMN_NAME_LATITUD};
        String sqlWhere = "";
        String sqlOrderBy = Esquema.Sitios.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Sitios.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            prod = null;
        } else {
            cursor.moveToFirst();
            do {
                Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Sitios.COLUMN_NAME_ID));
                String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Sitios.COLUMN_NAME_NOMBRE));
                String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Sitios.COLUMN_NAME_COMENTARIOS));
                int dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Sitios.COLUMN_NAME_CATEGORIA));
                Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Sitios.COLUMN_NAME_VALORACION));
                Float dataLongitud = cursor.getFloat(cursor.getColumnIndex(Esquema.Sitios.COLUMN_NAME_LONGITUD));
                Float dataLatitud = cursor.getFloat(cursor.getColumnIndex(Esquema.Sitios.COLUMN_NAME_LATITUD));



                prod.add(new Sitios(dataId, dataNombre, dataComentarios, dataCategoria, dataValoracion, dataLongitud, dataLatitud));
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB_SQLite.desconectar(conn);
        return prod;
    }

}
