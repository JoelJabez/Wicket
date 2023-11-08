package com.example;

import com.example.domain.Apple;
import com.example.pages.FrontPageSession;
import com.example.pages.HomePage;
import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WicketApplication extends WebApplication
{
	private final List<Apple> apples = Arrays.asList(
		new Apple("iPhone 15", "https://www.apple.com/my/iphone-15/"),
		new Apple("iPhone 14", "https://www.apple.com/my/shop/buy-iphone/iphone-14"),
		new Apple("iPhone 13", "https://www.apple.com/my/shop/buy-iphone/iphone-13"),
		new Apple("iPhone SE", "https://www.apple.com/my/iphone-se/")
	);

	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// needed for the styling used by the quickstart
		getCspSettings().blocking()
			.add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF)
			.add(CSPDirective.STYLE_SRC, "https://fonts.googleapis.com/css")
			.add(CSPDirective.FONT_SRC, "https://fonts.gstatic.com");
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new FrontPageSession(request);
	}

	public static WicketApplication get() {
		return (WicketApplication) Application.get();
	}

	public List<Apple> getApples(){
		return Collections.unmodifiableList(apples);
	}

	public List<Apple> selectedApples(){
		return new ArrayList<>();
	}
}
