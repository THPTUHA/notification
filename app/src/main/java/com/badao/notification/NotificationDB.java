package com.badao.notification;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationDB extends  SQLiteHelper{
    public  static  final  String name = "notifications";
    public static NotificationDB notificationDB;

    public NotificationDB(@Nullable Context context) {
        super(context);
    }

    public  static NotificationDB  getInstance(Context context){
        if(notificationDB == null){
            notificationDB = new NotificationDB(context);
        }
        return notificationDB;
    }
    public NotificationModel create(NotificationModel notificationModel){
        ContentValues values = new ContentValues();
        notificationModel.setCreatedAt(getTimeCurrent());
        values.put("title", notificationModel.getTitle());
        values.put("content", notificationModel.getContent());
        values.put("created_at", notificationModel.getCreatedAt());
        long id = sqlWrite.insert(NotificationDB.name, null, values);
        notificationModel.setId((int)id);
        return notificationModel ;
    }
    public List<NotificationModel> getAll(){
        List<NotificationModel> notificationModels = new ArrayList<>();
        Cursor cursor = sqlRead.rawQuery("select * from notifications order by created_at desc", null);
        while (cursor != null && cursor.moveToNext()){
            notificationModels.add(exact(cursor));
        }
        return  notificationModels;
    }

    public NotificationModel exact(Cursor cursor){
        int id = cursor.getInt(0);
        String title = cursor.getString(1);
        String content = cursor.getString(2);
        String createdAt = cursor.getString(3);
        return  new NotificationModel(id,title, content,createdAt);
    }

    public static String getTimeCurrent(){
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formattedDate = formatter.format(now);
        return  formattedDate;
    }
}
