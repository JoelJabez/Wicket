package com.example.pages;

import com.example.domain.Address;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

import java.io.Serializable;
import java.util.Arrays;

public class HomePage extends WebPage implements Serializable {
	private Address address = new Address();
	private static final long serialVersionUID = 1L;
	private static final String ZIPCODE = "zipcode";

	public HomePage() {
		hello();
		incrementMethod();
		clock();
		address();
		formMethod();
		panel();
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

	private void address() {
		var parent = new WebMarkupContainer("address", new CompoundPropertyModel<>(address));

		add(parent);
		parent.add(new Label("street"));
		parent.add(new Label("city"));
		parent.add(new Label("state"));
		parent.add(new Label(ZIPCODE));
	}

	private void formMethod() {
		var form = new Form<>("form", new CompoundPropertyModel<>(address));
		var states = Arrays.asList(
			"Johor",
			"Kedah",
			"Kelantan",
			"Malacca",
			"Negeri Sembilan",
			"Pahang",
			"Penang",
			"Perak",
			"Perlis",
			"Sarawak",
			"Selangor",
			"Terengganu"
		);

		address.state = null;
		add(form);
		var streetTextField = new TextField<>("street");
		streetTextField.isRequired = true;
		streetTextField.add(StringValidator.maximumLength(20));

		form.add(streetTextField);
		form.add(new TextField<>("city"));
		form.add(new DropDownChoice<>("state", states));
		form.add(new TextField<>(ZIPCODE).add(StringValidator.exactLength(5)));
	}

	private void panel() {
		add(new PanelExample("panel"));
	}
}
