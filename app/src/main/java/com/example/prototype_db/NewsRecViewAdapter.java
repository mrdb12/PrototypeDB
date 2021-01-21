package com.example.prototype_db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewsRecViewAdapter extends RecyclerView.Adapter<NewsRecViewAdapter.ViewHolder>{


    private ArrayList<News>  news = new ArrayList<>();
    MainActivity mainActivity;
    private Context context;
    public NewsRecViewAdapter(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;

    }

    @NonNull
    @Override
    public NewsRecViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.topic.setText(news.get(position).getTopic());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.switchActivity(NewsActivity.class, position);
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(news.get(position).getImageUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {return news.size();}

    public void setNews(ArrayList<News> news){
        this.news = news;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView topic;
        private ImageView image;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topic = itemView.findViewById(R.id.topic);
            image = itemView.findViewById(R.id.topicImage);
            parent = itemView.findViewById(R.id.topic_layout);
        }
    }
}
