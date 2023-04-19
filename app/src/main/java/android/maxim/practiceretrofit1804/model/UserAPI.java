package android.maxim.practiceretrofit1804.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserAPI {

    @GET("user/{id}")
    Call<UserResponse> getUsedData(@Path("id") int id);
}
