package com.example;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.*;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends WebPage implements Serializable {
	private int counter = 0;
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		hello();
		incrementMethod();
		clock();
		address();
	}

	private void hello() {
		add(new Label("hello", "Hello world"));
	}

	private void incrementMethod() {
		IModel<Integer> counterModel = new PropertyModel<>(this, "counter");

		var incrementLink = new Link<>("increment") {
			@Override
			public void onClick() {
				counter++;
			}
		};

		add(new Label("counter", counterModel));
		add(incrementLink);
	}

	private void clock() {
		var clockLink = new Link<>("refresh") {
			@Override
			public void onClick() {
			}
		};

		var clock = new Model<>() {
			@Override
			public Serializable getObject() {
				var dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return dateFormat.format(new Date());
			}
		};

		add(new Label("clock", clock));
		add(clockLink);
	}

	private void address() {
		var address = new Address("foo", "bar", "baz", "132");

		setDefaultModel(new CompoundPropertyModel<>(address));
		var parent = new WebMarkupContainer("address");

		add(parent);
		parent.add(new Label("street"));
		parent.add(new Label("city"));
	}
}
