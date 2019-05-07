package com.example.f_contact;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

SQLiteDatabase db;
Button bstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bstart=(Button) findViewById(R.id.btnstart);

        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(MainActivity.this,Contact.class);
                startActivity(b);
            }
        });


        db = openOrCreateDatabase("CONTACTDB", Context.MODE_PRIVATE, null);
      //  db.execSQL("delete from student;");
        db.execSQL("CREATE TABLE IF NOT EXISTS  student( sno VARCHAR,sname VARCHAR,saddress VARCHAR,smail VARCHAR,sphone VARCHAR);");


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

            Intent intent =new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_settings1) {

            Intent intent =new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
            return true;
        }


        if (id == R.id.action_settings2) {

            Intent intent =new Intent(MainActivity.this,Gallery.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
