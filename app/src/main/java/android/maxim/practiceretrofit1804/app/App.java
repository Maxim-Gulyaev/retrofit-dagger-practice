package android.maxim.practiceretrofit1804.app;

import android.app.Application;
import android.maxim.practiceretrofit1804.di.AppComponent;
import android.maxim.practiceretrofit1804.di.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().build();
    }
}
