package com.example.pages;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class ApplePage extends Index {
    Panel nokiaPanel = new NokiaPanel("phones");
    Panel nothingPanel = new NothingPhonePanel("phones");
    Panel current = nokiaPanel;

    public ApplePage() {
        createModel("apples", "Apple");

        add(new Link<>("nokia") {
            @Override
            public void onClick() {
                current.replaceWith(nokiaPanel);
                current = nokiaPanel;
            }

            @Override
            public boolean isEnabled() {
                return current != nokiaPanel;
            }
        });

        add(new Link<>("nothing") {
            @Override
            public void onClick() {
                current.replaceWith(nothingPanel);
                current = nothingPanel;
            }

            @Override
            public boolean isEnabled() {
                return current != nothingPanel;
            }
        });
        add(current);
    }
}
