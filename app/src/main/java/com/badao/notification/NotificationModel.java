package com.badao.notification;

public class NotificationModel {
    private int Id;
    private String title;
    private String content;
    private String createdAt;

    public NotificationModel(int id, String title, String content, String createdAt) {
        this.Id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public NotificationModel(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "NotificationModel{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
