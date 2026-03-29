# Smart Notification System — Design Document

## Problem Statement

An e-commerce platform needs a notification system that:
1. Notifies multiple parties (Customer, Warehouse, Analytics, Fraud) when events occur (Order Placed/Shipped/Delivered, Payment Failed)
2. Supports multiple channels: Email, SMS, Push Notification
3. Allows optional features (Logging, Rate Limiting, Retry) to be combined freely on any channel
4. Selects channels at runtime based on user profile data

---

## Design Patterns Used

| Pattern | Where | Why |
|-----------|-------|-----|
| **Observer** | EventManager → Observers | Multiple parties react to a single event without tight coupling |
| **Strategy** | SMS / Email / Push as interchangeable `Notification` implementations | Channel logic varies but the interface is uniform |
| **Factory** | `ChannelFactory`, `DecoratorFactory` | Channel selection and decorator wrapping depend on runtime data |
| **Decorator** | Logging, Retry, RateLimiting wrapping a `Notification` | Optional behaviors layered freely without subclass explosion |

---

## Key Interfaces & Classes

### 1. Notification (Strategy Interface)

```
<<interface>> Notification
  + notify(event: Event, userData: UserData): void
  + getType(): NotificationType
```

Concrete strategies: `EmailNotification`, `SMSNotification`, `PushNotification`

### 2. NotificationDecorator (Decorator Base)

```
<<abstract>> NotificationDecorator implements Notification
  - wrapped: Notification
  + notify(event: Event, userData: UserData): void
```

Concrete decorators: `LoggingDecorator`, `RetryDecorator`, `RateLimitingDecorator`

### 3. Observer Pattern

```
<<interface>> EventObserver
  + update(event: Event): void

EventManager (Subject)
  - observers: Map<EventType, List<EventObserver>>
  + subscribe(eventType: EventType, observer: EventObserver): void
  + unsubscribe(eventType: EventType, observer: EventObserver): void
  + fireEvent(event: Event): void
```

Concrete observers: `CustomerObserver`, `WarehouseObserver`, `AnalyticsObserver`, `FraudObserver`

Each observer holds a `UserData` reference and delegates channel selection to the factory.

### 4. Factories

```
ChannelFactory
  + create(userData: UserData): List<Notification>
    // has app → Push, has phone → SMS, default → Email

DecoratorFactory
  + wrap(notification: Notification): Notification
    // based on notification.getType(), layers appropriate decorators
```

---

## Event Flow (Trace)

```
1. ORDER_SHIPPED event occurs

2. EventManager.fireEvent(ORDER_SHIPPED)
   └── iterates observers registered for ORDER_SHIPPED

3. CustomerObserver.update(event):
   ├── channels = ChannelFactory.create(this.userData)   → [Push, Email]
   ├── decorated = DecoratorFactory.wrap(each channel)   → [Push+Log+Retry, Email+Log]
   └── for each: decorated.notify(event, userData)

4. WarehouseObserver.update(event):
   ├── channels = ChannelFactory.create(this.userData)   → [Email]
   ├── decorated = DecoratorFactory.wrap(each channel)   → [Email+Log]
   └── for each: decorated.notify(event, userData)
```

---

## UML Class Diagram

```mermaid
classDiagram
    class Notification {
        <<interface>>
        +notify(event, userData) void
        +getType() NotificationType
    }

    class EmailNotification {
        +notify(event, userData) void
        +getType() NotificationType
    }

    class SMSNotification {
        +notify(event, userData) void
        +getType() NotificationType
    }

    class PushNotification {
        +notify(event, userData) void
        +getType() NotificationType
    }

    class NotificationDecorator {
        <<abstract>>
        -wrapped: Notification
        +notify(event, userData) void
    }

    class LoggingDecorator {
        +notify(event, userData) void
    }

    class RetryDecorator {
        -maxRetries: int
        +notify(event, userData) void
    }

    class RateLimitingDecorator {
        -maxPerMinute: int
        +notify(event, userData) void
    }

    class EventObserver {
        <<interface>>
        +update(event) void
    }

    class CustomerObserver {
        -userData: UserData
        +update(event) void
    }

    class WarehouseObserver {
        -userData: UserData
        +update(event) void
    }

    class AnalyticsObserver {
        -userData: UserData
        +update(event) void
    }

    class FraudObserver {
        -userData: UserData
        +update(event) void
    }

    class EventManager {
        -observers: Map~EventType, List~EventObserver~~
        +subscribe(eventType, observer) void
        +unsubscribe(eventType, observer) void
        +fireEvent(event) void
    }

    class ChannelFactory {
        +create(userData) List~Notification~
    }

    class DecoratorFactory {
        +wrap(notification) Notification
    }

    class UserData {
        -hasApp: boolean
        -hasPhone: boolean
        -email: String
    }

    class Event {
        -type: EventType
        -data: Map
    }

    Notification <|.. EmailNotification
    Notification <|.. SMSNotification
    Notification <|.. PushNotification
    Notification <|.. NotificationDecorator
    NotificationDecorator <|-- LoggingDecorator
    NotificationDecorator <|-- RetryDecorator
    NotificationDecorator <|-- RateLimitingDecorator
    NotificationDecorator o-- Notification : wraps

    EventObserver <|.. CustomerObserver
    EventObserver <|.. WarehouseObserver
    EventObserver <|.. AnalyticsObserver
    EventObserver <|.. FraudObserver

    EventManager o-- EventObserver : notifies
    CustomerObserver --> ChannelFactory : uses
    WarehouseObserver --> ChannelFactory : uses
    AnalyticsObserver --> ChannelFactory : uses
    FraudObserver --> ChannelFactory : uses
    CustomerObserver --> DecoratorFactory : uses
    ChannelFactory --> Notification : creates
    DecoratorFactory --> NotificationDecorator : creates
    CustomerObserver --> UserData : holds
    WarehouseObserver --> UserData : holds
```

---

## Sequence Diagram

```mermaid
sequenceDiagram
    participant Client
    participant EventManager
    participant CustomerObserver
    participant ChannelFactory
    participant DecoratorFactory
    participant PushNotification

    Client->>EventManager: fireEvent(ORDER_SHIPPED)
    EventManager->>CustomerObserver: update(event)
    CustomerObserver->>ChannelFactory: create(userData)
    ChannelFactory-->>CustomerObserver: [PushNotification]
    CustomerObserver->>DecoratorFactory: wrap(pushNotification)
    DecoratorFactory-->>CustomerObserver: LoggingDecorator(RetryDecorator(Push))
    CustomerObserver->>PushNotification: notify(event, userData)
    PushNotification-->>CustomerObserver: done
```

---

## Design Decisions Summary

1. **Observer** decouples event sources from listeners — adding a new listener (e.g., Loyalty Module) requires zero changes to existing code.
2. **Strategy** makes channels interchangeable — all implement `Notification`, so the rest of the system doesn't care if it's SMS or Push.
3. **Factory** encapsulates creation logic — channel selection (based on UserData) and decorator assembly (based on NotificationType) each live in one place.
4. **Decorator** avoids subclass explosion — instead of `LoggingSMSNotification`, `RetryPushNotification`, etc., features are layered dynamically.
5. **Observers delegate to factories** instead of owning channel preferences — ensures channel selection uses current profile data at runtime.
