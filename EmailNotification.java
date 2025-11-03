public class EmailNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String Subscriber, String message) {
        System.out.println("[Email] to " + Subscriber + ": " + message);
    }
}