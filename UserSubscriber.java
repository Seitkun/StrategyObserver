public class UserSubscriber implements Subscribers {
    private final String name;
    private NotificationStrategy strategy;

    public UserSubscriber(String name, NotificationStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(Article article) {
        String message = "New article published: " + article.getText();
        strategy.sendNotification(name, message);
    }

    @Override
    public String getName() {
        return name;
    }
}
