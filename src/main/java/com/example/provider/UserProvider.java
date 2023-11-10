package com.example.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.example.domain.User;

public class UserProvider extends SortableDataProvider {
    private List<User> users = new ArrayList<>();

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

    public List<User> getAllUser() {
        return users;
    }
}
