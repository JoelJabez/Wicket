package com.example;

import com.example.domain.Phone;
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

public class WicketApplication extends WebApplication {
	private final List<Phone> apple = Arrays.asList(
		new Phone("iPhone 15 Pro", "https://www.apple.com/my/iphone-15-pro/"),
		new Phone("iPhone 15", "https://www.apple.com/my/iphone-15/"),
		new Phone("iPhone 14", "https://www.apple.com/my/shop/buy-iphone/iphone-14"),
		new Phone("iPhone 13", "https://www.apple.com/my/shop/buy-iphone/iphone-13"),
		new Phone("iPhone SE", "https://www.apple.com/my/iphone-se/")
	);
	
	private final List<Phone> samsung = Arrays.asList(
		new Phone(
			"Galaxy Z Flip5",
			"https://www.samsung.com/my/smartphones/galaxy-z-flip5/buy/"
		),

		new Phone(
			"Galaxy Z Fold5",
			"https://www.samsung.com/my/smartphones/galaxy-z-fold5/buy/"
		),

		new Phone(
			"Galaxy S23 FE",
			"https://www.samsung.com/my/smartphones/galaxy-s/galaxy-s23-fe-mint-128gb-sm-s711blgbxme/buy/"
		),

		new Phone(
			"Galaxy S23",
			"https://www.samsung.com/my/smartphones/galaxy-s23/buy/"
		),

		new Phone(
			"Galaxy A54 5G",
			"https://www.samsung.com/my/smartphones/galaxy-a/galaxy-a54-5g-awesome-violet-256gb-sm-a546elvdxme/buy/"
		)
	);

	private final List<Phone> nothingPhone = Arrays.asList(
		new Phone("Nothing Phone(1)", "https://my.nothing.tech/products/phone-1"),
		new Phone("Nothing Phone(2)", "https://my.nothing.tech/pages/phone-2")
	);
	
	private final List<Phone> nokia = Arrays.asList(
		new Phone("Nokia X30 5G", "https://www.nokia.com/phones/en_my/nokia-x-30?sku=VMA751R9FI1AL0"),
		new Phone("Nokia C21 Plus", "https://www.nokia.com/phones/en_my/nokia-c-21-plus?sku=719901189181"),
		new Phone("Nokia C21", "https://www.nokia.com/phones/en_my/nokia-c-21?sku=286717235"),
		new Phone("Nokia G21", "https://www.nokia.com/phones/en_my/nokia-g-21?sku=719901185181"),
		new Phone("Nokia C01 Plus", "https://www.nokia.com/phones/en_my/nokia-c-01-plus?sku=719901162051")
	);

	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
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

	public List<Phone> getPhones(String name) {
		return switch (name) {
			case "Apple" -> Collections.unmodifiableList(apple);
			case "Samsung" -> Collections.unmodifiableList(samsung);
			case "NothingPhone" -> Collections.unmodifiableList(nothingPhone);
			case "Nokia" -> Collections.unmodifiableList(nokia);
			default -> throw new IllegalStateException("Unexpected value: " + name);
		};
	}

	public List<Phone> selectedApples() {
		return new ArrayList<>();
	}
}
