package com.example.admin.practica_pueblo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    Intent intent;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        usuario = prefs.getString("username","noname");
        password = prefs.getString("password","nopass");
        correo = prefs.getString("correo","nocorreo");

        Log.d("login",String.valueOf(prefs.getInt("login",-1)));
        Log.d("username", usuario);
        Log.d("password", password);
        Log.d("correo", correo);

        if ( prefs.getInt("login",-1) == 1) { // 1 hay alguien loggeado -1 no hay
            intent = new Intent(LoginActivity.this, DrawerActivity.class);
            intent.putExtra("username",usuario);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }



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

            editor.putString("username",usuario);
            editor.putString("password",password);
            editor.putString("correo",correo);
            editor.commit();

            Log.d("username",usuario);
        } else {
            if (requestCode == 1234 && resultCode == RESULT_CANCELED){
                Toast.makeText(this, "ERROR en Registro", Toast.LENGTH_SHORT).show();
            }
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

            editor.putInt("login",1);
            editor.commit();

            Intent intent = new Intent(this,DrawerActivity.class);

            intent.putExtra("username",usuario);
            intent.putExtra("correo",correo);


            startActivity(intent);
            finish();
        }

    }


}
