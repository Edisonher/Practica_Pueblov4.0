package com.example.admin.practica_pueblo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, ePassword;
    Button bIniciar;
    TextView tRegistrarse;

    String usuario= " ", password =" ", correo= " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario=(EditText) findViewById(R.id.eUsuario);
        ePassword=(EditText) findViewById(R.id.ePassword);
        bIniciar=(Button) findViewById(R.id.bIniciar);
        tRegistrarse =(TextView) findViewById(R.id.tRegistrarse);

        tRegistrarse.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistroActivity.class);
                startActivityForResult(intent,1234);

            }
        }));




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == 1234 && resultCode == RESULT_OK){
            usuario = data.getExtras().getString("usuario");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");
        }

    }


    public void IniciarSes(View view){
        if ( (eUsuario.getText().toString().matches("")) || ( ePassword.getText().toString().matches("") ) ){
            Toast.makeText(this,"Faltan Datos",Toast.LENGTH_SHORT).show();
        }
        else if (!eUsuario.getText().toString().matches(usuario) || (!ePassword.getText().toString().matches(password)) ){
            Toast.makeText(this,"Datos Incorrectos",Toast.LENGTH_SHORT).show();

        }
        else {
            Intent intent = new Intent(this,DrawerActivity.class);
            startActivity(intent);
            finish();
        }

    }


}
