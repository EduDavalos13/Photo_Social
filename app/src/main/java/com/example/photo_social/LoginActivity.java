package com.example.photo_social;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    public ArrayList<String> user = new ArrayList<String>();
    public ArrayList<String> mail = new ArrayList<String>();
    public ArrayList<String> pass = new ArrayList<String>();

    private EditText edtUser;
    private EditText edtPass;
    private TextView texto;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            user = bundle.getStringArrayList("usuario");
            mail = bundle.getStringArrayList("correo");
            pass = bundle.getStringArrayList("contrasena");
        }else{
            user.add("Edu");
            mail.add("eduardo.davalos@alumnos.uta.cl");
            pass.add("Pass");
        }

        texto =(TextView) findViewById(R.id.textViewRegister);
        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra("usuario", user);
                intent.putExtra("correo", mail);
                intent.putExtra("contrasena",pass);
                startActivity(intent);
            }
        });

        edtUser = (EditText) findViewById(R.id.editUserLogin);
        edtPass = (EditText) findViewById(R.id.editPassLogin);
        btn = (Button) findViewById(R.id.buttonIniciarSesion);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < user.size(); i++){
                    if(user.get(i).equals(edtUser.getText().toString()) && pass.get(i).equals(edtPass.getText().toString())){
                        Toast.makeText(LoginActivity.this, "Entro", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                    }else{
                        if(i >= user.size()){
                            Toast.makeText(LoginActivity.this, "Usiario o contraseña incorrectas", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }
}

