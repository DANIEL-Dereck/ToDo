package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.sqlite.TodoListRepo;
import fr.rennes.perso.todo.sqlite.TodoTaskRepo;

public class TaskAddActivity extends AppCompatActivity {
    public final String LOGTAG = this.getClass().toString();
    private static final int MY_ACTIVITY_CODE = 3;
    private Button btn_add_taskAdd;
    private Button btn_back_taskAdd;

    private EditText et_name_taskAdd;
    private EditText et_desc_taskAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_add);

        btn_back_taskAdd = (Button) findViewById(R.id.btn_back_taskAdd);
        btn_add_taskAdd = (Button) findViewById(R.id.btn_add_taskAdd);

        et_name_taskAdd = (EditText) findViewById(R.id.et_name_taskAdd);
        et_desc_taskAdd = (EditText) findViewById(R.id.et_desc_taskAdd);

        btn_back_taskAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setResult(RESULT_CANCELED);
                finish();
            }
        });

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
