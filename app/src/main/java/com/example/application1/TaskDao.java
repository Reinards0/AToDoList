package com.example.application1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(Task task);
    @Query("Select * From task_table")
    LiveData<List<Task>> getAllTasks();
}
