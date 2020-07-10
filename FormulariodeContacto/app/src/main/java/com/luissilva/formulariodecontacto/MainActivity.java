package com.luissilva.formulariodecontacto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    String fechadenacimiento;
    ImageView iconoFecha;
    EditText editTextNombre;
    EditText editTextFecha;
    EditText editTextTelefono;
    EditText editTextEmail;
    EditText editTextDescripcion;
    Button botonSiguiente;
    DatePickerDialog datePickerDialog;
    int añoint = 0;
    int mesint = 0;
    int diaint = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iconoFecha = (ImageView) findViewById(R.id.id_IVFecha);
        editTextNombre = (EditText) findViewById(R.id.id_EditTextNombre);
        editTextFecha = (EditText) findViewById(R.id.id_EditTextFecha);
        editTextTelefono = (EditText) findViewById(R.id.id_EditTextTelefono);
        editTextEmail = (EditText) findViewById(R.id.id_EditTextEmail);
        editTextDescripcion = (EditText) findViewById(R.id.id_EditTextDescripcion);
        botonSiguiente = (Button) findViewById(R.id.id_BotonSiguiente);

        if (añoint == 0){
            final Calendar calendar = Calendar.getInstance();
            añoint = calendar.get(Calendar.YEAR);
            mesint = calendar.get(Calendar.MONTH);
            diaint = calendar.get(Calendar.DAY_OF_MONTH);
        }

        iconoFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int año, int mes, int dia) {
                        añoint = año;
                        mesint = mes;
                        diaint = dia;
                        fechadenacimiento = diaint+"/"+ (mesint + 1) +"/"+añoint;
                        editTextFecha.setText(fechadenacimiento);

                    }
                },añoint, mesint, diaint);
                datePickerDialog.show();
             }

        });


        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, ConfirmarDatos.class);
                intento.putExtra("Nombre", editTextNombre.getText().toString());
                intento.putExtra("Fecha", editTextFecha.getText().toString());
                intento.putExtra("Telefono", editTextTelefono.getText().toString());
                intento.putExtra("Email", editTextEmail.getText().toString());
                intento.putExtra("Descripcion", editTextDescripcion.getText().toString());
                startActivity(intento);
            }
        });



    }

}
