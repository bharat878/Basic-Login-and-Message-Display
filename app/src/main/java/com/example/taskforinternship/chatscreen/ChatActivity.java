package com.example.taskforinternship.chatscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.taskforinternship.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<String> list = new ArrayList<>();
    ChatListAdapter adapter ;
    AppCompatEditText edtSendMessage;
    AppCompatImageView ivSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initViews();
        onClicks();
    }

    private void initViews() {
        edtSendMessage = findViewById(R.id.edtMessage);
        ivSend = findViewById(R.id.ivSend);
        recyclerView = findViewById(R.id.recyclerViewMessage);
        adapter = new ChatListAdapter(list);
        setRecyclerView();
    }

    private void setRecyclerView() {
        //setRandomMessages();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void onClicks() {
        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageToSend = edtSendMessage.getEditableText().toString();
                sendMessage(messageToSend);
            }
        });
    }


    private void sendMessage(String message){
        if(message.isEmpty()){
            Toast.makeText(this, "Can't send blank message.", Toast.LENGTH_SHORT).show();
            return;
        }
        list.add(message);
        adapter.notifyDataSetChanged();
        edtSendMessage.setText("");
        Objects.requireNonNull(recyclerView.getLayoutManager()).scrollToPosition(list.size());
    }

//    private void setRandomMessages() {
//        list.add("Hello ");
//        list.add("How are you? ");
//        list.add("I am good. :-) ");
//        list.add("What about you ? :-D ");
//        list.add("I am also fine. ");
  //  }
}
