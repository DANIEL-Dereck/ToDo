package fr.rennes.perso.todo.adapter;

import fr.rennes.perso.todo.model.TodoList;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Dereck on 22/08/2017.
 */

public class TodoListAdapter extends ArrayAdapter<TodoList> {
    public TodoListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<TodoList> objects) {
        super(context, resource, objects);
    }
}
