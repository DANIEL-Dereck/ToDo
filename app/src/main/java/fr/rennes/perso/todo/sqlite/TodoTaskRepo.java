package fr.rennes.perso.todo.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import fr.rennes.perso.todo.model.TodoTask;

/**
 * Created by Dereck on 24/08/2017.
 */

public class TodoTaskRepo {

    private TodoTask todoTask;

    public TodoTaskRepo(){
        todoTask = new TodoTask();
    }

    public static String createTable(){
        String query = "CREATE TABLE " + TodoTask.TABLE + " ("
                + TodoTask.COLUMN_TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TodoTask.COLUMN_TASK_TASK + " TEXT, "
                + TodoTask.COLUMN_TASK_DESC + " TEXT,"
                + TodoTask.COLUMN_TASK_STATE + " TEXT,"
                + TodoTask.COLUMN_TASK_FK_LIST+ " INTEGER;";
        return query;
    }

    public static String dropTable(){
        String query = "DROP TABLE IF EXISTS" + TodoTask.TABLE +";";

        return query;
    }

    public int insert(TodoTask todoTask){
        int taskId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(TodoTask.COLUMN_TASK_ID , todoTask.getId());
        values.put(TodoTask.COLUMN_TASK_TASK , todoTask.getTask());
        values.put(TodoTask.COLUMN_TASK_DESC , todoTask.getDescription());
        values.put(TodoTask.COLUMN_TASK_STATE , todoTask.getState());
        values.put(TodoTask.COLUMN_TASK_FK_LIST , todoTask.getId_list());

        taskId = (int)db.insert(TodoTask.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return taskId;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TodoTask.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
