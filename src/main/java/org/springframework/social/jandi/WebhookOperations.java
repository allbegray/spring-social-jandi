package org.springframework.social.jandi;

import org.springframework.social.jandi.type.ConnectInfo;
import org.springframework.social.jandi.type.JandiMessage;

import java.util.List;

/**
 * Created by allbegray on 2016-05-17.
 */
public interface WebhookOperations {

    boolean sendMessage(JandiMessage message);

    boolean sendMessage(String body, String connectColor, List<ConnectInfo> connectInfos);

}
