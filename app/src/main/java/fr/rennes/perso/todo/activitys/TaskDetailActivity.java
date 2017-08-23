package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.rennes.perso.todo.R;

public class TaskDetailActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 4;
    private Button btn_back_taskDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);


        btn_back_taskDetail = (Button) findViewById(R.id.btn_back_taskDetail);
        btn_back_taskDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TaskDetailActivity.this, TodoListActivity.class);
                TaskDetailActivity.this.startActivityForResult(intent, 1);
            }
        });
    }
}
