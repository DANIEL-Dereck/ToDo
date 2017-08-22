package fr.rennes.perso.todo.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.rennes.perso.todo.R;

public class TodoAddActivity extends AppCompatActivity {
    private static final int MY_ACTIVITY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_add);
    }
}
