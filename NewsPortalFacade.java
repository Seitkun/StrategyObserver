import java.util.HashMap;
import java.util.Map;

public class NewsPortalFacade {
    private final NewsAgency agency = new NewsAgency();
    private final Map<String, UserSubscriber> subscribers = new HashMap<>();

    public void subscribe(String name, String strategyType) {
        if (subscribers.containsKey(name)) {
            System.out.println("!!! Subscriber already exists!");
            return;
        }
        NotificationStrategy strategy = createStrategy(strategyType);
        UserSubscriber subscriber = new UserSubscriber(name, strategy);
        agency.register(subscriber);
        subscribers.put(name, subscriber);
    }

    public void unsubscribe(String name) {
        UserSubscriber s = subscribers.remove(name);
        if (s != null) {
            agency.unregister(s);
        } else {
            System.out.println("Subscriber not found!");
        }
    }

    public void changeDelivery(String name, String newStrategy) {
        UserSubscriber s = subscribers.get(name);
        if (s != null) {
            s.setStrategy(createStrategy(newStrategy));
            System.out.println(name + " switched to " + newStrategy.toUpperCase());
        } else {
            System.out.println("Subscriber not found!");
        }
    }

    public void publishNews(String text) {
        Article article = new Article(text);
        agency.publish(article);
    }

    public void showSubscribers() {
        if (subscribers.isEmpty()) {
            System.out.println("No subscribers yet.");
        } else {
            System.out.println("\nCurrent subscribers:");
            for (String name : subscribers.keySet()) {
                System.out.println("- " + name);
            }
        }
    }

    private NotificationStrategy createStrategy(String type) {
        switch (type.toLowerCase()) {
            case "email": return new EmailNotification();
            case "sms": return new SMSNotification();
            case "push": return new PushNotification();
            default:
                System.out.println("Unknown strategy, defaulting to email.");
                return new EmailNotification();
        }
    }
}
