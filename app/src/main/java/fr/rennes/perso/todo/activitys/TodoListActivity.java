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
import fr.rennes.perso.todo.model.TodoList;

public class TodoListActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 0;
    private ArrayList<TodoList> todoArrayList = new ArrayList<>();
    private ListView lv_todo_todoList;
    private TodoListAdapter todoListAdapter;
    private Button btn_addNew_todoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        btn_addNew_todoList = (Button) findViewById(R.id.btn_addNew_todoList);
        lv_todo_todoList = (ListView) findViewById(R.id.lv_todo_todoList);

        todoListAdapter = new TodoListAdapter(this, todoArrayList);
        lv_todo_todoList.setAdapter(todoListAdapter);

        lv_todo_todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TodoListActivity.this, TaskListActivity.class);
                TodoListActivity.this.startActivityForResult(intent, 2);
            }
        });


        btn_addNew_todoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TodoListActivity.this, TodoAddActivity.class);
                TodoListActivity.this.startActivityForResult(intent, 1);
            }
        });
    }
}
