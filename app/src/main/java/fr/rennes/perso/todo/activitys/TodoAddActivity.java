package fr.rennes.perso.todo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.model.TodoList;
import fr.rennes.perso.todo.sqlite.TodoListRepo;

public class TodoAddActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 1;
    public final String LOGTAG = this.getClass().toString();
    private Button btn_add_todoAdd;
    private Button btn_back_todoAdd;
    private EditText et_name_todoAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_add);

        et_name_todoAdd = (EditText) findViewById(R.id.et_name_todoAdd);

        btn_back_todoAdd = (Button) findViewById(R.id.btn_back_todoAdd);
        btn_back_todoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btn_add_todoAdd = (Button) findViewById(R.id.btn_add_todoAdd);
        btn_add_todoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                TodoListRepo tListRepo = new TodoListRepo();
                TodoList tList = new TodoList(et_name_todoAdd.getText().toString());
                tListRepo.insert(tList);

                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
