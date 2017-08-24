package fr.rennes.perso.todo.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fr.rennes.perso.todo.model.TodoList;

/**
 * Created by Dereck on 24/08/2017.
 */

public class TodoListRepo {
    private TodoList todoList;
    
    public TodoListRepo(){
        todoList = new TodoList();
    }

    public static String createTable(){
        String query = "CREATE TABLE " + TodoList.TABLE + " ("
                + TodoList.COLUMN_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TodoList.COLUMN_LIST_NAME + " TEXT , "
                + TodoList.COLUMN_LIST_CDATE + " DATETIME;";
        return query;
    }

    public static String dropTable(){
        String query = "DROP TABLE IF EXISTS" + TodoList.TABLE +";";

        return query;
    }

    public int insert(TodoList todoList){
        int listId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(TodoList.COLUMN_LIST_ID, todoList.getId());
        values.put(TodoList.COLUMN_LIST_NAME, todoList.getName());
        values.put(TodoList.COLUMN_LIST_CDATE, getDateTime());

        listId = (int)db.insert(TodoList.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return listId;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TodoList.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
