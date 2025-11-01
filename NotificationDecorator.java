public abstract class NotificationDecorator implements NotificationStrategy {
    protected final NotificationStrategy inner;

    public NotificationDecorator(NotificationStrategy inner) {
        this.inner = inner;
    }

    @Override
    public void sendNotification(String Subscriber, String message) {
        inner.sendNotification(Subscriber, message);
    }
}
