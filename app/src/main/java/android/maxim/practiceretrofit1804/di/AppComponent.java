package android.maxim.practiceretrofit1804.di;

import android.maxim.practiceretrofit1804.model.Repository;
import android.maxim.practiceretrofit1804.ui.MainActivityViewModel;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void injectViewModel(MainActivityViewModel mainActivityViewModel);

    void injectRepository(Repository repository);
}
