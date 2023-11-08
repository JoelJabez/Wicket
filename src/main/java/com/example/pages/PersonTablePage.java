package com.example.pages;

import com.example.provider.PersonProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

public class PersonTablePage extends WebPage {
    public PersonTablePage() {
        var persons = new PersonProvider();

//        var dataView = new DataView("simple", new ListDataProvider<>(persons)) {
//            @Override
//            protected void populateItem(Item item) {
//                var person = (Person) item.getModelObject();
//                item.add(new Label("name", person.name()));
//                item.add(new Label("age", person.age()));
//            }
//        };
//        add(dataView);

        List<IColumn> columns = new ArrayList<>();
        columns.add(new PropertyColumn<>(Model.of("Name"), "name"));
        columns.add(new PropertyColumn<>(Model.of("Age"), "age"));

        var table = new DefaultDataTable("table", columns, persons, 12);

        add(table);
    }
}
