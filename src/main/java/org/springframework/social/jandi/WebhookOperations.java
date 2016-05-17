package org.springframework.social.jandi;

import org.springframework.social.jandi.type.ConnectInfo;

import java.util.List;

/**
 * Created by allbegray on 2016-05-17.
 */
public interface WebhookOperations {

    boolean sendMessage(String body, String connectColor, List<ConnectInfo> connectInfos);

}
