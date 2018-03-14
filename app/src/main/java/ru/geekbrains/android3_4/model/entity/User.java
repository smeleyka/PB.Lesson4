package ru.geekbrains.android3_4.model.entity;

import java.util.List;

/**
 * Created by stanislav on 3/12/2018.
 */

public class User {
    private String avatarUrl;
    private String login;
    private List<Repos> repos;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Repos> getRepos() {
        return repos;
    }

    public void setRepos(List<Repos> repos) {
        this.repos = repos;
    }


    public class Repos {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
