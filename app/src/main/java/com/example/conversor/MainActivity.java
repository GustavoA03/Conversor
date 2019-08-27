package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText moneda;
    Button bt;
    TextView cambio;
    RadioGroup seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityconversor);

        moneda = (EditText) findViewById(R.id.texto);
        bt = (Button) findViewById(R.id.convertir);
        cambio = (TextView) findViewById(R.id.textView2);
        seleccion = (RadioGroup) findViewById(R.id.selec);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat formateador = new DecimalFormat("#.##");
                String strMoneda = moneda.getText().toString();
                if (strMoneda.matches("")){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "No ha ingresado un valor", Toast.LENGTH_LONG);
                    toast1.show();
                }
                else {
                    if (seleccion.getCheckedRadioButtonId() == R.id.DolarEuro){
                        String textomoneda = moneda.getText().toString();
                        Double dolar1 = Double.parseDouble(textomoneda);

                        Double eur = dolar1*0.9;
                        String eurF = formateador.format(eur);
                        //String eurF = String.valueOf(eur);
                        //eurF = formateador.format(eurF);

                        cambio.setText(textomoneda+" US$ = "+eurF+" €.");
                    }
                    else{
                        String textomoneda = moneda.getText().toString();
                        Double dolar1 = Double.parseDouble(textomoneda);

                        Double eur = dolar1*1.11;
                        String eurF = formateador.format(eur);
                        //String eurF = String.valueOf(eur);
                        //eurF = formateador.format(eurF);

                        cambio.setText(textomoneda+" € = "+eurF+" US$.");
                    }
                }

            }
        });
    }
}
