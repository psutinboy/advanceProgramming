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
        return url.toLowerCase().contains(keyword.toLowerCase()) ||
               pageContent.toLowerCase().contains(keyword.toLowerCase());
    }
}

public class SearchDemo {
    public static void main(String[] args) {
        // Create a document instance
        Document doc = new Document("This is a sample document containing some text about Java programming.");
        
        // Create a webpage instance
        WebPage webpage = new WebPage(
            "https://www.example.com/java-tutorial",
            "Welcome to the Java Programming Tutorial page. Learn Java here!"
        );

        // Test searching in document
        String keyword1 = "Java";
        System.out.println("Searching for '" + keyword1 + "' in document: " + doc.search(keyword1));
        
        // Test searching in webpage
        String keyword2 = "tutorial";
        System.out.println("Searching for '" + keyword2 + "' in webpage: " + webpage.search(keyword2));
        
        // Test searching with a keyword that doesn't exist
        String keyword3 = "python";
        System.out.println("Searching for '" + keyword3 + "' in document: " + doc.search(keyword3));
        System.out.println("Searching for '" + keyword3 + "' in webpage: " + webpage.search(keyword3));
    }
} 