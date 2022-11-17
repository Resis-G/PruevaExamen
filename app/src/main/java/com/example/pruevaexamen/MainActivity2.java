package com.example.pruevaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv0,tv1,tv2,tv3,tv4,tv5;
    private RadioButton rb1,rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        tv0 = (TextView) findViewById(R.id.textView2);
        tv1 = (TextView) findViewById(R.id.textView11);
        tv2 = (TextView) findViewById(R.id.textView12);
        tv3 = (TextView) findViewById(R.id.textView13);
        tv4 = (TextView) findViewById(R.id.textView14);
        tv5 = (TextView) findViewById(R.id.textView15);

        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);

        Calcular();

    }

    public void selecciono(View view){
        Calcular();
    }

    private void Calcular() {
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        int Cantidad_De_Entrada = bundle.getInt("Cantidad_de_entradas");
        String Zona_seleccionada = bundle.getString("Zona_seleccionada");

        int precio_por_entrada = 0;
        if(Zona_seleccionada.equalsIgnoreCase("ZONA GENERAL")){
            precio_por_entrada =5;
            tv0.setText("Zona General");
        }else if(Zona_seleccionada.equalsIgnoreCase("ZONA GOLES")){
            precio_por_entrada =4;
            tv0.setText("Zona Goles");
        }else if(Zona_seleccionada.equalsIgnoreCase("ZONA ANFITEATRO")){
            precio_por_entrada =3;
            tv0.setText("Zona Anfiteatro");
        }
        int Total = precio_por_entrada * Cantidad_De_Entrada;

        tv1.setText(precio_por_entrada+"€");
        tv2.setText(Cantidad_De_Entrada+"");
        tv3.setText(Total+"€");

        int Descuento_socio =0;

        if(rb1.isChecked()){
            Descuento_socio = (Total/10);
            tv4.setText(Descuento_socio+"€");
        }else if(rb2.isChecked()){
            tv4.setText(Descuento_socio+"€");
        }

        int Total_A_Pagar=Total-Descuento_socio;
        tv5.setText(Total_A_Pagar+"€");
    }


}