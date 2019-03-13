package com.example.practicatema7;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicatema7.DataBaseManager.DB_SQLite;
import com.example.practicatema7.DataBaseManager.Esquema;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        TextView txt1       = findViewById(R.id.txt1);
        TextView txt2       = findViewById(R.id.txt2);
        TextView txt3       = findViewById(R.id.txt3);
        TextView txt4       = findViewById(R.id.txt4);
        RatingBar ratingBar = findViewById(R.id.ratingB);

        //Recogemos los datos almacenados
        txt1.setText(App.sitiosActivo.getNombre());
        txt2.setText(App.sitiosActivo.getLatitud().toString());
        txt3.setText(App.sitiosActivo.getLongitud().toString());
        txt4.setText(App.sitiosActivo.getComentarios());
        ratingBar.setRating(App.sitiosActivo.getValoracion());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.informenu, menu);
        return true;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcionEditar:
                App.SALIDA = 1;
                startActivity(new Intent(getApplicationContext(), PantallaNuevoEdicion.class));
                finish();
                Toast.makeText(this, getResources().getString(R.string.Sitioedit), Toast.LENGTH_LONG).show();
                break;
            case R.id.opcionBorrar:
                eliminar();
                finish();
                break;
        }
        return false;
    }

    private void eliminar()
    {
        DB_SQLite db = new DB_SQLite(this);
        SQLiteDatabase conn = db.getWritableDatabase();
        String sqlWhere = Esquema.Sitios.COLUMN_NAME_ID + " LIKE '" + App.sitiosActivo.getId() + "'";
        conn.delete(Esquema.Sitios.TABLE_NAME, sqlWhere, null);
        Toast.makeText(this, getResources().getString(R.string.Sitioeliminado), Toast.LENGTH_LONG).show();
        conn.close();
    }
}
