package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.rennes.perso.todo.R;

public class TodoAddActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 1;
    private Button btn_add_todoAdd;
    private Button btn_back_todoAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_add);


        btn_back_todoAdd = (Button) findViewById(R.id.btn_back_todoAdd);
        btn_back_todoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TodoAddActivity.this, TodoListActivity.class);
                TodoAddActivity.this.startActivityForResult(intent, 1);
            }
        });

        btn_add_todoAdd = (Button) findViewById(R.id.btn_add_todoAdd);
        btn_add_todoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                /* todo/ ADD TODO IN DATABASE */
            }
        });
    }
}
