package com.example.taskforinternship.chatscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskforinternship.R;

import java.util.List;

public class ChatListAdapter  extends RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder>{

    private List<String> messagesList;

    public ChatListAdapter(List<String> messagesList) {
        this.messagesList = messagesList;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_single_message,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, int position) {
            holder.bind(messagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    class ChatListViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView tvMessage;

        ChatListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
        }

        void bind(String message){
            tvMessage.setText(message);
        }
    }
}
