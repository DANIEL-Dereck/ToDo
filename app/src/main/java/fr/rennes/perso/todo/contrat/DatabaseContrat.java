package fr.rennes.perso.todo.contrat;

public class DatabaseContrat {
    public static final String DATABASE_NAME = "todolist.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_PRAGMA = "PRAGMA foreign_keys=ON;";

    public static final String CREATE_TABLE = "CREATE TABLE ";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS ";

    public static final String PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT, ";
    public static final String COL_TYPE_TEXT = " TEXT, ";
    public static final String COL_TYPE_INTEGER = " INTEGER, ";
    public static final String COL_TYPE_DATE =  " DATETIME, ";
    public static final String COL_TYPE_REAL = " REAL, ";
    public static final String COL_TYPE_BLOB = " BLOB, ";
    public static final String COL_TYPE_NUMERIC = " NUMERIC, ";

}
