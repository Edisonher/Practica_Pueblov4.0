package com.example.admin.practica_pueblo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText eUsuario, ePassword, eRpassword, eEmail;
    Button bRegistrarse, bCancelar;
    String PREFS_NAME = "MyPrefsFile";
    SharedPreferences datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        ePassword = (EditText) findViewById(R.id.ePassword);
        eRpassword = (EditText) findViewById(R.id.eRpassword);
        eEmail = (EditText) findViewById(R.id.eEmail);
        bRegistrarse = (Button) findViewById(R.id.bRegistrarse);
        bCancelar = (Button) findViewById(R.id.bCancelar);

        datos = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);


    }

    public void Click(View v) {
        Intent i = new Intent();
        switch (v.getId()) {

            case R.id.bRegistrarse:
                if ((eUsuario.getText().toString().matches("")) || (ePassword.getText().toString().matches("")) ||
                        (eRpassword.getText().toString().matches("")) || (eRpassword.getText().toString().matches("")) ||
                        (eEmail.getText().toString().matches(""))) {
                    Toast.makeText(this, "Faltan Datos", Toast.LENGTH_SHORT).show();
                } else if (!eRpassword.getText().toString().matches(ePassword.getText().toString())) {

                    eRpassword.setError("password no coincide");
                } else {

                    SharedPreferences.Editor edit = datos.edit();
                    edit.putString("usuario", eUsuario.getText().toString());
                    edit.putString("password", ePassword.getText().toString());
                    edit.putString("correo", eEmail.getText().toString());
                    edit.commit();

                    i.putExtra("usuario", eUsuario.getText().toString());
                    i.putExtra("password", ePassword.getText().toString());
                    i.putExtra("correo", eEmail.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();
                }
                break;
            case R.id.bCancelar:
                setResult(RESULT_CANCELED, i);
                finish();
                break;

        }

    }
}