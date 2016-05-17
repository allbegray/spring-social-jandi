package org.springframework.social.jandi.type;

/**
 * Created by allbegray on 2016-05-17.
 */
public class JandiText {

    private StringBuilder text = new StringBuilder();

    public JandiText url(String text, String url) {
        this.text.append("[").append(text).append("](").append(url).append(")");
        return this;
    }

    public JandiText text(String text) {
        this.text.append(text);
        return this;
    }

    public String toText() {
        return text.toString();
    }

    public void clear() {
        text.setLength(0);
    }

}
