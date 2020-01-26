package com.shubham.hospitalmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    private EditText getUser;
    private EditText getPass;

    public void GoToPatientDetails(View view)
    {
        getUser = (EditText)findViewById(R.id.editText);
        getPass=(EditText)findViewById(R.id.editText2);
        String username = getUser.getText().toString().trim();
        String userPass = getPass.getText().toString().trim();

        if(username.equals("Admin")&&userPass.equals("12345"))
        {
            Intent intent = new Intent(this,PatientHandler.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(SecondActivity.this,"Enter Valid Username and Password",Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }



}
