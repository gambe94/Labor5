package hu.bme.aut.amorg.examples.todo.application;

import android.app.Application;

import hu.bme.aut.amorg.examples.todo.db.TodoDbLoader;

public class TodoApplication extends Application {
    private static TodoDbLoader dbLoader;

    public static TodoDbLoader getTodoDbLoader() {
        return dbLoader;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dbLoader = new TodoDbLoader(this);
        dbLoader.open();
    }

    @Override
    public void onTerminate() {
        dbLoader.close();
        super.onTerminate();
    }
}