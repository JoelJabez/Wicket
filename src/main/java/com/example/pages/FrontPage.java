package com.example.pages;

import com.example.WicketApplication;
import com.example.domain.Apple;
import com.example.domain.Cart;
import org.apache.wicket.markup.html.WebPage;

import java.util.List;

public abstract class FrontPage extends WebPage {
    public FrontPageSession getFrontPageSession() {
        return (FrontPageSession) getSession();
    }

    public Cart getCart() {
        return getFrontPageSession().cart;
    }

    public List<Apple> getSelectedApples() {
        return WicketApplication.get().selectedApples();
    }

    public List<Apple> getApples() {
        return WicketApplication.get().getApples();
    }
}
