import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NewsPortalFacade portal = new NewsPortalFacade();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== NEWS PORTAL SYSTEM ===");

        boolean running = true;
        while (running) {
            System.out.println("\n---------------------------");
            System.out.println("1. Add subscriber");
            System.out.println("2. Publish news");
            System.out.println("3. Change delivery method");
            System.out.println("4. View subscribers");
            System.out.println("5. Remove subscriber");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter subscriber name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Choose delivery (email/sms/push): ");
                    String method = sc.nextLine().trim().toLowerCase();
                    portal.subscribe(name, method);
                    break;

                case "2":
                    System.out.print("Enter news text: ");
                    String news = sc.nextLine().trim();
                    portal.publishNews(news);
                    break;

                case "3":
                    System.out.print("Enter subscriber name: ");
                    String changeName = sc.nextLine().trim();
                    System.out.print("New delivery method (email/sms/push): ");
                    String newMethod = sc.nextLine().trim().toLowerCase();
                    portal.changeDelivery(changeName, newMethod);
                    break;

                case "4":
                    portal.showSubscribers();
                    break;

                case "5":
                    System.out.print("Enter subscriber name to remove: ");
                    String remName = sc.nextLine().trim();
                    portal.unsubscribe(remName);
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("-X- Invalid option!");
            }
        }

        sc.close();
        System.out.println(" Exiting News Portal...");
    }
}
