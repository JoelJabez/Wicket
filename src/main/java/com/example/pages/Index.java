package com.example.pages;

import com.example.domain.Phone;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class Index extends FrontPage {
    public Index() {
    }

    void createModel(String id, String name) {
        add(new ListView<>(id, getPhones(name)) {
            @Override
            protected void populateItem(ListItem listItem) {
                var samsung = (Phone) listItem.getModelObject();
                listItem.add(new Label("model", samsung.model()));
                listItem.add(new ExternalLink("link", samsung.site(), samsung.model()) {
                    @Override
                    protected void onComponentTag(ComponentTag tag) {
                        super.onComponentTag(tag);
                        tag.put("target", "_blank");
                    }
                });
            }
        });
    }
}
