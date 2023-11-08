package com.example.provider;

import com.example.domain.Person;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PersonProvider extends SortableDataProvider {
    private List<Person> persons = new ArrayList<>();

    public PersonProvider() {
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
    @Override
    public Iterator<Person> iterator(long first, long second) {
        var newList = new ArrayList<>(persons);

        return newList.subList((int) first, (int) (first + second)).iterator();
    }

    @Override
    public long size() {
        return persons.size();
    }

    @Override
    public IModel model(Object o) {
        return null;
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }
}
