package com.example.f_contact;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactAdding extends AppCompatActivity {

    SQLiteDatabase db;
    Button btnsave,bupdate;
    EditText edadm,edtname,edtaddress,edtmail,edtphn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_adding);


        edtname=(EditText)findViewById(R.id.edtname);
        edtaddress=(EditText) findViewById(R.id.edtaddress);
        edtmail=(EditText)findViewById(R.id.edtmail);
        edtphn=(EditText)findViewById(R.id.edtphn);
        edadm=(EditText)findViewById(R.id.edtadm);


        btnsave=(Button)findViewById(R.id.btnsave);
        bupdate=(Button)findViewById(R.id.btnupdate);




        db = openOrCreateDatabase("CONTACTDB", Context.MODE_PRIVATE, null);
        if (db != null) {
            Toast.makeText(this, "db created", Toast.LENGTH_SHORT).show();
            db.execSQL("CREATE TABLE IF NOT EXISTS  student( sno VARCHAR,sname VARCHAR,saddress VARCHAR,smail VARCHAR,sphone VARCHAR);");
        }

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( edadm.getText().toString().trim().length() == 0 || edtname.getText().toString().trim().length() == 0 ||
                        edtaddress.getText().toString().trim().length() == 0 ||
                        edtmail.getText().toString().trim().length() == 0 || edtphn.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                db.execSQL("INSERT INTO student VALUES('"+edadm.getText()+"','" + edtname.getText() + "','" + edtaddress.getText() +
                        "','" + edtmail.getText() + "','"+edtphn.getText()+"');");

                showMessage("Success", "Contact added");
                clearText();




            }
        });






        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edadm.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter Admission Number");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM student WHERE sno='"+edadm.getText().toString()+"'", null);
                if(c.getCount()!=0)
                {
                    db.execSQL("UPDATE student SET sname='"+edtname.getText().toString()+"',saddress='" + edtaddress.getText().toString() + "',smail='" + edtmail.getText().toString() + "',sphone='"+edtphn.getText().toString()+"' WHERE sno='" + edadm.getText().toString() + "';");
                    showMessage("Success", "Details Modified");
                }
                else {
                    showMessage("Error", "Invalid Admission Number!");
                }
                clearText();

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




    public void clearText() {
        edadm.setText("");
        edtname.setText("");
        edtaddress.setText("");
        edtmail.setText("");
        edtphn.setText("");
        edadm.requestFocus();

    }














}
