package com.example.practicatema7;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Service;
import android.location.LocationManager;
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
import java.util.Arrays;
import java.util.List;

import static android.R.layout.simple_spinner_item;

public class PantallaNuevoEdicion extends AppCompatActivity {

    EditText txt1;
    EditText txt2;
    EditText txt3;
    EditText txt4;
    RatingBar rantingB;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_nuevo_edicion);

        txt1     = findViewById(R.id.txt1);
        txt2     = findViewById(R.id.txt2);
        txt3     = findViewById(R.id.txt3);
        txt4     = findViewById(R.id.txt4);
        rantingB = findViewById(R.id.ratingB);
        spinner1 = findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
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
        App.sitiosActivo.setCategoria(spinner1.getSelectedItemPosition());
        App.sitiosActivo.setComentarios(txt4.getText().toString());
        App.sitiosActivo.setValoracion(rantingB.getRating());
        App.sitiosActivo.setLongitud(Float.parseFloat(txt2.getText().toString()));
        App.sitiosActivo.setLatitud(Float.parseFloat(txt3.getText().toString()));

        LogicSitios.insertarSitios(this, App.sitiosActivo );
        Toast.makeText(this, getResources().getString(R.string.toastBD), Toast.LENGTH_SHORT).show();
        return false;
    }


}

