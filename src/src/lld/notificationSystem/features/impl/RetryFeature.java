package lld.notificationSystem.features.impl;

import lld.notificationSystem.features.NotificationFeature;

public class RetryFeature implements NotificationFeature {
    @Override
    public void executeFeature(String input) {
        System.out.println("Retrying the request after 10 sec....");
    }
}
