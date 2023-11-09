package com.example.pages;

import com.example.domain.Cart;
import manifold.ext.props.rt.api.get;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class FrontPageSession extends WebSession {
    @get
    Cart cart = new Cart();
    public FrontPageSession(Request request) {
        super(request);
    }
}
