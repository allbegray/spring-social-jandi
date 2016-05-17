package org.springframework.social.jandi.type;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allbegray on 2016-05-17.
 */
public class JandiMessage {

    private String body;
    private String connectColor;
    private List<ConnectInfo> connectInfos;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBody(JandiText body) {
        this.body = body.toText();
    }

    public String getConnectColor() {
        return connectColor;
    }

    public void setConnectColor(String connectColor) {
        this.connectColor = connectColor;
    }

    public void addConnectInfo(ConnectInfo connectInfo) {
        getConnectInfos().add(connectInfo);
    }

    @JsonProperty("connectInfo")
    public List<ConnectInfo> getConnectInfos() {
        if (connectInfos == null) {
            connectInfos = new ArrayList<ConnectInfo>();
        }
        return connectInfos;
    }

    public void setConnectInfos(List<ConnectInfo> connectInfos) {
        this.connectInfos = connectInfos;
    }

}
