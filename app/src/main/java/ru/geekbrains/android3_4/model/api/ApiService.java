package ru.geekbrains.android3_4.model.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.geekbrains.android3_4.model.entity.User;

/**
 * Created by stanislav on 3/12/2018.
 */

public interface ApiService
{
    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String userName);

    @GET("users/{user}/repos")
    Observable<User> getUserRepos(@Path("user") String userName);
}
