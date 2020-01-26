package com.shubham.hospitalmanagement;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotepadActivity extends AppCompatActivity {
    EditText editText;
    String st;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        editText = (EditText)findViewById(R.id.addnotes);
        btn = (Button)findViewById(R.id.save);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String str1 = preferences.getString("st","");
        editText.setText(str1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st = editText.getText().toString();

                SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(NotepadActivity.this);
                SharedPreferences.Editor editor = preferences1.edit();

                editor.putString("st",st);
                editor.apply();

                Toast.makeText(NotepadActivity.this,"Saved Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}
