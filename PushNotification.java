public class PushNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String Subscriber, String message) {
        System.out.println("🔔 [Push] to " + Subscriber + ": " + message);
    }
}
