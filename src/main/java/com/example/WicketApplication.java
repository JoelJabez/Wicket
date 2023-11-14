package com.example;

import com.example.domain.Phone;
import com.example.pages.FrontPageSession;
import com.example.pages.HomePage;
import com.example.utils.CreatePhoneList;
import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WicketApplication extends WebApplication {
	private ApplicationContext context;

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
		context = new ClassPathXmlApplicationContext("classpath:context.xml");

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
			case "Apple" -> Collections.unmodifiableList(CreatePhoneList.apple());
			case "Samsung" -> Collections.unmodifiableList(CreatePhoneList.samsung());
			case "NothingPhone" -> Collections.unmodifiableList(CreatePhoneList.nothingPhone());
			case "Nokia" -> Collections.unmodifiableList(CreatePhoneList.nokia());
			default -> throw new IllegalStateException("Unexpected value: " + name);
		};
	}

	public UserService getUserService() {
		return BeanFactoryUtils.beanOfType(context, UserService.class);
	}

	public List<Phone> selectedApples() {
		return new ArrayList<>();
	}
}
