package com.example.practicatema7;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.practicatema7.Logic.LogicSitios;

import java.util.ArrayList;

public class PantallaNuevoEdicion extends AppCompatActivity {

    EditText txt1,txt2,txt3,txt4;
    Spinner spinner1;
    RatingBar rantingB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_nuevo_edicion);

        txt1.findViewById(R.id.txt1);
        txt2.findViewById(R.id.txt2);
        txt3.findViewById(R.id.txt3);
        txt4.findViewById(R.id.txt4);
        rantingB.findViewById(R.id.ratingB);
        spinner1 =findViewById(R.id.spinner);



        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("España");
        categorias.add("Londres");
        categorias.add("Francia");
        categorias.add("Italia");
        categorias.add("Japón");
        categorias.add("Alemania");

        ArrayAdapter adp = new ArrayAdapter(PantallaNuevoEdicion.this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spinner1.setAdapter(adp);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String categoria = (String) spinner1.getAdapter().getItem(position);
                Toast.makeText(PantallaNuevoEdicion.this,"Seleccionaste:" + categoria, Toast.LENGTH_SHORT) .show();
            }
            public void onNothingSelected(AdapterView<?> parent){}
        });
    }


    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        App.sitiosActivo.setNombre(txt1.getText().toString());
        App.sitiosActivo.setComentarios(txt4.getText().toString());
        App.sitiosActivo.setCategoria(spinner1.getSelectedItemPosition());
        App.sitiosActivo.setValoracion(rantingB.getRating());
        App.sitiosActivo.setLongitud(Float.parseFloat(txt2.getText().toString()));
        App.sitiosActivo.setLatitud(Float.parseFloat(txt3.getText().toString()));

        LogicSitios.insertarSitios(this, App.sitiosActivo );
        Toast.makeText(this, getResources().getString(R.string.toastBD), Toast.LENGTH_SHORT).show();
        return false;
    }




}
