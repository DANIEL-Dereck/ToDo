package fr.rennes.perso.todo.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.sqlite.TodoTaskRepo;

/**
* On this activity we can add a new task
*/
public class TaskAddActivity extends AppCompatActivity {
    /** Activity final values */
    public static final int MY_ACTIVITY_CODE = 3; // Activity code
    public final String LOGTAG = this.getClass().toString(); // Log Value

    /** Activity component */
    private Button btn_add_taskAdd;
    private Button btn_back_taskAdd;
    private EditText et_name_taskAdd;
    private EditText et_desc_taskAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOGTAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_add);

        /** component initialisation */
        btn_back_taskAdd = (Button) findViewById(R.id.btn_back_taskAdd);
        btn_add_taskAdd = (Button) findViewById(R.id.btn_add_taskAdd);
        et_name_taskAdd = (EditText) findViewById(R.id.et_name_taskAdd);
        et_desc_taskAdd = (EditText) findViewById(R.id.et_desc_taskAdd);

        /** Event */

        /* On the click on this button back,
         we cancel all the modification and
         we return on the TaskListActivity*/
        btn_back_taskAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        /* On the click on this button,
         we add the task on the database and
         we return on the TaskListActivity*/
        btn_add_taskAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                int listId = extras.getInt("idList");
                TodoTaskRepo tTaskRepo = new TodoTaskRepo();
                TodoTask tTask = new TodoTask(
                        et_name_taskAdd.getText().toString(),
                        et_desc_taskAdd.getText().toString(),
                        false,
                        listId
                );
                tTaskRepo.insert(tTask);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
