package com.example.task51c;

import android.content.Context;
import android.os.storage.OnObbStateChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RelatedNRecyclerViewAdapter extends RecyclerView.Adapter<RelatedNRecyclerViewAdapter.ViewHolder> {
    private List<News> _newsList;
    private Context _context;
    private OnRowClickListener _listener;

    public RelatedNRecyclerViewAdapter(List<News> newsList, Context context, OnRowClickListener listener) {
        _newsList = newsList;
        _context = context;
        _listener = listener;
    }

    @NonNull
    @Override
    public RelatedNRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(_context)
                .inflate(R.layout.related_story_layout, parent, false);
        return new ViewHolder(itemView, _listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedNRecyclerViewAdapter.ViewHolder holder, int position) {

        holder._TitleText.setText(_newsList.get(position).getTitle());
        holder._DescText.setText(_newsList.get(position).getPublisher());
        holder._NewsImage.setImageResource(_newsList.get(position).getThumb());
    }

    @Override
    public int getItemCount() {
        return _newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView _TitleText;
        TextView _DescText;
        ImageView _NewsImage;
        OnRowClickListener _onRowClickListener;

        public ViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            _TitleText = itemView.findViewById(R.id.RelatedNTitleView);
            _DescText = itemView.findViewById(R.id.RelatedNDescView);
            _NewsImage = itemView.findViewById(R.id.RelatedNImageView);
            _onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            _onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener {
        void onItemClick(int position);
    }
}
