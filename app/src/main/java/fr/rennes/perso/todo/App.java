package fr.rennes.perso.todo;

import android.app.Application;
import android.content.Context;

import fr.rennes.perso.todo.database.sqlite.DatabaseHelper;
import fr.rennes.perso.todo.database.sqlite.DatabaseManager;

public class App extends Application {
    private static Context context;
    private static DatabaseHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DatabaseHelper(context);
        DatabaseManager.initInstance(dbHelper);
    }

    public static Context getContext(){
        return context;
    }
}
