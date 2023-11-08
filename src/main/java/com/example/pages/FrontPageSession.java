package com.example.pages;

import com.example.domain.Cart;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class FrontPageSession extends WebSession {
    private Cart cart = new Cart();
    public FrontPageSession(Request request) {
        super(request);
    }

    public Cart getCart() {
        return cart;
    }
}
