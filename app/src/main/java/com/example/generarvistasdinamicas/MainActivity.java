package com.example.generarvistasdinamicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout lienzo1 = null;
    EditText et1 = null;
    int numBoton=1;
    int cantidadDeBotones=0;
    boolean esNumero=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lienzo1 = findViewById(R.id.lienzo);
        et1 = findViewById(R.id.et);
    }
    
    public void escribeAlgo(View v) {


        lienzo1.removeAllViews();
        numBoton = 1;

        try {
            cantidadDeBotones = Integer.parseInt(""+et1.getText());
            esNumero=true;
        } catch (NumberFormatException nfe) {
            esNumero=false;
            Toast.makeText(getApplicationContext(),"caracter erroneo", Toast.LENGTH_LONG).show();
        }

        if (esNumero) {
            for (int i = 0; i < cantidadDeBotones; i++) {
                Button btn1 = new Button(this);
                btn1.setId(20+numBoton);
                btn1.setText("Boton" + numBoton);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        et1.setText(" " + btn1.getText() + " pulsado");
                    }
                });
                lienzo1.addView(btn1);
                numBoton++;
            }
        }
    }
}