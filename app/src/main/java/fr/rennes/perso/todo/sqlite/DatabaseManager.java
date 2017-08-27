package fr.rennes.perso.todo.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dereck on 24/08/2017.
 */

public class DatabaseManager {
    private static final String LOGTAG = "DatabaseManager";

    private Integer mOpenCounter = 0;

    private  static DatabaseManager instance;
    private static SQLiteOpenHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;

    public static synchronized void initInstance(SQLiteOpenHelper helper){
        Log.d(LOGTAG, "initInstance()");
        if (instance == null)
        {
            instance = new DatabaseManager();
            mDatabaseHelper = helper;
        }
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
                    " is not initialized, call initInstance(..) method first.");
        }
        return instance;
    }

    public synchronized SQLiteDatabase openDatabase(){
        mOpenCounter += 1;
        if (mOpenCounter == 1) {
            mDatabase = mDatabaseHelper.getWritableDatabase();
        }
        return mDatabase;
    }

    public synchronized void closeDatabase(){
        mOpenCounter -= 1;
        if (mOpenCounter == 0){
            mDatabase.close();
        }
    }

}