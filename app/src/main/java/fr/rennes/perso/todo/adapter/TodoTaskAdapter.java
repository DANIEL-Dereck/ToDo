package fr.rennes.perso.todo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutput;
import java.text.DateFormat;
import java.util.List;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.activitys.TaskDetailActivity;
import fr.rennes.perso.todo.activitys.TaskListActivity;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.sqlite.TodoTaskRepo;

/**
 * Created by Dereck on 22/08/2017.
 */

public class TodoTaskAdapter extends ArrayAdapter<TodoTask> {
    public final String LOGTAG = this.getClass().toString();
    private int pos;

    public TodoTaskAdapter(@NonNull Context context, @NonNull List<TodoTask> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final TodoTask todoTask = getItem(position);
        pos = position;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_list_item, parent, false);
        }

        TextView tv_taskList_item_name = (TextView) convertView.findViewById(R.id.tv_taskList_item_name);
        final CheckBox cb_taskList_item_cb = (CheckBox) convertView.findViewById(R.id.cb_taskList_item_cb);

        tv_taskList_item_name.setText(todoTask.getTask());
        cb_taskList_item_cb.setChecked(todoTask.getState());

        cb_taskList_item_cb.setTag(todoTask);
        cb_taskList_item_cb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TodoTaskRepo todoTaskRepo = new TodoTaskRepo();
                TodoTask tTask = (TodoTask)view.getTag();
                tTask.setState(cb_taskList_item_cb.isChecked());
                todoTaskRepo.UpdateStateTask(tTask);
            }
        });

        return convertView;
    }
}
