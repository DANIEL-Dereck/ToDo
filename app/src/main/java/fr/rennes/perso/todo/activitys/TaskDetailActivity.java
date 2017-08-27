package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.sqlite.TodoTaskRepo;

public class TaskDetailActivity extends AppCompatActivity {
    public final String LOGTAG = this.getClass().toString();
    private static final int MY_ACTIVITY_CODE = 4;
    private Button btn_back_taskDetail;
    private TextView tv_name_taskDetail;
    private TextView tv_desc_taskDetail;
    private TodoTaskRepo tTaskRepo;
    private TodoTask tTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        //TODO : put with id
        tTask = tTaskRepo.selectTaskById(0);

        tv_name_taskDetail.setText(tTask.getTask());
        tv_desc_taskDetail.setText(tTask.getDescription());

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
