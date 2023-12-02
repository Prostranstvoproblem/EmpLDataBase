package com.example.empldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DBHelper dbHelper;
    TextView tv0ut;
    TextInputEditText ename, esurname, eyear;
    Button btnDel, btnAdd, btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);


        tv0ut = findViewById(R.id.tv0ut);

        ename = findViewById(R.id.name);
        esurname = findViewById(R.id.surname);
        eyear = findViewById(R.id.age);

        btnDel = findViewById(R.id.buttonDel);
        btnAdd = findViewById(R.id.buttonAdd);
        btnGet = findViewById(R.id.buttonGet);

        btnDel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnGet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        LinkedList<Data> list = null;
        if (v.getId() == R.id.buttonDel) {
            dbHelper.DeleteAll();
        } else if (v.getId() == R.id.buttonAdd) {
            String name = ename.getText().toString();
            String sname = esurname.getText().toString();
            int year = Integer.parseInt(eyear.getText().toString());

            Data data = new Data(name, sname, year);
            dbHelper.AddOne(data);
        } else if (v.getId() == R.id.buttonGet) {
            list = dbHelper.GetAll();
            String text = "";
            for (Data data : list) text = text + data.name + " " + data.surname + " " + data.year + "\n";

            tv0ut.setText(text);
        }
    }
}