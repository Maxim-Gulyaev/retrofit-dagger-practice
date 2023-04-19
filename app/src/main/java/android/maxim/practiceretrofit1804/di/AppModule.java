package android.maxim.practiceretrofit1804.di;

import android.maxim.practiceretrofit1804.model.UserAPI;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    String BASE_URL = "https://dummyjson.com/";

    @Provides
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public UserAPI userAPI(Retrofit retrofit) {
        return retrofit.create(UserAPI.class);
    }
}
