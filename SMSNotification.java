public class SMSNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String Subscriber, String message) {
        System.out.println("[SMS] to " + Subscriber + ": " + message);
    }
}