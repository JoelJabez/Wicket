package com.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private int counter = 0;
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		IModel<Integer> counterModel = () -> counter;

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
