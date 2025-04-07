import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(library, "Alice", "Johnson", "alice@example.com", "123 Library St", 1234567890, "EMP001", 30);

        // Add authors
        librarian.addAuthor("John", "Doe", "Active", 45, "A1");
        librarian.addAuthor("Jane", "Smith", "Active", 38, "A2");

        // Print all authors
        PrintAllAuthors(librarian);
        TakeLine();

        // Add books
        librarian.addBook("Java Programming", "123456789", 2025, "TechBooks", "Programming", "A1", 5);
        librarian.addBook("Python Basics", "987654321", 2023, "CodePress", "Programming", "A2", 3);

        // Print all books in the inventory
        PrintAllBooks(librarian);
        TakeLine();

        // Borrow a book
        librarian.borrowBook(1, "123456789", LocalDate.now(), LocalDate.now().plusDays(14), 101);

        // Print borrow records
        PrintAllBorrowRecords(librarian);

        // Return the book
        librarian.returnBook(1, LocalDate.now()); // Late return '.plusDays(15)' just for simulation

        TakeLine();
        // Print updated borrow records
        PrintAllBorrowRecords(librarian);

        TakeLine();
        PrintAllBooks(librarian);   
    
        TakeLine();
        // Print all authors
        PrintAllAuthors(librarian);   
    }
    private static void TakeLine(){
        System.out.println("\n--------------------------------------\n");
    }

    private static void PrintAllBooks(Librarian librarian) {
        System.out.println("Books in the inventory:");
        for (Map.Entry<Book, Integer> entry : librarian.getAllBooks().entrySet()) {
            System.out.println(entry.getKey().toString() + "Quantity: " + entry.getValue() + "\n");
        }
    }

    private static void PrintAllAuthors(Librarian librarian) {
        System.out.println("Authors:");
        for (Map.Entry<String, Author> entry : librarian.getAllAuthors().entrySet()) {
            System.out.println(entry.getValue().toString() + "\n");
        }
    }

    private static void PrintAllBorrowRecords(Librarian librarian) {
        System.out.println("Borrow Records:");
        for (Borrow borrow : librarian.getBorrowRecords()) {
            System.out.println(borrow.toString());
        }
    }

}