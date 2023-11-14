package com.example.provider;

import java.util.*;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.example.domain.User;

public class UserProvider extends SortableDataProvider {
    private Set<User> users = new HashSet<>();

    @Override
    public Iterator<User> iterator(long first, long second) {
        var newUsers = users;
        return newUsers.subList((int) first, (int) (first + second)).iterator();
    }

    @Override
    public long size() {
        return users.size();
    }

    @Override
    public IModel model(Object o) {
        return Model.of((User) o);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addUsers(List<User> users) {
        this.users.addAll(users);
    }

    public Set<User> getAllUser() {
        return users;
    }
}
