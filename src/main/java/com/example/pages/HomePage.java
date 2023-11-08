package com.example.pages;

import com.example.WicketApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;

public class HomePage extends WebPage implements Serializable {
	private static final long serialVersionUID = 1L;

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

		for (int i = 1; i <= WicketApplication.get().selectedApples().size(); i++) {
			repeater.add(new Label(String.valueOf(i), WicketApplication.get().selectedApples()[i].model()));
		}
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
}
