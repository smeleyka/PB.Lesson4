package ru.geekbrains.android3_4.presenter;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
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
//        userRepo.getUser("smeleyka")
//                .observeOn(scheduler)
//                .subscribe(user -> {
//                    view.showAvatar(user.getAvatarUrl());
//                    view.setUsername(user.getLogin());
//                    view.setRepoUrl(user.getReposUrl());
//                }, throwable -> {
//                    Log.e(TAG, "Failed to get user", throwable);
//                    view.showError(throwable.getMessage());
//                });

        Observable.zip(userRepo.getUser("smeleyka"),
                userRepo.getUserRepos("smeleyka"), (user, repos) -> {
                    user.setRepos(repos);
                    return user;
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(scheduler)
                .subscribe(user -> {
                    view.setUsername(user.getLogin());
                    view.showAvatar(user.getAvatarUrl());
                    user.getRepos().forEach(repos -> view.setRepos(repos.getName()));
                }, throwable -> {
                    view.showError(throwable.getMessage());
                });


    }
}
