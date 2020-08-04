package com.example.photo_social;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    private EditText edtUser;
    private EditText edtHobbie;
    private Button btnAdd;

    public ArrayList<String> nombre = new ArrayList<String>();
    public ArrayList<String> hobbie = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edtUser = (EditText) findViewById(R.id.editTextNombreAdd);
        edtHobbie = (EditText) findViewById(R.id.editTextHobbieAdd);

        btnAdd = (Button) findViewById(R.id.buttonPersonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddActivity.this, "Agrgado corectamente.", Toast.LENGTH_LONG).show();
                nombre.add(edtUser.getText().toString());
                hobbie.add(edtHobbie.getText().toString());
                Intent intent = new Intent(AddActivity.this,WelcomeActivity.class);
                intent.putExtra("name", nombre);
                intent.putExtra("hobbie", hobbie);
                startActivity(intent);
            }
        });

    }
}
