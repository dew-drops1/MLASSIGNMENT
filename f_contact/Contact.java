package com.example.f_contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Contact extends AppCompatActivity {
    SQLiteDatabase db;
    String name[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView list=(ListView)findViewById(R.id.list);
        db = openOrCreateDatabase("CONTACTDB", Context.MODE_PRIVATE, null);


        Intent intent=getIntent();

        Cursor c = db.rawQuery("SELECT sname FROM student", null);
        final String name[]=new String[c.getCount()];
        if (c.getCount() == 0) {

            showMessage("Error", "No records found");
            return;
        }
        else {
           // StringBuffer buffer = new StringBuffer();
            int i=0;
            while (c.moveToNext()) {
                /*buffer.append("Admissin Number: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Address: " + c.getString(2) + "\n");
                buffer.append("Email: " + c.getString(3) + "\n");
                buffer.append("Phone: " + ((Cursor) c).getString(4) + "\n\n");*/
                name[i]=c.getString(0);
                i++;

            }
           // showMessage("Student details Details", buffer.toString());
            ArrayAdapter<String> ad=new ArrayAdapter<String>(Contact.this,android.R.layout.simple_list_item_1,name);
            list.setAdapter(ad);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent nm=new Intent(Contact.this,Calling.class);
                    nm.putExtra("name",name[position]);
                    startActivity(nm);
                }
            });
            db.close();
        }
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
