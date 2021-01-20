package com.example.prototype_db;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.news_layout);

        Intent intent = getIntent();
    }
    public void backButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
