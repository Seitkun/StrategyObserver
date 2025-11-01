public class BreakingNews extends NotificationDecorator {

    public BreakingNews(NotificationStrategy inner) {
        super(inner);
    }

    @Override
    public void sendNotification(String Subscriber, String message) {
        String decorated = "!!!Breaking : " + message;
        super.sendNotification(Subscriber, decorated);
    }
}
