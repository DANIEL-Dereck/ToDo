package fr.rennes.perso.todo.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.rennes.perso.todo.contrat.DatabaseContrat;
import fr.rennes.perso.todo.database.repository.OldTodoListRepo;
import fr.rennes.perso.todo.database.repository.OldTodoTaskRepo;
import fr.rennes.perso.todo.database.repository.TodoListRepository;
import fr.rennes.perso.todo.database.repository.TodoTaskRepository;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, DatabaseContrat.DATABASE_NAME, null, DatabaseContrat.DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        if (!db.isReadOnly()){
            db.execSQL(DatabaseContrat.DATABASE_PRAGMA);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoListRepository.createTable());
        db.execSQL(TodoTaskRepository.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(TodoListRepository.dropTable());
        db.execSQL(TodoTaskRepository.dropTable());
        onCreate(db);
    }
}
