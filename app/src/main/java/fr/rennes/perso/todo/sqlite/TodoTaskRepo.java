package fr.rennes.perso.todo.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.rennes.perso.todo.model.TodoList;
import fr.rennes.perso.todo.model.TodoTask;

/**
 * Created by Dereck on 24/08/2017.
 */

public class TodoTaskRepo {
    private static final String LOGTAG = "TodoTaskRepo";
    private TodoTask todoTask;

    public TodoTaskRepo(){
        todoTask = new TodoTask();
    }

    public static String createTable(){
        Log.d(LOGTAG, "createTable()");

        String query = "CREATE TABLE " + TodoTask.TABLE + " ("
                + TodoTask.COLUMN_TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TodoTask.COLUMN_TASK_TASK + " TEXT, "
                + TodoTask.COLUMN_TASK_DESC + " TEXT,"
                + TodoTask.COLUMN_TASK_STATE + " TEXT,"
                + TodoTask.COLUMN_TASK_FK_LIST + "INTEGER); ";
/*
        String query = "CREATE TABLE " + TodoTask.TABLE + " ("
                + TodoTask.COLUMN_TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TodoTask.COLUMN_TASK_TASK + " TEXT, "
                + TodoTask.COLUMN_TASK_DESC + " TEXT,"
                + TodoTask.COLUMN_TASK_STATE + " TEXT,"
                + "FOREIGN KEY(" + TodoTask.COLUMN_TASK_FK_LIST + ") REFERENCES "
                + TodoList.TABLE + "(" + TodoList.COLUMN_LIST_ID +"));";
*/
        return query;
    }

    public static String dropTable(){
        Log.d(LOGTAG, "dropTable()");
        String query = "DROP TABLE IF EXISTS " + TodoTask.TABLE +";";
        return query;
    }

    public int insert(TodoTask todoTask){
        Log.d(LOGTAG, "insert()");
        int taskId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
//        values.put(todoTask.COLUMN_TASK_ID , todoTask.getId());
        values.put(todoTask.COLUMN_TASK_TASK , todoTask.getTask());
        values.put(todoTask.COLUMN_TASK_DESC , todoTask.getDescription());
        values.put(todoTask.COLUMN_TASK_STATE , todoTask.getState());
        values.put(todoTask.COLUMN_TASK_FK_LIST , todoTask.getId_list());

        taskId = (int)db.insert(TodoTask.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return taskId;
    }

    public void delete(){
        Log.d(LOGTAG, "delete()");
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TodoTask.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<TodoTask> selectTasks(int id_list) {
        List<TodoTask> todoTasks = new ArrayList<>();
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String query = "SELECT * FROM " + TodoTask.TABLE + " WHERE "
                + TodoTask.COLUMN_TASK_FK_LIST + " = " + id_list + " ;";

        Cursor cursor = db.rawQuery(query, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TodoTask task = new TodoTask(
                        cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_ID)),
                        cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_TASK)),
                        cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_DESC)),
                        Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_STATE))),
                        cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_FK_LIST)));
                todoTasks.add(task);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return todoTasks;
    }

    public TodoTask selectTaskById(int idTask) {
        TodoTask task = new TodoTask();
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String query = "SELECT * FROM " + TodoTask.TABLE + " WHERE "
                + TodoTask.COLUMN_TASK_ID + " = " + idTask + " ;";

        Cursor cursor = db.rawQuery(query, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                task = new TodoTask(
                        cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_ID)),
                        cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_TASK)),
                        cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_DESC)),
                        Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_STATE))),
                        cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_FK_LIST)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return task;
    }

}
