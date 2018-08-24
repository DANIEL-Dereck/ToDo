package fr.rennes.perso.todo.database.repository;

import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fr.rennes.perso.todo.model.EntityBase;
import fr.rennes.perso.todo.database.sqlite.DatabaseManager;

public abstract class RepositoryBase<T extends EntityBase> {
    protected T entity;
    protected SQLiteDatabase db;
    protected DatabaseManager dbManager;

    protected String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

}
