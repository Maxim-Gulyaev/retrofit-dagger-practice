package android.maxim.practiceretrofit1804.model;

import javax.inject.Inject;

public class Repository {

    UserAPI userAPI;

    @Inject
    public Repository(UserAPI userAPI) {
        this.userAPI = userAPI;
    }
}
