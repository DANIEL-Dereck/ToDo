package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        btn_back_taskAdd = (Button) findViewById(R.id.btn_back_taskAdd);
        btn_back_taskAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TaskAddActivity.this, TaskListActivity.class);
                TaskAddActivity.this.startActivityForResult(intent, 2);
            }
        });
    }

    protected void addTask(){
        TodoTask tTask = new TodoTask();
    }
}
