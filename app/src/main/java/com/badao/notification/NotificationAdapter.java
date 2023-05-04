package com.badao.notification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter extends  RecyclerView.Adapter<NotificationAdapter.ViewHolder>{
    List<NotificationModel> notificationModels = new ArrayList<>();
    public NotificationAdapter() {
    }

    public NotificationAdapter(List<NotificationModel> notificationModels) {
        this.notificationModels = notificationModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationModel notificationModel = notificationModels.get(position);
        holder.tvTitle.setText(notificationModel.getTitle());
        holder.tvContent.setText(notificationModel.getContent());
        holder.tvCreatedAt.setText(notificationModel.getCreatedAt());
    }

    void reload(List<NotificationModel> notificationModels){
        this.notificationModels = notificationModels;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return notificationModels.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvCreatedAt;
        TextView tvContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCreatedAt = itemView.findViewById(R.id.tvCreatedAt);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }
}
