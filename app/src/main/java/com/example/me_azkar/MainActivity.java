package com.example.me_azkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // object's database helper class
    DatabaseHelper databaseHelper;

    private static String supplication;

    Button btnMorning, btnEvening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        btnMorning = findViewById(R.id.btnMorning);
        btnEvening = findViewById(R.id.btnEvening);


        // morning azkar button
        try {
            btnMorning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowSupplications.class);
                setSupplication("supplication_morning");
                startActivity(intent);
            }
        });
        }
        catch (Exception e) {};

        try {
            btnEvening.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ShowSupplications.class);
                    setSupplication("supplication_evening");
                    startActivity(intent);
                }
            });
        }
        catch (Exception e) {};

    }

    public static String getSupplication() {
        return supplication;
    }

    public static void setSupplication(String supplication) {
        MainActivity.supplication = supplication;
    }

}