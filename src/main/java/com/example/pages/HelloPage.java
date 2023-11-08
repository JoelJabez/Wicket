package com.example.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HelloPage extends WebPage {
	public HelloPage(final PageParameters pageParameters){
		add(new FragmentTest(pageParameters));
	}

	public class FragmentTest extends Fragment {
		public FragmentTest(PageParameters pageParameters) {
			super("say", "testingFragment", HelloPage.this);
			add(new Label("hello",
					pageParameters.get("text").isEmpty ? "" : pageParameters.get("text")));
		}
	}
}
