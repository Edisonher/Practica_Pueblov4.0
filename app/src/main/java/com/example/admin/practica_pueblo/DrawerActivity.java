package com.example.admin.practica_pueblo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.admin.practica_pueblo.R;
public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    Intent intent;
    String usuario, correo;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        agregarToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            prepararDrawer(navigationView);
            // Seleccionar item por defecto
            seleccionarItem(navigationView.getMenu().getItem(0));
        }

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        Bundle extras = getIntent().getExtras();
        usuario = extras.getString("username");
        correo = extras.getString("correo");


    }

    private void agregarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner Ã­cono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_reorder_black_18dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void prepararDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        seleccionarItem(menuItem);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });

    }

    private void seleccionarItem(MenuItem itemDrawer) {
        Fragment fragmentoGenerico = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (itemDrawer.getItemId()) {
            case R.id.nav_principal:
                fragmentoGenerico = new FragmentoInicio();
                break;
            case R.id.nav_hotel:
               // fragmentoGenerico = new MapaResFragment();
                fragmentoGenerico = new FragmentoCuenta();
                break;
            case R.id.nav_slideshow:
                fragmentoGenerico = new FragmentoSitios();
                break;
            case R.id.nav_gallery:
                fragmentoGenerico = new FragmentoRestaurante();
                break;
            case R.id.nav_perfil:
                fragmentoGenerico = new datosPerfil();
                break;
            case R.id.nav_salir:
                editor.putInt("login",-1);
                editor.commit();
                intent = new Intent (DrawerActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;



            //startActivity(new Intent(this, LoginActivity.class));
                //break;
        }
        if (fragmentoGenerico != null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_principal, fragmentoGenerico)
                    .commit();
        }

        // Setear tÃ­tulo actual
        setTitle(itemDrawer.getTitle());



    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_drawer_drawer, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
