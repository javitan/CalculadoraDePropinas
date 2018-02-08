package com.example.javitan.calculadordepropinas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    private Button calcularButton;
    private Button resButton;
    private EditText factura;
    private EditText porcentaje;
    private EditText personas;
    private TextView cantidad;
    private TextView total;
    private TextView totalp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcularButton = findViewById(R.id.calcular);
        resButton = findViewById(R.id.resetear);
        factura = findViewById(R.id.facturaGap);
        porcentaje = findViewById(R.id.porcentajeGap);
        personas = findViewById(R.id.personasGap);
        cantidad = findViewById(R.id.cantidadNumber);
        total = findViewById(R.id.totalNumber);
        totalp = findViewById(R.id.totalpNumber);

        calcularPropina();
        resetear();
    }

    private void calcularPropina(){
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float cantidadPropina = Float.parseFloat(factura.getText().toString());
                float porcentajePropina = Float.parseFloat(porcentaje.getText().toString());
                cantidadPropina = cantidadPropina * (porcentajePropina/100);

                float totalFactura = cantidadPropina + Float.parseFloat(factura.getText().toString());
                float totalPersona = totalFactura / Float.parseFloat(personas.getText().toString());

                cantidad.setText(String.valueOf(cantidadPropina));
                total.setText(String.valueOf(totalFactura));
                totalp.setText(String.valueOf(totalPersona));
            }
        });
    }

    private void resetear(){
        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad.setText("");
                total.setText("");
                totalp.setText("");
                factura.setText("");
                personas.setText("");
                porcentaje.setText("");
            }
        });
    }
}
