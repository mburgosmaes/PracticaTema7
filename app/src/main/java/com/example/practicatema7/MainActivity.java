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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.practicatema7.Logic.LogicSitios;
import com.example.practicatema7.Model.Sitios;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    private static List<Sitios> listaSitios;
    ImageView imgWord;
    Spinner mSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.card_listView);
        listView.addHeaderView(new View(this)); // añade espacio arriba de la primera card
        listView.addFooterView(new View(this)); // añade espacio debajo de la última card
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        App.sitiosActivo = listaSitios.get(position - 1);
                        App.accion = App.INFORMACION;
                        startActivity(new Intent(getApplicationContext(), Informacion.class));
                    }
                }
        );
        //Imagen para mapa
        imgWord = findViewById(R.id.imgWord);

      imgWord.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
              startActivity(new Intent(MainActivity.this,PantallaMapa.class));
          }
      });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                App.sitiosActivo = new Sitios();
                App.accion = App.INSERTAR;
                startActivity(new Intent(MainActivity.this,PantallaNuevoEdicion.class));
            }
        });

        //Spinner de categorias
        mSpinner = findViewById(R.id.mSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                verInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        }

    @Override
    protected void onResume() {
        super.onResume();
        verInfo();
    }

    private void verInfo() {
        CardAdapter listadoDeCards = new CardAdapter(getApplicationContext(), R.layout.list_item_card);
        listaSitios = LogicSitios.listaSitios2(this, mSpinner);
        if (listaSitios == null) {
            listView.setAdapter(null);
        } else {
            for (Sitios p : listaSitios) {
                listadoDeCards.add(p);
            }
            listView.setAdapter(listadoDeCards);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
