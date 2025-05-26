package com.example.application1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    private List<Task> tasks = new ArrayList<>();
    public static class TaskHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CheckBox checkBox;
        public TaskHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.task_text);
            checkBox = itemView.findViewById(R.id.task_checkbox);
        }
    }
    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item,parent,false);
        return new TaskHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position){
        Task currentTask = tasks.get(position);
        holder.textView.setText(currentTask.getText());
        holder.checkBox.setChecked(currentTask.isDone());
    }
    @Override
    public int getItemCount() {
        return tasks.size();
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }
}
