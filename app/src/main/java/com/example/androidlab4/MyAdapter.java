package com.example.androidlab4;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import name.ank.lab4.BibDatabase;
import name.ank.lab4.BibEntry;
import name.ank.lab4.Keys;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        BibDatabase db;

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView title;
            TextView author;
            TextView year;
            public ViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.title);
                author = view.findViewById(R.id.author);
                year = view.findViewById(R.id.year);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.unit, parent, false);
            return new ViewHolder(view);
        }
        MyAdapter(InputStream articles) throws IOException {
            InputStreamReader reader = new InputStreamReader(articles);
            db = new BibDatabase(reader);
        }
        @Override
        public void onBindViewHolder( ViewHolder vh, int pos) {
            //BibEntry entry = db.getEntry(pos);
            BibEntry entry = db.getEntry(pos % db.size());
            vh.title.setText(entry.getField(Keys.TITLE));
            vh.author.setText(entry.getField(Keys.AUTHOR));
            vh.year.setText( entry.getField(Keys.YEAR));
        }

        @Override
        public int getItemCount() {
            return db.size();
            //return Integer.MAX_VALUE;
        }
}
