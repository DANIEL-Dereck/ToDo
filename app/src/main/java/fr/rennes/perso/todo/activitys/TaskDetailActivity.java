package fr.rennes.perso.todo.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.sqlite.TodoTaskRepo;

/**
* On this activity we list all the task
*/
public class TaskDetailActivity extends AppCompatActivity {
    /** Activity final values */
    public static final int MY_ACTIVITY_CODE = 4;
    public final String LOGTAG = this.getClass().toString();

    /** Activity component */
    private Button btn_back_taskDetail;
    private Button btn_del_taskDetail;
    private TextView tv_name_taskDetail;
    private TextView tv_desc_taskDetail;

    /** Activity values */
    private TodoTaskRepo tTaskRepo = new TodoTaskRepo();
    private TodoTask tTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOGTAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        /** Get todoTaskId on database */
        Bundle extras = getIntent().getExtras();
        int taskId = extras.getInt("todoTaskId");
        tTask = tTaskRepo.selectTaskById(taskId);

        /** component initialisation */
        btn_del_taskDetail = (Button) findViewById(R.id.btn_del_taskDetail);
        btn_back_taskDetail = (Button) findViewById(R.id.btn_back_taskDetail);
        tv_name_taskDetail = (TextView) findViewById(R.id.tv_name_taskDetail);
        tv_desc_taskDetail = (TextView) findViewById(R.id.tv_desc_taskDetail);

        /** get detail */
        tv_name_taskDetail.setText(tTask.getTask());
        tv_desc_taskDetail.setText(tTask.getDescription());

        /** Event */
        btn_del_taskDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                int taskId = extras.getInt("todoTaskId");
                TodoTaskRepo todoTaskRepo = new TodoTaskRepo();
                todoTaskRepo.deleteTask(taskId);
                setResult(RESULT_OK);
                finish();
            }
        });

        btn_back_taskDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
