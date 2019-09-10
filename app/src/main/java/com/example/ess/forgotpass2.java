package com.example.ess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class forgotpass2 extends AppCompatActivity {

    public void done(View view){
        Intent i1 = new Intent(this, newPassword.class);
        startActivity(i1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass2);
    }
}
