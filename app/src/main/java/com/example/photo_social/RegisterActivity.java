package com.example.photo_social;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    public ArrayList<String> user = new ArrayList<String>();
    public ArrayList<String> mail = new ArrayList<String>();
    public ArrayList<String> pass = new ArrayList<String>();

    private Button btnRegister;
    private EditText edtUser;
    private EditText edtMail;
    private EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        Bundle bundle =getIntent().getExtras();
        user = bundle.getStringArrayList("usuario");
        mail = bundle.getStringArrayList("correo");
        pass = bundle.getStringArrayList("contrasena");

        edtUser = (EditText) findViewById(R.id.editTextUsuario);
        edtMail = (EditText) findViewById(R.id.editTextEmail);
        edtPass = (EditText) findViewById(R.id.editTextPass);

        btnRegister = (Button) findViewById(R.id.buttonRegistrarse);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.add(edtUser.getText().toString());
                mail.add(edtMail.getText().toString());
                pass.add(edtPass.getText().toString());
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("usuario", user);
                intent.putExtra("correo", mail);
                intent.putExtra("contrasena",pass);
                startActivity(intent);

                Toast.makeText(RegisterActivity.this, user.get(0), Toast.LENGTH_LONG).show();
            }
        });
    }
}
