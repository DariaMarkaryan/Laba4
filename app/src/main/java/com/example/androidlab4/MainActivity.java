package com.example.androidlab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream resArticles = getResources().openRawResource(R.raw.articles);
        RecyclerView rv = findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        RecyclerView.ItemDecoration decor = new DividerItemDecoration(rv.getContext(), manager.getOrientation());
        rv.addItemDecoration(decor);
        try {
            adapter = new MyAdapter(resArticles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        rv.setAdapter(adapter);
    }
}