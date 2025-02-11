
import java.util.Scanner;

interface Searchable {

    boolean search(String keyword);
}

class Document implements Searchable {

    private final String content;

    public Document(String content) {
        this.content = content;
    }

    @Override
    public boolean search(String keyword) {
        if (keyword == null || content == null) {
            return false;
        }
        return content.toLowerCase().contains(keyword.toLowerCase());
    }
}

class WebPage implements Searchable {

    private final String url;
    private final String pageContent;

    public WebPage(String url, String pageContent) {
        this.url = url;
        this.pageContent = pageContent;
    }

    @Override
    public boolean search(String keyword) {
        if (keyword == null || pageContent == null) {
            return false;
        }
        // Search in both URL and page content
        return url.toLowerCase().contains(keyword.toLowerCase())
                || pageContent.toLowerCase().contains(keyword.toLowerCase());
    }
}

public class SearchDemo {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get document content from user
            System.out.println("Enter the content for the document:");
            String docContent = scanner.nextLine();
            Document doc = new Document(docContent);

            // Get webpage details from user
            System.out.println("\nEnter the URL for the webpage:");
            String url = scanner.nextLine();
            System.out.println("Enter the content for the webpage:");
            String webContent = scanner.nextLine();
            WebPage webpage = new WebPage(url, webContent);

            while (true) {
                System.out.println("\nWhat would you like to search?");
                System.out.println("1. Search in Document");
                System.out.println("2. Search in Webpage");
                System.out.println("3. Exit");
                System.out.print("Enter your choice (1-3): ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 3) {
                    System.out.println("Goodbye!");
                    break;
                }

                System.out.print("Enter the keyword to search: ");
                String keyword = scanner.nextLine();

                switch (choice) {
                    case 1 ->
                        System.out.println("Searching for '" + keyword + "' in document: " + doc.search(keyword));
                    case 2 ->
                        System.out.println("Searching for '" + keyword + "' in webpage: " + webpage.search(keyword));
                    default ->
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }
}
