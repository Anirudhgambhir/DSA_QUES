## Problem: Smart Notification System for an E-Commerce Platform

An e-commerce platform needs a notification system with these requirements:

1. When certain events occur (order placed, order shipped, order delivered, payment failed), multiple parts of the system need to be notified — the
   customer, the warehouse, the analytics dashboard, and the fraud detection module.

2. Notifications can be sent via multiple channels: Email, SMS, Push Notification. Each channel has different formatting and delivery logic.

3. Notifications can be enhanced with optional features that can be combined freely:
    - Logging (log every notification sent)
    - Rate limiting (don't send more than X notifications per minute to a user)
    - Retry on failure (retry up to N times if delivery fails)

4. The channel used to send a notification depends on runtime conditions:
    - If the user has a mobile app installed → Push Notification
    - If the user has a phone number on file → SMS
    - Default fallback → Email