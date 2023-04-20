package android.maxim.practiceretrofit1804.ui;

import android.maxim.practiceretrofit1804.di.AppComponent;
import android.maxim.practiceretrofit1804.di.DaggerAppComponent;
import android.maxim.practiceretrofit1804.model.Repository;
import androidx.lifecycle.ViewModel;
import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel {

    @Inject
    Repository repository;

    {
        AppComponent appComponent = DaggerAppComponent.builder().build();
        appComponent.injectViewModel(this);
    }

    void getDataFromRepository(int id) {
        repository.getDataFromNetwork(id);
    }
}
