package com.example;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private int counter = 0;
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		IModel<Integer> counterModel = new Model<>() {
			@Override
			public Integer getObject() {
				return counter;
			}
		};

		var link = new Link<Void>("increment") {
			@Override
			public void onClick() {
				counter++;
			}
		};

		add(new Label("Hello", "Hello world!"));
		add(new Label("counter", counterModel));
		add(link);
	}
}
