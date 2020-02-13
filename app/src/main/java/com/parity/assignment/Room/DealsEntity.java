package com.parity.assignment.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "deals_table")
public class DealsEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "likesCount")
    private int likeCount;

    @NonNull
    @ColumnInfo(name = "commentsCount")
    private int commentsCount;

    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    @NonNull
    @ColumnInfo(name = "imageUrl")
    private String imageUrl;

    @NonNull
    @ColumnInfo(name = "category")
    private String category;

    public DealsEntity(String id, String title, int likesCount, int commentsCount, String date, String imageUrl, String category){
        this.id = id;
        this.title = title;
        this.likeCount = likesCount;
        this.commentsCount = commentsCount;
        this.date = date;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public DealsEntity(){

    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    @NonNull
    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(@NonNull int commentsCount) {
        this.commentsCount = commentsCount;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NonNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }
}
