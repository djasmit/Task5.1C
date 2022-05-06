package com.example.task51c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopNRecyclerViewAdapter extends RecyclerView.Adapter<TopNRecyclerViewAdapter.ViewHolder> {
    private List<News> _newsList;
    private Context _context;
    private OnRowClickListener _listener;

    public TopNRecyclerViewAdapter(List<News> newsList, Context context, OnRowClickListener listener) {
        _newsList = newsList;
        _context = context;
        _listener = listener;
    }

    @NonNull
    @Override
    public TopNRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(_context)
                .inflate(R.layout.top_news_layout, parent, false);
        return new ViewHolder(itemView, _listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopNRecyclerViewAdapter.ViewHolder holder, int position) {
        holder._NewsImage.setImageResource(_newsList.get(position).getThumb());
    }

    @Override
    public int getItemCount() {
        return _newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView _NewsImage;
        OnRowClickListener _onRowClickListener;

        public ViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            _NewsImage = itemView.findViewById(R.id.TopNewsImageView);
            _onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            _onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

    //interface for implementing click listener
    public interface OnRowClickListener {
        void onItemClick(int position);
    }
}
