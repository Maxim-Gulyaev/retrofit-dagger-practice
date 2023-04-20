package android.maxim.practiceretrofit1804.di;

import android.maxim.practiceretrofit1804.model.Repository;
import android.maxim.practiceretrofit1804.ui.MainActivity;
import android.maxim.practiceretrofit1804.ui.MainActivityViewModel;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    void injectActivity(MainActivity mainActivity);

    void injectViewModel(MainActivityViewModel mainActivityViewModel);

    void injectRepository(Repository repository);
}
