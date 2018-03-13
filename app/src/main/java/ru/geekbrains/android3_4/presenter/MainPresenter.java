package ru.geekbrains.android3_4.presenter;

import android.util.Log;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.operators.observable.ObservableAll;
import ru.geekbrains.android3_4.model.api.UserRepo;
import ru.geekbrains.android3_4.view.MainView;

/**
 * Created by stanislav on 3/12/2018.
 */

public class MainPresenter
{
    private static final String TAG = "MainPresenter";
    private MainView view;
    private Scheduler scheduler;
    private UserRepo userRepo;

    public MainPresenter(MainView view, Scheduler scheduler)
    {
        this.view = view;
        this.scheduler = scheduler;
        userRepo = new UserRepo();
    }

    public void loadInfo()
    {
        userRepo.getUser("smeleyka")
                .observeOn(scheduler)
                .subscribe(user -> {
                    view.showAvatar(user.getAvatarUrl());
                    view.setUsername(user.getLogin());
                    view.setRepoUrl(user.getReposUrl());
                }, throwable -> {
                    Log.e(TAG, "Failed to get user", throwable);
                    view.showError(throwable.getMessage());
                });
    }
}
