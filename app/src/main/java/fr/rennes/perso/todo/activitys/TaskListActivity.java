package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.rennes.perso.todo.R;

public class TaskListActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 2;
    private Button btn_back_taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);


        btn_back_taskList = (Button) findViewById(R.id.btn_back_taskList);
        btn_back_taskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TaskListActivity.this, TodoListActivity.class);
                TaskListActivity.this.startActivityForResult(intent, 1);
            }
        });
    }
}
