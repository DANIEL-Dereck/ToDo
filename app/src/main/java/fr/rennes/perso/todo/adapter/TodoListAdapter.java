package fr.rennes.perso.todo.adapter;

import fr.rennes.perso.todo.R;
import fr.rennes.perso.todo.model.TodoList;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by Dereck on 22/08/2017.
 */

public class TodoListAdapter extends ArrayAdapter<TodoList> {
    public TodoListAdapter(@NonNull Context context, @NonNull List<TodoList> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TodoList todoList = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todo_list_item, parent, false);

        }

        TextView tv_todoList_item_name = (TextView) convertView.findViewById(R.id.tv_todoList_item_name);
        TextView tv_todoList_item_cDate = (TextView) convertView.findViewById(R.id.tv_todoList_item_cDate);

        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(this.getContext());
        String dateFormated = dateFormat.format(todoList.getCreationDate());


        tv_todoList_item_cDate.setText(dateFormated);
        tv_todoList_item_name.setText(todoList.getName());

        return convertView;
    }
}
