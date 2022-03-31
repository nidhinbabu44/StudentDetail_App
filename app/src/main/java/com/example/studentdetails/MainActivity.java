package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2,ed3;
AppCompatButton b1;
String getName,getRoll,getCourse;
DataBaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.rollnum);
        ed3=(EditText) findViewById(R.id.course);
        b1=(AppCompatButton) findViewById(R.id.subbut);
        dbhelper=new DataBaseHelper(this);
        dbhelper.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=ed1.getText().toString();
                getRoll=ed2.getText().toString();
                getCourse=ed3.getText().toString();
                boolean result=dbhelper.insertData(getName,getRoll,getCourse);
                if(result==true)
                {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "Succefully Inserted", Toast.LENGTH_SHORT).show();
                }
            else
                {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}