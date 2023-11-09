package com.example.pages;

import com.example.WicketApplication;
import com.example.domain.Phone;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

public class NokiaPanel extends Panel {
    public NokiaPanel(String id) {
        super(id);
        add(new ListView<>("nokias", WicketApplication.get().getPhones("Nokia")) {
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
