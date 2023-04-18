package android.maxim.practiceretrofit1804.di;

import android.maxim.practiceretrofit1804.ui.MainActivity;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    void injectActivity(MainActivity mainActivity);
}
