package com.fungdoo.project.fungdoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

          navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationDrawerItemSelected(0);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            onNavigationDrawerItemSelected(0);
        }  else if (id == R.id.nav_faver) {
            onNavigationDrawerItemSelected(0);

            Intent intent = new Intent(getApplicationContext() , Favorite.class);
            startActivity(intent);
        } else if (id == R.id.nav_account) {

            onNavigationDrawerItemSelected(0);
            Intent intent = new Intent(getApplicationContext() , Profile.class);
            startActivity(intent);
        }else if (id == R.id.nav_logout) {
            onNavigationDrawerItemSelected(0);
            MainActivity.this.finish();
        }else{

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onNavigationDrawerItemSelected(int position) {
        android.app.Fragment fragment=null;
        switch (position) {
            case 0: //search//todo

                fragment = getFragmentManager().findFragmentByTag(SearchData.TAG);
                fragment = new SearchData();
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, SearchData.TAG).commit();
                break;
            case 1: //stats

                break;
            case 2: //my account //todo


                break;
            case 3: //my account //todo


                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @Override
    protected void onStart() {
        super.onStart();
        navigationView.getMenu().getItem(0).setChecked(true);
        onNavigationDrawerItemSelected(0);
    }
}
