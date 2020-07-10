package com.luissilva.formulariodecontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView TextViewNombre;
    TextView TextViewFecha;
    TextView TextViewTelefono;
    TextView TextViewEmail;
    TextView TextViewDescripcion;
    Button BotonEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        TextViewNombre = (TextView) findViewById(R.id.id_TextViewNombre);
        TextViewFecha = (TextView) findViewById(R.id.id_TextViewFecha);
        TextViewTelefono = (TextView) findViewById(R.id.id_TextViewTelefono);
        TextViewEmail = (TextView) findViewById(R.id.id_TextViewEmail);
        TextViewDescripcion = (TextView) findViewById(R.id.id_TextViewDescripcion);
        BotonEditarDatos = findViewById(R.id.id_BotonEditarDatos);

        Bundle extras = getIntent().getExtras();
        String textoparanombre = getResources().getString(R.string.TextoparaNombre);
        String nombre = extras.getString("Nombre");
        TextViewNombre.setText(textoparanombre + " " + nombre);

        String textoparafecha = getResources().getString(R.string.TextoparaFecha);
        String fecha = extras.getString("Fecha");
        TextViewFecha.setText(textoparafecha + " " + fecha);

        String textoparatelefono = getResources().getString(R.string.TextoparaTelefono);
        String telefono = extras.getString("Telefono");
        TextViewTelefono.setText(textoparatelefono + " " + telefono);

        String textoparaemail = getResources().getString(R.string.TextoparaEmail);
        String email = extras.getString("Email");
        TextViewEmail.setText(textoparaemail + " " + email);

        String textoparadescripcion = getResources().getString(R.string.TextoparaDescripcion);
        String descripcion = extras.getString("Descripcion");
        TextViewDescripcion.setText(textoparadescripcion + " " + descripcion);

        BotonEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
