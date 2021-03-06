package fr.rennes.perso.todo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dereck on 24/08/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String LOGTAG = this.getClass().toString();

    /* DB VALUES */
    private static final String DATABASE_NAME = "todolist.db";
    private static final int DATABASE_VERSION = 6;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        Log.d(LOGTAG, "Open DB");
        super.onOpen(db);
        if (!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOGTAG, "onCreate");
        db.execSQL(TodoListRepo.createTable());
        db.execSQL(TodoTaskRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d(LOGTAG, "onUpgrade");
        db.execSQL(TodoListRepo.dropTable());
        db.execSQL(TodoTaskRepo.dropTable());
        onCreate(db);
    }
}
