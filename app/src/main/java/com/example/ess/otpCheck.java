package com.example.ess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class otpCheck extends AppCompatActivity {
    public void otpcheck(View view){
        Intent i1 = new Intent(this, forgotpass2.class);
        startActivity(i1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_check);
    }
}
