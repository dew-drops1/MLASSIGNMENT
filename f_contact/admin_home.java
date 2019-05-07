package com.example.f_contact;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class admin_home extends AppCompatActivity {

    SQLiteDatabase db;
    Button btnadd,bedit,bview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        bedit = (Button) findViewById(R.id.btnedit);
        btnadd = (Button) findViewById(R.id.btn_addcontact);
        bview = (Button) findViewById(R.id.btnview);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(admin_home.this, ContactAdding.class);
                startActivity(in);

            }
        });


        bedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(admin_home.this,ContactAdding.class);
                startActivity(in);
            }
        });

        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent i=new Intent(admin_home.this,Contact.class);
              startActivity(i);

            }
        });
    }


    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}


