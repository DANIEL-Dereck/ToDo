package fr.rennes.perso.todo.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fr.rennes.perso.todo.model.TodoTask;

/**
 * Created by Dereck on 24/08/2017.
 */

public class TodoTaskRepo {
    private final String LOGTAG = this.getClass().toString();
    private static final String LOG = "TodoTaskRepo";
    private TodoTask todoTask;

    public TodoTaskRepo(){
        todoTask = new TodoTask();
    }

    public static String createTable(){
        Log.d(LOG, "createTable");

        String query = "CREATE TABLE " + TodoTask.TABLE + " ("
                + TodoTask.COLUMN_TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TodoTask.COLUMN_TASK_TASK + " TEXT, "
                + TodoTask.COLUMN_TASK_DESC + " TEXT,"
                + TodoTask.COLUMN_TASK_STATE + " INTEGER,"
                + TodoTask.COLUMN_TASK_FK_LIST + " INTEGER ); ";
        return query;
    }

    public static String dropTable(){
        Log.d(LOG, "dropTable");
        String query = "DROP TABLE IF EXISTS " + TodoTask.TABLE +";";
        return query;
    }

    public int insert(TodoTask todoTask){
        Log.d(LOGTAG, "insert");
        int taskId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(todoTask.COLUMN_TASK_TASK , todoTask.getTask());
        values.put(todoTask.COLUMN_TASK_DESC , todoTask.getDescription());
        if (todoTask.getState() == true) {
            values.put(todoTask.COLUMN_TASK_STATE , todoTask.TRUE);
        } else {
            values.put(todoTask.COLUMN_TASK_STATE , todoTask.FALSE);
        }
        values.put(todoTask.COLUMN_TASK_FK_LIST , todoTask.getId_list());
        taskId = (int)db.insert(TodoTask.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return taskId;
    }

    public void delete(){
        Log.d(LOGTAG, "delete");
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TodoTask.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<TodoTask> selectTasks(int id_list) {
        Log.d(LOGTAG, "selectTasks");
        List<TodoTask> todoTasks = new ArrayList<>();
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String query = "SELECT * FROM " + TodoTask.TABLE + " WHERE "
                + TodoTask.COLUMN_TASK_FK_LIST + " = " + id_list + " ;";

        Cursor cursor = db.rawQuery(query, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                boolean state;
                if (cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_STATE)) == TodoTask.TRUE)
                {
                  state = true;
                } else {
                    state = false;
                }
                TodoTask task = new TodoTask(
                        cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_ID)),
                        cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_TASK)),
                        cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_DESC)),
                        state,
                        cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_FK_LIST)));
                todoTasks.add(task);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return todoTasks;
    }

    public TodoTask selectTaskById(int idTask) {
        Log.d(LOGTAG, "selectTaskById");
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

    public void UpdateStateTask(TodoTask task){
        Log.d(LOGTAG, "UpdateStateTask");
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        int state;
        if (task.getState() == true)
        {
            state = TodoTask.TRUE;
        } else {
            state = TodoTask.FALSE;
        }

        String query = "UPDATE " + TodoTask.TABLE + " SET " + TodoTask.COLUMN_TASK_STATE
                + "= " + state + " WHERE "
                + TodoTask.COLUMN_TASK_ID + " = " + task.getId() + " ;";
        try{
            db.beginTransaction();
            db.execSQL(query);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.e(LOGTAG, e.getMessage());
        }finally {
            db.endTransaction();
        }

        DatabaseManager.getInstance().closeDatabase();
    }

    public void deleteTask(int taskId)
    {
        Log.d(LOGTAG, "deleteTask");
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String query = "DELETE FROM " + TodoTask.TABLE + " WHERE " + TodoTask.COLUMN_TASK_ID + " = " + taskId + ";";
        db.execSQL(query);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void deleteTaskByListId(int listId)
    {
        Log.d(LOGTAG, "deleteTask");
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String query = "DELETE FROM " + TodoTask.TABLE + " WHERE " + TodoTask.COLUMN_TASK_FK_LIST + " = " + listId + ";";
        db.execSQL(query);
        DatabaseManager.getInstance().closeDatabase();
    }



}
