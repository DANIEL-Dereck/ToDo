package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.adapter.TodoListAdapter;
import fr.rennes.perso.todo.model.TodoList;
import fr.rennes.perso.todo.sqlite.TodoListRepo;

public class TodoListActivity extends AppCompatActivity {
    /** Activity final values */
    public static final int MY_ACTIVITY_CODE = 0;
    public final String LOGTAG = this.getClass().toString();

    /** Activity component */
    private ListView lv_todo_todoList;
    private TodoListAdapter todoListAdapter;
    private Button btn_addNew_todoList;

    /** Activity values */
    private ArrayList<TodoList> todoArrayList = new ArrayList<>();
    private TodoListRepo todoListRepo = new TodoListRepo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOGTAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        /** component initialisation */
        btn_addNew_todoList = (Button) findViewById(R.id.btn_addNew_todoList);
        lv_todo_todoList = (ListView) findViewById(R.id.lv_todo_todoList);

        /** values initialisation */
        todoArrayList = (ArrayList)todoListRepo.selectList();
        todoListAdapter = new TodoListAdapter(this, todoArrayList);
        lv_todo_todoList.setAdapter(todoListAdapter);

        /** Event */
        lv_todo_todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TodoListActivity.this, TaskListActivity.class);
                TodoList tList = todoArrayList.get(position);
                intent.putExtra("todoListId", tList.getId());
                intent.putExtra("position", position);
                TodoListActivity.this.startActivityForResult(intent, TaskListActivity.MY_ACTIVITY_CODE);
            }
        });

        btn_addNew_todoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TodoListActivity.this, TodoAddActivity.class);
                TodoListActivity.this.startActivityForResult(intent, TodoAddActivity.MY_ACTIVITY_CODE);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(LOGTAG, "onActivityResult");
        if(resultCode == RESULT_OK){
            TodoListRepo todoListRepo = new TodoListRepo();
            todoArrayList = (ArrayList)todoListRepo.selectList();
            todoListAdapter = new TodoListAdapter(this, todoArrayList);
            todoListAdapter.notifyDataSetChanged();
            lv_todo_todoList.setAdapter(todoListAdapter);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
