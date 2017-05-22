package com.luisenrique.formulario;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;
    private int anio;
    private int mes;
    private int dia;
    private String nombreR;
    private String telefonoR;
    private String emailR;
    private String descripcionR;
    private int anioR;
    private int mesR;
    private int diaR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle parametros = getIntent().getExtras();
        if(parametros != null){
            nombreR       = parametros.getString("nombre");
            telefonoR     = parametros.getString("telefono");
            emailR        = parametros.getString("email");
            descripcionR  = parametros.getString("descripcion");
            anioR         = parametros.getInt("anio");
            mesR          = parametros.getInt("mes");
            diaR          = parametros.getInt("dia");

            EditText inombre       = (EditText) findViewById(R.id.iName);
            EditText itelefono     = (EditText) findViewById(R.id.iTel);
            EditText iemail        = (EditText) findViewById(R.id.iEmail);
            EditText idescripcion  = (EditText) findViewById(R.id.iDescripcion);
            DatePicker ifecha               = (DatePicker) findViewById(R.id.iFecha);

            inombre.setText(nombreR);
            itelefono.setText(telefonoR);
            iemail.setText(emailR);
            idescripcion.setText(descripcionR);
            ifecha.updateDate(anioR,mesR,diaR);

        }

        enviarDatos();
    }

    public void enviarDatos(){
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText inombre       = (EditText) findViewById(R.id.iName);
                EditText itelefono     = (EditText) findViewById(R.id.iTel);
                EditText iemail        = (EditText) findViewById(R.id.iEmail);
                EditText idescripcion  = (EditText) findViewById(R.id.iDescripcion);
                DatePicker ifecha               = (DatePicker) findViewById(R.id.iFecha);

                nombre      = inombre.getText().toString();
                telefono    = itelefono.getText().toString();
                email       = iemail.getText().toString();
                descripcion = idescripcion.getText().toString();
                anio        = ifecha.getYear();
                mes         = ifecha.getMonth();
                dia         = ifecha.getDayOfMonth();

                Intent intent = new Intent(MainActivity.this, DatosContacto.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("telefono",telefono);
                intent.putExtra("email",email);
                intent.putExtra("descripcion", descripcion);
                intent.putExtra("anio", anio);
                intent.putExtra("mes", mes);
                intent.putExtra("dia", dia);

                startActivity(intent);
                finish();

                //Snackbar.make(v, nombre+telefono+email+descripcion , Snackbar.LENGTH_SHORT).show();
            }
        });
    }


}

