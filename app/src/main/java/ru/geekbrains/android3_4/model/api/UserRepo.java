package ru.geekbrains.android3_4.model.api;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import ru.geekbrains.android3_4.model.entity.User;

/**
 * Created by stanislav on 3/12/2018.
 */

public class UserRepo extends Repo
{
    public Observable<User> getUser(String username)
    {
        return getApi().getUser(username).subscribeOn(Schedulers.io());
    }

    public Observable<User> getUserRepos(String username)
    {
        return getApi().getUserRepos(username).subscribeOn(Schedulers.io());
    }
}
