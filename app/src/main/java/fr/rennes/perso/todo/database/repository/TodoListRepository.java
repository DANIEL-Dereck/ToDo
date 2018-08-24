package fr.rennes.perso.todo.database.repository;

import fr.rennes.perso.todo.contrat.DatabaseContrat;
import fr.rennes.perso.todo.contrat.TodoListContrat;
import fr.rennes.perso.todo.model.TodoList;

public class TodoListRepository extends RepositoryBase<TodoList> {

    public TodoListRepository() {
        this.entity = new TodoList();
    }

    public static String createTable() {
        String query = DatabaseContrat.CREATE_TABLE + TodoListContrat.TABLE_NAME + " ( "
                + TodoListContrat.COLUMN_ID + DatabaseContrat.PRIMARY_KEY
                + TodoListContrat.COLUMN_CREATED_AT + DatabaseContrat.COL_TYPE_DATE
                + TodoListContrat.COLUMN_UPDATED_AT + DatabaseContrat.COL_TYPE_DATE
                + TodoListContrat.COLUMN_NAME + DatabaseContrat.COL_TYPE_TEXT
                + " ); ";

        return query;
    }

    public static String dropTable() {
        String query = DatabaseContrat.DROP_TABLE + TodoListContrat.TABLE_NAME
                + ";";

        return query;
    }
}
