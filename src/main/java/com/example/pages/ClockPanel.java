package com.example.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockPanel extends Panel {
	public ClockPanel(String id) {
		super(id);
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
}
