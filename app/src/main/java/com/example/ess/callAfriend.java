package com.example.ess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class callAfriend extends AppCompatActivity {
    public void call(View view) {
        Uri uri=Uri.parse("tel:9815373921");
        Intent i1=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_afriend);


    }

}
