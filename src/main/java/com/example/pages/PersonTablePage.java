package com.example.pages;

import com.example.domain.Person;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

public class PersonTablePage extends WebPage {
    public PersonTablePage() {
        var persons = new ArrayList<Person>();
        addDataToList(persons);

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
        columns.add(new PropertyColumn<>(Model.of("Name"), "name", "name"));
        columns.add(new PropertyColumn<>(Model.of("Age"), "age", "age"));

        var table = new DefaultDataTable("table", columns, (ISortableDataProvider) persons, 10);

    }

    private void addDataToList(List<Person> persons) {
        persons.add(new Person("John", 12));
        persons.add(new Person("Alice", 13));
        persons.add(new Person("Bob", 14));
        persons.add(new Person("Chris", 15));
        persons.add(new Person("Doe", 16));
        persons.add(new Person("Ellen", 17));
        persons.add(new Person("Frank", 18));
        persons.add(new Person("George", 19));
        persons.add(new Person("Ivan", 20));
        persons.add(new Person("Kris", 21));
        persons.add(new Person("Linda", 22));
        persons.add(new Person("Mohan", 23));

    }
}
