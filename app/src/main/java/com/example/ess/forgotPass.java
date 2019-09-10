package com.example.ess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class forgotPass extends AppCompatActivity {
    public void otpsend(View view){
        Intent i1 = new Intent(this, forgotpass2.class);
        startActivity(i1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
    }
}
