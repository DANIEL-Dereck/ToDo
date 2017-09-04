package fr.rennes.perso.todo.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import fr.rennes.perso.todo.model.TodoList;
import fr.rennes.perso.todo.model.TodoTask;

/**
 * Created by Dereck on 24/08/2017.
 */

public class TodoListRepo {
    private final String LOGTAG = this.getClass().toString();
    private static final String LOG = "TodoListRepo";

    private TodoList todoList;
    
    public TodoListRepo(){
        todoList = new TodoList();
    }

    public static String createTable(){
        Log.d(LOG, "createTable");
        String query = "CREATE TABLE " + TodoList.TABLE + " ("
                + TodoList.COLUMN_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + TodoList.COLUMN_LIST_NAME + " TEXT , "
                + TodoList.COLUMN_LIST_CDATE + " DATETIME );";
        return query;
    }

    public static String dropTable(){
        Log.d(LOG, "dropTable");
        String query = "DROP TABLE IF EXISTS " + TodoList.TABLE +";";
        return query;
    }

    public int insert(TodoList todoList){
        Log.d(LOGTAG, "insert");
        int listId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
//        values.put(todoList.COLUMN_LIST_ID, todoList.getId());
        values.put(todoList.COLUMN_LIST_NAME, todoList.getName());
        values.put(todoList.COLUMN_LIST_CDATE, getDateTime());

        listId = (int)db.insert(TodoList.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return listId;
    }

    public List<TodoList> selectList() {
        Log.d(LOGTAG, "selectList");
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
    }

    public void delete(){
        Log.d(LOGTAG, "delete");
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TodoList.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    private String getDateTime() {
        Log.d(LOGTAG, "getDateTime");
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void deleteList(TodoList todoList){
        Log.d(LOGTAG, "deleteList");
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        TodoTaskRepo repoTask = new TodoTaskRepo();
        ArrayList<TodoTask> taskLists = new ArrayList<>();
        taskLists = (ArrayList) repoTask.selectTasks(todoList.getId());

        for (TodoTask task : taskLists)
        {
            repoTask.deleteTask(task.getId());
        }

        String query = "DELETE FROM " + TodoList.TABLE + " WHERE " + TodoList.COLUMN_LIST_ID + " = " + todoList.getId() + ";";
        db.execSQL(query);

        DatabaseManager.getInstance().closeDatabase();
    }

    public void deleteListById(int listId){
        Log.d(LOGTAG, "deleteList");
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        TodoTaskRepo repoTask = new TodoTaskRepo();
        ArrayList<TodoTask> taskLists = new ArrayList<>();
        taskLists = (ArrayList) repoTask.selectTasks(todoList.getId());

        for (TodoTask task : taskLists)
        {
            repoTask.deleteTask(task.getId());
        }

        String query = "DELETE FROM " + TodoList.TABLE + " WHERE " + TodoList.COLUMN_LIST_ID + " = " + listId + ";";
        db.execSQL(query);

        DatabaseManager.getInstance().closeDatabase();
    }
}
