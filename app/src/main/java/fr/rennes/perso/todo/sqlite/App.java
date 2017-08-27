package fr.rennes.perso.todo.sqlite;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Dereck on 25/08/2017.
 */

public class App extends Application {
    private static final String LOGTAG = "Application";
    private static Context context;
    private static DatabaseHelper dbHelper;

    @Override
    public void onCreate() {
        Log.d(LOGTAG, "onCreate()");
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DatabaseHelper(context);
        DatabaseManager.initInstance(dbHelper);
    }

    public static Context getContext(){
        return context;
    }
}
