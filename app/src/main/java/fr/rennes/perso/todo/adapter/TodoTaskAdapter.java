package fr.rennes.perso.todo.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

import fr.rennes.perso.todo.model.TodoTask;

/**
 * Created by Dereck on 22/08/2017.
 */

public class TodoTaskAdapter extends ArrayAdapter<TodoTask> {
    public TodoTaskAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<TodoTask> objects) {
        super(context, resource, objects);
    }
}
