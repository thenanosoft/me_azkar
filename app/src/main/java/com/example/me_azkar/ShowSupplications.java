package com.example.me_azkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Switch;

import java.util.ArrayList;

public class ShowSupplications extends AppCompatActivity {
    Switch switchTranslation;
    ArrayList<Model> arrayList;
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;

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

        setContentView(R.layout.activity_show_data);

        recyclerView = findViewById(R.id.recycler_view);
        databaseHelper = new DatabaseHelper(this);

        displayRow();
    }

    private void displayRow() {
        arrayList = new ArrayList<>(databaseHelper.getRowData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Adapter adapter = new Adapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}