package fr.rennes.perso.todo.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.model.TodoTask;

public class TaskAddActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 3;
    private Button btn_add_taskAdd;
    private Button btn_back_taskAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_add);
    }

    protected void addTask(){
        TodoTask tTask = new TodoTask();
    }
}
