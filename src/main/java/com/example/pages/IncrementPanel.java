package com.example.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class IncrementPanel extends Panel {
	private int counter = 0;

	public IncrementPanel(String id) {
		super(id);
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
}
