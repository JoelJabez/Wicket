package com.example.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class PanelExample extends Panel {
	public PanelExample(String id) {
		super(id);
		add(new Label("title", "Hello there!"));
	}
}
