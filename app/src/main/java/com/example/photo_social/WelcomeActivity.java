package com.example.photo_social;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView imageLike1;
    private ImageView imageLike2;
    private ImageView imageDislike1;
    private ImageView imageDislike2;
    private ImageView imageShare1;
    private ImageView imageShare2;
    private ImageView imageAdd;

    public ArrayList<String> nombre = new ArrayList<String>();
    public ArrayList<String> hobbie = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_icon_toolbar);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            //nombre = bundle.getStringArrayList();
            //hobbie = bundle.getStringArrayList();
        }





        imageAdd = (ImageView) findViewById(R.id.imageViewAdd);
        imageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        imageLike1 = (ImageView) findViewById(R.id.imageViewLike1);
        imageLike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this, "\uD83D\uDE00", Toast.LENGTH_LONG).show();
            }
        });

        imageLike2 = (ImageView) findViewById(R.id.imageViewLike2);
        imageLike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this, "\uD83D\uDE00", Toast.LENGTH_LONG).show();
            }
        });

        imageDislike1 = (ImageView) findViewById(R.id.imageViewDislike1);
        imageDislike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this, "\uD83D\uDE14", Toast.LENGTH_LONG).show();
            }
        });

        imageDislike2 = (ImageView) findViewById(R.id.imageViewDislike2);
        imageDislike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this, "\uD83D\uDE14", Toast.LENGTH_LONG).show();
            }
        });

        imageShare1 = (ImageView) findViewById(R.id.imageViewShare1);
        imageShare1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        imageShare2 = (ImageView) findViewById(R.id.imageViewShare2);
        imageShare2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
        //Icono en la ToolBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_icon_luncher);
        //Flecha hacia atras funcional en la ToolBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
