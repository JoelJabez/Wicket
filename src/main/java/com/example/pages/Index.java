package com.example.pages;

import com.example.domain.Apple;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class Index extends FrontPage {
    public Index() {
        add(new ListView("apples", getApples()) {

            @Override
            protected void populateItem(ListItem listItem) {
                var apple = (Apple) listItem.getModelObject();
                listItem.add(new Label("model", apple.model()));
                listItem.add(new ExternalLink("link", apple.site(), apple.model()) {
                    @Override
                    protected void onComponentTag(ComponentTag tag) {
                        super.onComponentTag(tag);
                        tag.put("target", "_blank");
                    }
                });
                listItem.add(new Link("add", listItem.model) {
                    @Override
                    public void onClick() {
                        getSelectedApples().add(apple);
                    }
                });
            }
        });
    }
}
