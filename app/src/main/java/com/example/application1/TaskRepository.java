package com.example.application1;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {
    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;

    public TaskRepository(Application application) {
        TaskDatabase database = TaskDatabase.getInstance(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public void insert(Task task) {
        new InsertTaskAsync(taskDao).execute(task);
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    private static class InsertTaskAsync extends AsyncTask<Task, Void, Void> {
        private TaskDao taskDao;

        private InsertTaskAsync(TaskDao taskDao) {
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.insert(tasks[0]);
            return null;
        }
    }
}
