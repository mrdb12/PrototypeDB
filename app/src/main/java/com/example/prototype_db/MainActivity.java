package com.example.prototype_db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView topicsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, //enables fullscreen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topicsRecView = findViewById(R.id.topicsRecView);

        ArrayList<News> news = new ArrayList<>();
        news.add(new News("Das HLG während Corona", "abcde", "https://www.hlg-hamburg.de/wp-content/uploads/2014/08/IMG_6112.HLG_.jpg"));
        news.add(new News("Die Arbeit mit Moodel", "cdefg Moodel dies das", "https://i.ibb.co/F7d5cmc/moodle.jpg"));
        news.add(new News("UNESCO", "unesco schule auf ehre", "https://www.hlg-hamburg.de/wp-content/uploads/2014/08/DSCI02952-342x266.jpg"));

        NewsRecViewAdapter adapter = new NewsRecViewAdapter(this);
        adapter.setNews(news);

        topicsRecView.setAdapter(adapter);
        topicsRecView.setLayoutManager(new LinearLayoutManager(this));

    }

}