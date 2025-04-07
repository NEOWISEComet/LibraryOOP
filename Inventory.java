import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Book, Integer> books;

    public Inventory() {
        books = new HashMap<>();
    }

    public void addBook(Book book, int quantity) {
        /* books.getOrDefault(book, 0) checks for existing books, if it exist quantity+= */
        books.put(book, books.getOrDefault(book, 0) + quantity);
    }

    public void removeBook(String isbn, int quantity) {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            if (entry.getKey().getIsbn().equals(isbn)) {
                int currentQuantity = entry.getValue();
                if (currentQuantity >= quantity) {
                    books.put(entry.getKey(), currentQuantity - quantity);
                    if (books.get(entry.getKey()) == 0) {
                        books.remove(entry.getKey());
                    }
                }
                break;
            }
        }
        return;
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books.keySet()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public int getBookQuantity(String isbn) {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            if (entry.getKey().getIsbn().equals(isbn)) {
                return entry.getValue();
            }
        }
        return 0;
    }

    public Map<Book, Integer> getAllBooks() {
        return new HashMap<>(books);
    }

    @Override
    public String toString() {
        StringBuilder inventoryDetails = new StringBuilder("Inventory:\n");
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            inventoryDetails.append(entry.getKey().toString())
                            .append("\nQuantity: ").append(entry.getValue()).append("\n");
        }
        return inventoryDetails.toString();
    }

}