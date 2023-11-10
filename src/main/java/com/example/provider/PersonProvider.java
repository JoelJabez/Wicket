package com.example.provider;

import com.example.domain.Person;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.*;

public class PersonProvider extends SortableDataProvider {
    private List<Person> persons = new ArrayList<>();

    public PersonProvider() {
        persons.add(new Person("Alice", 13));
        persons.add(new Person("George", 19));
        persons.add(new Person("Bob", 14));
        persons.add(new Person("Chris", 15));
        persons.add(new Person("Doe", 16));
        persons.add(new Person("Linda", 22));
        persons.add(new Person("Ellen", 17));
        persons.add(new Person("Frank", 18));
        persons.add(new Person("Ivan", 20));
        persons.add(new Person("Kris", 21));
        persons.add(new Person("Mohan", 23));
        persons.add(new Person("John", 12));
    }

    @Override
    public Iterator<Person> iterator(long first, long second) {
        var newList = getIndex(getSort());

        return newList.subList((int) first, (int) (first + second)).iterator();
    }

    public <S> List<Person> getIndex(SortParam<S> sort) {
        if (sort == null) {
            return persons;
        }

        if (sort.getProperty().equals("name")) {
            var ascendingName = persons.sorted(Comparator.comparing(Person::name)).toList();
            var descendingName = ascendingName.reversed();

            return sort.isAscending() ? ascendingName : descendingName;
        } else if (sort.getProperty().equals("age")) {
            var ascendingAge = persons.sorted(Comparator.comparing(Person::age)).toList();
            var descendingAge = ascendingAge.reversed();

            return sort.isAscending() ? ascendingAge : descendingAge;
        }

        throw new RuntimeException("unknown sort option [" + sort +
            "]. valid fields: [name], [age]");
    }

    @Override
    public long size() {
        return persons.size();
    }

    @Override
    public IModel model(Object o) {
        return Model.of((Person) o);
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }
}
