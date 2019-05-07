package com.example.f_contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calling extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    Button call;
    SQLiteDatabase db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);

        t1=(TextView)findViewById(R.id.vname);
        t2=(TextView)findViewById(R.id.vaddress);
        t3=(TextView)findViewById(R.id.vphone);
        t4=(TextView)findViewById(R.id.txtno);


        call=(Button)findViewById(R.id.btncall);

        Intent in=getIntent();
        String name=in.getStringExtra("name");

        db2=openOrCreateDatabase("CONTACTDB", Context.MODE_PRIVATE, null);

        Cursor c=db2.rawQuery("SELECT * FROM student where sname='"+name+"'",null);
        while (c.moveToNext()){

            t4.setText(c.getString(0));
            t1.setText(c.getString(1));
            t2.setText(c.getString(2));
            t3.setText(c.getString(4));

        }

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cl=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t3.getText().toString()));
                startActivity(cl);
            }
        });



        db2.close();
    }
}
