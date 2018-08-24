package fr.rennes.perso.todo.database.repository;

import fr.rennes.perso.todo.contrat.DatabaseContrat;
import fr.rennes.perso.todo.contrat.TodoTaskContrat;
import fr.rennes.perso.todo.model.TodoTask;

public class TodoTaskRepository extends RepositoryBase<TodoTask> {

    public TodoTaskRepository() {
        this.entity = new TodoTask();
    }

    public static String createTable() {
        String query = DatabaseContrat.CREATE_TABLE + TodoTaskContrat.TABLE_NAME + " ( "
                + TodoTaskContrat.COLUMN_ID + DatabaseContrat.PRIMARY_KEY
                + TodoTaskContrat.COLUMN_CREATED_AT + DatabaseContrat.COL_TYPE_DATE
                + TodoTaskContrat.COLUMN_UPDATED_AT + DatabaseContrat.COL_TYPE_DATE
                + TodoTaskContrat.COLUMN_NAME + DatabaseContrat.COL_TYPE_TEXT
                + TodoTaskContrat.COLUMN_DESCRIPTION + DatabaseContrat.COL_TYPE_TEXT
                + TodoTaskContrat.COLUMN_STATE + DatabaseContrat.COL_TYPE_TEXT
                + " ); ";
        return query;
    }

    public static String dropTable() {
        String query = DatabaseContrat.DROP_TABLE + TodoTaskContrat.TABLE_NAME
                + ";";

        return query;
    }
}
