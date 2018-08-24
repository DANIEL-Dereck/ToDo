package fr.rennes.perso.todo.database.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import fr.rennes.perso.todo.contrat.TodoTaskContrat;
import fr.rennes.perso.todo.model.TodoTask;
import fr.rennes.perso.todo.database.sqlite.DatabaseManager;
import fr.rennes.perso.todo.utils.ValuesUtils;

/**
 * Created by Dereck on 24/08/2017.
 */

public class OldTodoTaskRepo {
    private TodoTask todoTask;

    public OldTodoTaskRepo(){
        todoTask = new TodoTask();
    }

    public int insert(TodoTask todoTask){
        /*
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
        */
        return 0;
    }

    public void delete(){
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        db.delete(TodoTaskContrat.TABLE_NAME, null, null);
//        DatabaseManager.getInstance().closeDatabase();
    }

    public TodoTask selectTaskById(int idTask) {
//        TodoTask task = new TodoTask();
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        String query = "SELECT * FROM " + TodoTaskContrat.TABLE_NAME + " WHERE "
//                + TodoTaskContrat.COLUMN_ID + " = " + idTask + " ;";
//
//        Cursor cursor = db.rawQuery(query, null);
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                task = new TodoTask(
//                        cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_ID)),
//                        cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_TASK)),
//                        cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_DESC)),
//                        Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(TodoTask.COLUMN_TASK_STATE))),
//                        cursor.getInt(cursor.getColumnIndex(TodoTask.COLUMN_TASK_FK_LIST)));
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        DatabaseManager.getInstance().closeDatabase();
//        return task;
        return null;
    }

    public void UpdateStateTask(TodoTask task){
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        int state;
//        if (task.getState() == true)
//        {
//            state = ValuesUtils.TRUE;
//        } else {
//            state = ValuesUtils.FALSE;
//        }
//
//        String query = "UPDATE " + TodoTaskContrat.TABLE_NAME + " SET " + TodoTaskContrat.COLUMN_STATE
//                + "= " + state + " WHERE "
//                + TodoTaskContrat.COLUMN_ID + " = " + task.getId() + " ;";
//        try{
//            db.beginTransaction();
//            db.execSQL(query);
//            db.setTransactionSuccessful();
//
//        } catch (Exception e) {
//            e.getMessage();
//        }finally {
//            db.endTransaction();
//        }
//
//        DatabaseManager.getInstance().closeDatabase();
    }

    public void deleteTask(int taskId)
    {
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        String query = "DELETE FROM " + TodoTaskContrat.TABLE_NAME + " WHERE " + TodoTaskContrat.COLUMN_ID + " = " + taskId + ";";
//        db.execSQL(query);
//        DatabaseManager.getInstance().closeDatabase();
    }
}
