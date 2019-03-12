package com.example.practicatema7.DataBaseManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.practicatema7.DataBaseManager.Esquema.Sitios;

public class DB_SQLite extends SQLiteOpenHelper {

    public static final int OPEN_MODE_READ = 1;
    public static final int OPEN_MODE_WRITE = 2;

    private static final String DATABASE_NAME = "sitios.sqlite";
    private static final int    DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Sitios.TABLE_NAME + " (" +
                    Sitios.COLUMN_NAME_ID + " " + Sitios.COLUMN_TYPE_ID + " PRIMARY KEY AUTOINCREMENT, " +
                    Sitios.COLUMN_NAME_NOMBRE + " " + Sitios.COLUMN_TYPE_NOMBRE + "," +
                    Sitios.COLUMN_NAME_COMENTARIOS + " " + Sitios.COLUMN_TYPE_COMENTARIOS +  "," +
                    Sitios.COLUMN_NAME_CATEGORIA + " " + Sitios.COLUMN_TYPE_CATEGORIA + "," +
                    Sitios.COLUMN_NAME_VALORACION + " " + Sitios.COLUMN_TYPE_VALORACION +  "," +
                    Sitios.COLUMN_NAME_LONGITUD + " " + Sitios.COLUMN_TYPE_LONGITUD +  "," +
                    Sitios.COLUMN_NAME_LATITUD + " " + Sitios.COLUMN_TYPE_LATITUD +  ")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Sitios.TABLE_NAME;

    public DB_SQLite(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public static SQLiteDatabase conectar (Context context, int open_mode) {
        DB_SQLite db = new DB_SQLite(context);
        SQLiteDatabase conn;
        switch (open_mode) {
            case OPEN_MODE_READ:  conn = db.getReadableDatabase(); break;
            case OPEN_MODE_WRITE: conn = db.getWritableDatabase(); break;
            default:              conn = db.getReadableDatabase(); break;
        }
        return conn;
    }

    public static void desconectar (SQLiteDatabase conn) {
        conn.close();
    }
}