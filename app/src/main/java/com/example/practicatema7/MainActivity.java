package com.example.practicatema7;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;
    ImageView imgWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSpinner = findViewById(R.id.mSpinner);
        imgWord = findViewById(R.id.imgWord);

      imgWord.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
              startActivity(new Intent(MainActivity.this,PantallaMapa.class));
          }
      });


      ArrayList<String> categorias = new ArrayList<>();
        categorias.add("España");
        categorias.add("Londres");
        categorias.add("Francia");
        categorias.add("Italia");
        categorias.add("Japón");
        categorias.add("Alemania");

        ArrayAdapter adp = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, categorias);
        mSpinner.setAdapter(adp);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String categoria = (String) mSpinner.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this,"Seleccionaste:" + categoria, Toast.LENGTH_SHORT) .show();
            }
            public void onNothingSelected(AdapterView<?> parent){}
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PantallaNuevoEdicion.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
