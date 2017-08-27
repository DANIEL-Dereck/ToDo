package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.adapter.TodoListAdapter;
import fr.rennes.perso.todo.adapter.TodoTaskAdapter;
import fr.rennes.perso.todo.model.TodoList;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.sqlite.TodoTaskRepo;

public class TaskListActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 2;
    public final String LOGTAG = this.getClass().toString();
    private ArrayList<TodoTask> taskArrayList = new ArrayList<>();
    private TodoTaskRepo todoTaskRepo = new TodoTaskRepo();
    private TodoTaskAdapter todoTaskAdapter;

    private ListView lv_task_taskList;
    private Button btn_addNew_taskList;
    private Button btn_back_taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        Bundle extras = getIntent().getExtras();
        int idList = extras.getInt("todoListId");

        btn_back_taskList = (Button) findViewById(R.id.btn_back_taskList);
        btn_addNew_taskList = (Button) findViewById(R.id.btn_addNew_taskList);

        lv_task_taskList = (ListView) findViewById(R.id.lv_task_taskList);

        taskArrayList = (ArrayList)todoTaskRepo.selectTasks(idList);
        todoTaskAdapter = new TodoTaskAdapter(this, taskArrayList);
        lv_task_taskList.setAdapter(todoTaskAdapter);


        lv_task_taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(TaskListActivity.this, TaskDetailActivity.class);
                TodoTask tTask = taskArrayList.get(position);
                intent.putExtra("todoTaskId", tTask.getId());
                intent.putExtra("position", position);
                TaskListActivity.this.startActivityForResult(intent, 4);
            }
        });

        btn_addNew_taskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TaskListActivity.this, TaskAddActivity.class);
                Bundle extras = getIntent().getExtras();
                int idList = extras.getInt("todoListId");
                intent.putExtra("idList", idList);
                TaskListActivity.this.startActivityForResult(intent, 3);
            }
        });

        btn_back_taskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            taskArrayList = (ArrayList)todoTaskRepo.selectTaskById();
            todoTaskAdapter = new TodoTaskAdapter(this, taskArrayList);
            todoTaskAdapter.notifyDataSetChanged();
        }
    }

}
