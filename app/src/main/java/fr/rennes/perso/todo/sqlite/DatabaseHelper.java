package fr.rennes.perso.todo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fr.rennes.perso.todo.model.TodoList;

/**
 * Created by Dereck on 24/08/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String LOGTAG = "DatabaseHelper";

    /* DB VALUES */
    private static final String DATABASE_NAME = "todolist.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        if (!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoListRepo.createTable());
        db.execSQL(TodoTaskRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(TodoListRepo.dropTable());
        db.execSQL(TodoTaskRepo.dropTable());
        onCreate(db);

    }
}
