package com.example.ess;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b3;
    DatabaseHelp db;

    public void signup(View view){
        Intent i1 = new Intent(this, signup.class);
        startActivity(i1);
    }
    public void fogpass(View view){
        Intent i2 = new Intent(this, forgotPass.class);
        startActivity(i2);
    }
    public void login(View view){
        Intent i3 = new Intent(this, MainWindow.class);
        startActivity(i3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*db= new DatabaseHelp(this);
        e1=(EditText)findViewById(R.id.editText11);
        e2=(EditText)findViewById(R.id.editText2);
        b3=(Button)findViewById(R.id.button);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email,password);
                if(Chkemailpass==true)
                {
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();



                }else
                    Toast.makeText(getApplicationContext(),"Wrong Mobile number or Password",Toast.LENGTH_SHORT).show();


            }
        });*/
    }
}
