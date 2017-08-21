package fr.rennes.perso.todo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dereck on 21/08/2017.
 */

public class MySQLite extends SQLiteOpenHelper {
    /* ID */
    public static final String COLUMN_ID = "_id";

    /* LIST TABLE */
    public static final String TABLE_LIST = "lists";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CREATION = "creation";
    public static final String COLUMN_FK_TASK_ID = "_idTask";

    /* TASK TABLE */
    public static final String TABLE_TASK = "tasks";
    public static final String COLUMN_TASK = "task";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_STATE = "state";

    /* DB VALUES */
    private static final String DATABASE_NAME = "todolist.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_BDD_LIST = "CREATE TABLE " + TABLE_LIST + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_CREATION + ", FOREIGN KEY ("
            + COLUMN_FK_TASK_ID + ") REFERENCES"
            + TABLE_TASK + "(_ID));";

    private static final String CREATE_BDD_TASK = "CREATE TABLE " + TABLE_TASK + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TASK + " TEXT NOT NULL"
            + COLUMN_DESC + ","
            + COLUMN_STATE + ");";

    public MySQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD_LIST);
        db.execSQL(CREATE_BDD_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_LIST + ";");
        db.execSQL("DROP TABLE " + TABLE_TASK + ";");
        onCreate(db);
    }
}
