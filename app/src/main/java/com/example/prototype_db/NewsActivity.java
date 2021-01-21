package com.example.prototype_db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    private TextView newsText;
    private TextView newsHeadline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, //enables fullscreen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.news_layout);

        newsText = findViewById(R.id.newsText);
        newsHeadline = findViewById(R.id.newsHeadline);

        String text = getIntent().getStringExtra("text");
        String headline = getIntent().getStringExtra("headline");

        newsText.setText(text);
        newsHeadline.setText(headline);


    }
}