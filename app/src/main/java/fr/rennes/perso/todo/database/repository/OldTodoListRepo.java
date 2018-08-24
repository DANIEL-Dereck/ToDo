package fr.rennes.perso.todo.database.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import fr.rennes.perso.todo.model.TodoList;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.database.sqlite.DatabaseManager;

/**
 * Created by Dereck on 24/08/2017.
 */

public class OldTodoListRepo {

    private TodoList todoList;
    
    public OldTodoListRepo(){
        todoList = new TodoList();
    }

    public int insert(TodoList todoList){
        /*
        int listId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
//        values.put(todoList.COLUMN_LIST_ID, todoList.getId());
        values.put(todoList.COLUMN_LIST_NAME, todoList.getName());
        values.put(todoList.COLUMN_LIST_CDATE, getDateTime());

        listId = (int)db.insert(TodoList.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return listId;
        */
        return 0;
    }

    public List<TodoList> selectList() {
        /*
        TodoList todo = new TodoList();
        List<TodoList> todoLists = new ArrayList<TodoList>();
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String query = "SELECT * FROM " + TodoList.TABLE + ";";

        Cursor cursor = db.rawQuery(query, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    todo = new TodoList(
                            cursor.getInt(cursor.getColumnIndex(TodoList.COLUMN_LIST_ID)),
                            cursor.getString(cursor.getColumnIndex(TodoList.COLUMN_LIST_NAME)),
                            format.parse(cursor.getString(cursor.getColumnIndex(TodoList.COLUMN_LIST_CDATE)))
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                todoLists.add(todo);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return todoLists;
        */
        return null;
    }

    public void delete(){
        /*
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TodoList.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
        */
    }

    public void deleteList(TodoList todoList){
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        OldTodoTaskRepo repoTask = new OldTodoTaskRepo();
//        ArrayList<TodoTask> taskLists = new ArrayList<>();
//        taskLists = (ArrayList) repoTask.selectTasks(todoList.getId());
//
//        for (TodoTask task : taskLists)
//        {
//            repoTask.deleteTask(task.getId());
//        }
//
//        String query = "DELETE FROM " + TodoList.TABLE + " WHERE " + TodoList.COLUMN_LIST_ID + " = " + todoList.getId() + ";";
//        db.execSQL(query);
//
//        DatabaseManager.getInstance().closeDatabase();
    }

    public void deleteListById(int listId){
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        OldTodoTaskRepo repoTask = new OldTodoTaskRepo();
//        ArrayList<TodoTask> taskLists = new ArrayList<>();
//        taskLists = (ArrayList) repoTask.selectTasks(todoList.getId());
//
//        for (TodoTask task : taskLists)
//        {
//            repoTask.deleteTask(task.getId());
//        }
//
//        String query = "DELETE FROM " + TodoList.TABLE + " WHERE " + TodoList.COLUMN_LIST_ID + " = " + listId + ";";
//        db.execSQL(query);
//
//        DatabaseManager.getInstance().closeDatabase();
    }

}
