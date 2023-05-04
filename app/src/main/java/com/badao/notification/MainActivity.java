package com.badao.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NotificationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w("Firebase", "Fetching FCM registration token failed:" + task.getException());
                        return;
                    }


                    // Get new FCM registration token
                    String token = task.getResult();
                    Log.w("Firebase", token);
                });
        List<NotificationModel> notificationModels = NotificationDB.getInstance(this).getAll();
        for(NotificationModel notificationModel : notificationModels){
            Log.e("notificationModels", notificationModels.toString());
        }
        adapter = new NotificationAdapter(
                notificationModels
        );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.reload(NotificationDB.getInstance(this).getAll());
    }
}

