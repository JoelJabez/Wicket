package com.example.pages;

import com.example.IUserService;
import com.example.WicketApplication;
import com.example.domain.User;
import com.example.provider.UserProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

public class UserPage extends WebPage {
    IUserService userService = WicketApplication.get().userService;
    UserProvider userProvider = new UserProvider();
    DefaultDataTable table;
    WebMarkupContainer container;
    List<User> users = new ArrayList<>();
    User user = new User();

    public UserPage() {
        var form = new Form<>("user", new CompoundPropertyModel<>(user));
        add(form);
        form.add(new TextField<>("firstName"));
        form.add(new TextField<>("lastName"));
        form.add(new SubmitLink("submit") {
            @Override
            public void onSubmit() {
                users.add(user);
                userProvider.addUsers(users);
            }
        });

        List<IColumn> columns = new ArrayList<>();

        columns.add(new PropertyColumn<>(Model.of("First Name"), "firstName"));
        columns.add(new PropertyColumn<>(Model.of("Last Name"), "lastName"));

        container = new WebMarkupContainer("container");
        table = new DefaultDataTable("table", columns, userProvider, 12);
        container.setOutputMarkupPlaceholderTag(true);
        container.add(table);
        add(container);
    }
}
