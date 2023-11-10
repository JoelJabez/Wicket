package com.example.pages;

import com.example.IUserService;
import com.example.UserService;
import com.example.domain.User;
import com.example.provider.UserProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

public class UserPage extends WebPage {
    @SpringBean
    IUserService userService = new UserService();
    UserProvider userProvider = new UserProvider();
    User user = new User();
    public UserPage() {
        var form = new Form<>("user", new CompoundPropertyModel<>(user));
        add(form);
        form.add(new TextField<>("firstName"));
        form.add(new TextField<>("lastName"));
        form.add(new SubmitLink("submit") {
            @Override
            public void onSubmit() {
                userService.addUser(user);
                userProvider.addUser(user);
            }
        });

        List<IColumn> columns = new ArrayList<>();
        columns.add(new PropertyColumn<>(Model.of("First Name"), "firstName"));
        columns.add(new PropertyColumn<>(Model.of("Last Name"), "lastName"));

        var table = new DefaultDataTable("table", columns, userProvider, 12);
        add(table);
    }
}
