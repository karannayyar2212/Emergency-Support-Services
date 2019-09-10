package com.example.ess;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class depressionHelpline extends AppCompatActivity {
    public void chatbot(View view){
        Intent i3 = new Intent(this, screenshot.class);
        startActivity(i3);
    }

    public void friend(View view){
        Intent i3 = new Intent(this, callAfriend.class);
        startActivity(i3);
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_depression_helpline);
        }
    }
