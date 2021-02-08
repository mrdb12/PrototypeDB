package com.example.prototype_db;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView topicsRecView;
    private ArrayList<News> news = new ArrayList<>();

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0){
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
        System.out.println("test");
        topicsRecView = findViewById(R.id.topicsRecView);

        news.add(new News("Das HLG während Corona","ababababababababababababababababababababababababababababababababababababababababababbababababababababababababababaababababababababa", "https://www.hlg-hamburg.de/wp-content/uploads/2014/08/IMG_6112.HLG_.jpg"));
        news.add(new News("Die Arbeit mit Moodel", "cdefg Moodel dies das", "https://i.ibb.co/F7d5cmc/moodle.jpg"));
        news.add(new News("UNESCO", "unesco schule auf ehre", "https://www.hlg-hamburg.de/wp-content/uploads/2014/08/DSCI02952-342x266.jpg"));

        NewsRecViewAdapter adapter = new NewsRecViewAdapter(this, this);
        adapter.setNews(news);

        topicsRecView.setAdapter(adapter);
        topicsRecView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void switchActivity(Class<?> cls, int position){
        Intent intent = new Intent(MainActivity.this,cls);  // (mainActivity, menu1.class);
        String headline = news.get(position).getTopic();
        intent.putExtra("headline", headline);

        String text = news.get(position).getText();
        intent.putExtra("text", text);
        startActivity(intent);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    public int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
}