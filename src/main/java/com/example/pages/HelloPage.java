package com.example.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;

public class HelloPage extends WebPage {
	public HelloPage(){
		add(new FragmentTest());
	}

	public class FragmentTest extends Fragment {
		public FragmentTest() {
			super("say", "testingFragment", HelloPage.this);
			add(new Label("hello", "hello world"));
		}
	}
}
