package lld.notificationSystem.features.impl;

import lld.notificationSystem.features.NotificationFeature;

public class LoggingFeature implements NotificationFeature {

    @Override
    public void executeFeature(String input) {
        System.out.println("Logging the Input notification being passed - " + input);
    }
}
