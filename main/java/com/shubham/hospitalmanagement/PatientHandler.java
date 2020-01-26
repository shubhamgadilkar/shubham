package com.shubham.hospitalmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientHandler extends AppCompatActivity {
    public Button button,viewbutton,btn1;
    //MyDbHandler mydb1;
    //ViewData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_handler);
        button = (Button) findViewById(R.id.addpatient);
       // viewbutton=(Button) findViewById(R.id.viewpatient);
        String title,message;
        Button notepad = (Button)findViewById(R.id.note);
        Button btn = (Button)findViewById(R.id.ab);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(PatientHandler.this,about_us.class);
                startActivity(i1);
            }
        });
        Button btn1 = (Button)findViewById(R.id.cont);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik = new Intent(PatientHandler.this,contact.class);
                startActivity(ik);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PatientHandler.this, fillinfo.class);
                startActivity(i);
            }
        });

        notepad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientHandler.this,NotepadActivity.class);
                startActivity(intent);
            }
        });
    }
}
