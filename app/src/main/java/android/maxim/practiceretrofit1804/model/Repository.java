package android.maxim.practiceretrofit1804.model;

import android.maxim.practiceretrofit1804.di.AppComponent;
import android.maxim.practiceretrofit1804.di.DaggerAppComponent;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    @Inject
    public Repository(UserAPI userAPI) {
        this.userAPI = userAPI;
    }
    @Inject
    public MutableLiveData<UserResponse> userResponseMutableLiveData;
    private final UserAPI userAPI;

    {
        AppComponent appComponent = DaggerAppComponent.builder().build();
        appComponent.injectRepository(this);
    }

    public void getDataFromNetwork(int id) {
        Call<UserResponse> call = userAPI.getUsedData(id);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(
                    @NonNull Call<UserResponse> call,
                    @NonNull Response<UserResponse> response) {
                if(response.code() == 200) {
                    UserResponse userResponse = response.body();
                    userResponseMutableLiveData.setValue(userResponse);
                } else {
                    userResponseMutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(
                    @NonNull Call<UserResponse> call,
                    @NonNull Throwable t) {
                userResponseMutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<UserResponse> getLiveData() {
        return userResponseMutableLiveData;
    }
}
