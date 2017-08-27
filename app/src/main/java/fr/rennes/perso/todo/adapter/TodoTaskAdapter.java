package fr.rennes.perso.todo.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.model.TodoTask;

/**
 * Created by Dereck on 22/08/2017.
 */

public class TodoTaskAdapter extends ArrayAdapter<TodoTask> {
    public final String LOGTAG = this.getClass().toString();

    public TodoTaskAdapter(@NonNull Context context, @NonNull List<TodoTask> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TodoTask todoTask = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_list_item, parent, false);
        }

        TextView tv_taskList_item_name = (TextView) convertView.findViewById(R.id.tv_taskList_item_name);
        CheckBox cb_taskList_item_cb = (CheckBox) convertView.findViewById(R.id.cb_taskList_item_cb);

        tv_taskList_item_name.setText(todoTask.getTask());
        cb_taskList_item_cb.setChecked(todoTask.getState());

        return convertView;
    }
}
