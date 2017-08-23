package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import fr.rennes.perso.todo.R;

public class TodoListActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 0;
    private Button btn_addNew_todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        btn_addNew_todoList = (Button) findViewById(R.id.btn_addNew_todoList);
        btn_addNew_todoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TodoListActivity.this, TodoAddActivity.class);
                TodoListActivity.this.startActivityForResult(intent, 1);
            }
        });
    }
}
