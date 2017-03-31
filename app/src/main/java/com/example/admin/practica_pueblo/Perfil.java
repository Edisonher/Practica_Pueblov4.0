package com.example.admin.practica_pueblo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    TextView tNombre,tCorreo,tPassword;
    String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tNombre = (TextView) findViewById(R.id.PerfilUsuario);
        tPassword = (TextView) findViewById(R.id.PerfilPasswors);
        tCorreo = (TextView) findViewById(R.id.PerfilCorreo);

        SharedPreferences datos = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String Usuario = ": "+datos.getString("usuario","");
        String Password = ": "+datos.getString("password","");
        String Correo = ": "+datos.getString("correo","");
        tNombre.setText(getString(R.string.Usuario)+Usuario);
        tPassword.setText(getString(R.string.Contrasena)+Password);
        tCorreo.setText(getString(R.string.Correo)+Correo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.MiPerfil:

                break;

            case R.id.Cerrar:
                Intent b = new Intent(this,LoginActivity.class);
                startActivity(b);
                finish();
                break;
            case R.id.Hotel:
                Intent b2 = new Intent(this,HotelActivity.class);
                startActivity(b2);
                finish();
                break;

            case R.id.Principal:
                Intent b5 = new Intent(this,MainActivity.class);
                startActivity(b5);
                finish();

                break;
            case R.id.Restaurante:
                Intent b3 = new Intent(this,RestauranteActivity.class);
                startActivity(b3);
                finish();

                break;
            case R.id.Sitios:
                Intent b4 = new Intent(this,SitiosActivity.class);

                startActivity(b4);
                finish();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
