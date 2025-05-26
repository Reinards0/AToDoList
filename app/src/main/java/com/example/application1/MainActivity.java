package com.example.application1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

//    private EditText theTask;
//    private Button addbut;
//    private RecyclerView taskList;
//    private TaskAdapter adapter;
//    private TaskViewModel taskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        EditText theTask = findViewById(R.id.inp1);
        Button addbut = findViewById(R.id.addbtn);
        RecyclerView listView = findViewById(R.id.thelist);
        listView.setLayoutManager(new LinearLayoutManager(this));
        TaskAdapter adapter = new TaskAdapter();
        listView.setAdapter(adapter);
        TaskViewModel viewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        viewModel.getAllTasks().observe(this,tasks -> adapter.setTasks(tasks));

        addbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = theTask.getText().toString().trim();
                if (!txt.isEmpty()) {
                    Task task = new Task(txt, false);
                    viewModel.insert(task);
                    Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    theTask.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Task name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}