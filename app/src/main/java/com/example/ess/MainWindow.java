package com.example.ess;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;

import android.support.design.widget.NavigationView;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainWindow extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private Button btnGrant;
    public void dep(View view){
        Intent i1 = new Intent(this, depressionHelpline.class);
        startActivity(i1);
    }
    public void otpcheck(View view){
        Intent i1 = new Intent(this, forgotpass2.class);
        startActivity(i1);


    }

    public void police(View view) {
        Uri uri=Uri.parse("tel:100");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);
    }
    public void ambulance(View view) {
        Uri uri=Uri.parse("tel:01726652666");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);}
    public void hospital(View view) {
        Uri uri=Uri.parse("tel:01724692222");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);}
    public void fire(View view) {
        Uri uri=Uri.parse("tel:09872511100");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);}
    public void women(View view) {
        Uri uri=Uri.parse("tel:1091");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);}
    public void boy(View view) {
        Uri uri=Uri.parse("tel:09317505759");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);}
    public void snake(View view) {
        Uri uri=Uri.parse("tel:01602280139");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);}
    public void hang(View view) {
        Uri uri=Uri.parse("tel:02227546669");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

       /* if (ContextCompat.checkSelfPermission(MainWindow.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            startActivity(new Intent(MainWindow.this, MapActivity.class));
            finish();
            return;
        }
*/
        btnGrant = findViewById(R.id.button17);

        btnGrant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(MainWindow.this)
                        .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                startActivity(new Intent(MainWindow.this, MapActivity.class));
                                finish();

                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                if (response.isPermanentlyDenied()) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainWindow.this);
                                    builder.setTitle("Permission Denied")
                                            .setMessage("Permission to access device's location is permanently denied.You need to go to settings to allow the permission ")
                                            .setNegativeButton("Cancel", null)
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Intent intent = new Intent();
                                                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                                    intent.setData(Uri.fromParts("pacakge", getPackageName(), null));

                                                }
                                            })
                                            .show();

                                } else {
                                    Toast.makeText(MainWindow.this, "permission denied", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();

                            }
                        })
                        .check();

            }
        });
    }

    public void btnGrantPerm(View view) {
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
