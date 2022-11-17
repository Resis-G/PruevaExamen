package com.example.pruevaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText edt1;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt_ingresa_numero);
        spinner = (Spinner)                  findViewById(R.id.spinner_zona);

        String[] opciones = {"ZONA GENERAL","ZONA GOLES","ZONA ANFITEATRO"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);


    }

    public void calcular(View view){

        int Cantidad = Integer.valueOf(String.valueOf(edt1.getText()));
        String seleccion = spinner.getSelectedItem().toString();

        Intent intent = new Intent(this,MainActivity2.class);

        Bundle bundle = new Bundle();
        bundle.putInt("Cantidad_de_entradas", Cantidad);
        bundle.putString("Zona_seleccionada",seleccion);
        intent.putExtras(bundle);

        if (Cantidad<1 || Cantidad >10){
            edt1.setError("el numero de entradas debe estar comprendido entre 1 y 10");
        }else{
            startActivity(intent);
        }
    }
}