import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NewsAgency {
    private final List<Subscribers> subscribers = new CopyOnWriteArrayList<>();

    public void register(Subscribers s) {
        if (!subscribers.contains(s)) {
            subscribers.add(s);
            System.out.println(s.getName() + " subscribed.");
        }
    }

    public void unregister(Subscribers s) {
        subscribers.remove(s);
        System.out.println(s.getName() + " unsubscribed.");
    }

    public void publish(Article article) {
        System.out.println("\n Publishing → " + article);
        for (Subscribers s : subscribers) {
            s.update(article);
        }
    }
}
