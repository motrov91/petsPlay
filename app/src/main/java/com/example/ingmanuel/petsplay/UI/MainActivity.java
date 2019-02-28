package com.example.ingmanuel.petsplay.UI;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ingmanuel.petsplay.Database.Entity.Pet;
import com.example.ingmanuel.petsplay.Fragments.CareFragment;
import com.example.ingmanuel.petsplay.Fragments.CreateNewPet;
import com.example.ingmanuel.petsplay.Fragments.CreateNewUser;
import com.example.ingmanuel.petsplay.Fragments.MyPetsFragment;
import com.example.ingmanuel.petsplay.Fragments.ProfileFragment;
import com.example.ingmanuel.petsplay.Fragments.ProfilePet;
import com.example.ingmanuel.petsplay.Interface.IComCreateUser;
import com.example.ingmanuel.petsplay.Interface.IComFragments;
import com.example.ingmanuel.petsplay.Interface.IComPetDescription;
import com.example.ingmanuel.petsplay.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CareFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener,
            MyPetsFragment.OnFragmentInteractionListener, ProfilePet.OnFragmentInteractionListener,  IComFragments, IComPetDescription {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;
        boolean fragmentSeleccionado = false;

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            fragment = new ProfileFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.myPets) {
            fragment = new MyPetsFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.care) {
            fragment = new CareFragment();
            fragmentSeleccionado = true;
        }

        if (fragmentSeleccionado = true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {}

    @Override
    public void send() {
        CreateNewPet createNewPet = new CreateNewPet();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, createNewPet).addToBackStack(null).commit();
    }

    @Override
    public void sendDescriptionPet(Pet pet) {
        ProfilePet profilePet = new ProfilePet();
        Bundle bundleEnviar = new Bundle();
        bundleEnviar.putSerializable("Object", pet);
        profilePet.setArguments(bundleEnviar);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, profilePet).addToBackStack(null).commit();
    }

}
