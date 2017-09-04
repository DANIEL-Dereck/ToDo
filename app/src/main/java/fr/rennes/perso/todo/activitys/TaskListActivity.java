package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.adapter.TodoTaskAdapter;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.sqlite.TodoListRepo;
import fr.rennes.perso.todo.sqlite.TodoTaskRepo;

public class TaskListActivity extends AppCompatActivity {
    /** Activity final values */
    public static final int MY_ACTIVITY_CODE = 2;
    public final String LOGTAG = this.getClass().toString();

    /** Activity component */
    private CheckBox cb_taskList_item_cb;
    private ListView lv_task_taskList;
    private Button btn_addNew_taskList;
    private Button btn_back_taskList;
    private Button btn_del_taskList;

    /** Activity values */
    private ArrayList<TodoTask> taskArrayList = new ArrayList<>();
    private TodoTaskRepo todoTaskRepo = new TodoTaskRepo();
    private TodoTaskAdapter todoTaskAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOGTAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        Bundle extras = getIntent().getExtras();
        int idList = extras.getInt("todoListId");

        btn_back_taskList = (Button) findViewById(R.id.btn_back_taskList);
        btn_addNew_taskList = (Button) findViewById(R.id.btn_addNew_taskList);
        btn_del_taskList = (Button) findViewById(R.id.btn_del_taskList);
        lv_task_taskList = (ListView) findViewById(R.id.lv_task_taskList);
        cb_taskList_item_cb = (CheckBox) findViewById(R.id.cb_taskList_item_cb);

        taskArrayList = (ArrayList)todoTaskRepo.selectTasks(idList);
        todoTaskAdapter = new TodoTaskAdapter(this, taskArrayList);
        todoTaskAdapter.notifyDataSetChanged();
        lv_task_taskList.setAdapter(todoTaskAdapter);

        btn_del_taskList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                int idList = extras.getInt("todoListId");
                TodoListRepo todoListRepo = new TodoListRepo();
                todoListRepo.deleteListById(idList);
                setResult(RESULT_OK);
                finish();
            }
        });


        lv_task_taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(TaskListActivity.this, TaskDetailActivity.class);
                TodoTask tTask = taskArrayList.get(position);
                intent.putExtra("todoTaskId", tTask.getId());
                intent.putExtra("position", position);
                TaskListActivity.this.startActivityForResult(intent, TaskDetailActivity.MY_ACTIVITY_CODE);
            }
        });

        btn_addNew_taskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TaskListActivity.this, TaskAddActivity.class);
                Bundle extras = getIntent().getExtras();
                int idList = extras.getInt("todoListId");
                intent.putExtra("idList", idList);
                TaskListActivity.this.startActivityForResult(intent, TaskAddActivity.MY_ACTIVITY_CODE);
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
        Log.d(LOGTAG, "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = getIntent().getExtras();
            int idList = extras.getInt("todoListId");

            TodoTaskRepo todoTaskRepo = new TodoTaskRepo();
            taskArrayList = (ArrayList)todoTaskRepo.selectTasks(idList);
            todoTaskAdapter = new TodoTaskAdapter(this, taskArrayList);
            todoTaskAdapter.notifyDataSetChanged();
            lv_task_taskList.setAdapter(todoTaskAdapter);
        }
    }

}
