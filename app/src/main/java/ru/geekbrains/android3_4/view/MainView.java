package ru.geekbrains.android3_4.view;

/**
 * Created by stanislav on 3/12/2018.
 */

public interface MainView
{
    void showAvatar(String avatarUrl);
    void showError(String message);
    void setUsername(String username);
    void setRepos(String repos);
}
