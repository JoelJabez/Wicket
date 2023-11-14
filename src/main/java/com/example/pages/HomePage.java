package com.example.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends WebPage implements Serializable {
	int counter = 0;

	public HomePage() {
		hello();
		incrementMethod();
		clock();
		formMethod();
		panel();
		repeaters();
		link();
		internalLink();
		frontPage();
		personTable();
		ajax();
		ajaxIncrement();
		userForm();
	}

	private void hello() {
		add(new Label("hello", "Hello world"));
	}

	private void incrementMethod() {
		add(new IncrementPanel("incrementPanel"));
	}

	private void clock() {
		add(new ClockPanel("clockPanel"));
	}

	private void formMethod() {
		add(new BookmarkablePageLink<>("form", FormPage.class));
	}

	private void panel() {
		add(new PanelExample("panel"));
	}

	private void repeaters() {
		var repeater = new RepeatingView("repeater");
		add(repeater);
		List<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charles");
		names.add("David");
		names.add("Echo");
		names.add("Fred");

		names.forEach(name -> repeater.add(new Label(String.valueOf(name.hashCode()), name)));
	}

	private void link() {
		add(new ExternalLink("link", "https://wicket.apache.org/", "Wicket"));
	}

	private void internalLink() {
		var pageParameters = new PageParameters();
		pageParameters.add("text", "hello world");
		add(new BookmarkablePageLink<>("internalLink", HelloPage.class, pageParameters));
	}

	private void frontPage() {
		add(new BookmarkablePageLink<>("frontPage", Index.class));
	}

	private void personTable() {
		add(new BookmarkablePageLink<>("personTable", PersonTablePage.class));
	}

	private void ajax() {
		add(new AjaxLink<>("ajax") {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				ajaxRequestTarget.appendJavaScript("alert('')");
			}
		});
	}

	private void ajaxIncrement() {
		var counterModel = new PropertyModel<>(this, "counter");
		var counterLabelWithAjax = new Label("ajaxCounter", counterModel);
		add(counterLabelWithAjax);

		counterLabelWithAjax.setOutputMarkupId(true);
		add(new AjaxLink<>("ajaxIncrement") {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				counter++;
				ajaxRequestTarget.appendJavaScript("alert('$counter')");
				ajaxRequestTarget.add(counterLabelWithAjax);
			}
		});
	}

	private void userForm() {
		add(new BookmarkablePageLink<>("userForm", UserPage.class));
	}
}
