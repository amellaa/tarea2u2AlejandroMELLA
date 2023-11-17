package com.example.sqlitecrudalejandro;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciar;
    private EditText etUsuario, etPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btn_iniciar);
        etUsuario = findViewById(R.id.et_usuario);
        etPassword = findViewById(R.id.et_password);
        progressBar = findViewById(R.id.pb);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificar si el campo de usuario no está vacío
                String usuarioText = etUsuario.getText().toString().trim();
                if (!usuarioText.isEmpty()) {
                    // Ejecutar la tarea asíncrona antes de iniciar la nueva actividad
                    new LoginTask().execute(usuarioText);
                } else {
                    // Manejar caso de usuario vacío
                    // Puedes mostrar un mensaje al usuario o realizar otra acción apropiada.
                }
            }
        });
    }

    public void onIniciarButtonClick(View view) {
        // Verificar si el campo de usuario no está vacío
        String usuarioText = etUsuario.getText().toString().trim();
        if (!usuarioText.isEmpty()) {
            new LoginTask().execute(usuarioText);
        } else {
            // Manejar caso de usuario vacío
            // Puedes mostrar un mensaje al usuario o realizar otra acción apropiada.
        }
    }

    private class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            btnIniciar.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                // Simula una tarea en segundo plano con una pausa de 5 segundos
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Manejar la excepción de manera más robusta si es necesario
                return "Error en la tarea asíncrona";
            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.GONE);
            btnIniciar.setEnabled(true);

            // Iniciar la nueva actividad después de que la tarea asíncrona haya terminado
            Intent intent = new Intent(MainActivity.this, Resultado.class);
            intent.putExtra("Usuario", s);
            startActivity(intent);
        }
    }
}
