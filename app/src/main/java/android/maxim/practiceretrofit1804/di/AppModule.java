package android.maxim.practiceretrofit1804.di;

import android.maxim.practiceretrofit1804.model.UserAPI;
import android.maxim.practiceretrofit1804.model.UserResponse;
import androidx.lifecycle.MutableLiveData;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    String BASE_URL = "https://dummyjson.com/";

    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public UserAPI provideUserAPI(Retrofit retrofit) {
        return retrofit.create(UserAPI.class);
    }

    @Provides
    public MutableLiveData<UserResponse> provideMutableLiveData() {
        return new MutableLiveData<>();
    }
}
