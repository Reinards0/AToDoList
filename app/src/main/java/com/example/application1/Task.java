package com.example.application1;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String text;
    private boolean done;
    public Task(@NonNull String text, boolean done){
        this.text = text;
        this.done = done;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getText() { return text; }
    public boolean isDone() { return done; }
    public void setDone(boolean don) {
        done = don;
    }
}
