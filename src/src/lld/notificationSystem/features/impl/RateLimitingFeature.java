package lld.notificationSystem.features.impl;

import lld.notificationSystem.features.NotificationFeature;

public class RateLimitingFeature implements NotificationFeature {
    @Override
    public void executeFeature(String input) {
        System.out.println("Validating Requests are not getting throttled and ensure excess notifications not sent.");
    }
}
