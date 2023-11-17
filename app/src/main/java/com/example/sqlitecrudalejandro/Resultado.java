package com.example.sqlitecrudalejandro;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    private Button btnMapa, btnCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Buscar los botones por sus ID
        btnMapa = findViewById(R.id.btn_mapa);
        btnCrud = findViewById(R.id.btn_crud);

        // Configurar el clic del botón para iniciar la actividad 'mapa'
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent opcion = new Intent(Resultado.this, mapa.class);
                    startActivity(opcion);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // Configurar el clic del botón para iniciar la actividad 'crud'
        btnCrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent opcion = new Intent(Resultado.this, crud.class);
                    startActivity(opcion);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
