import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Library {
    private Inventory inventory;
    private List<Borrow> borrowRecords;
    private int fixedPenalty;

    public Library() {
        this.inventory = new Inventory();
        this.borrowRecords = new ArrayList<>();

        /* Default Amount */
        this.fixedPenalty = 10;
    }

    public void setFixedPenalty(int penalty) {
        this.fixedPenalty = penalty;
    }

    public boolean borrowBook(int borrowID, String isbn, int borrowDate, int dueDate, int studentID) {
        if (inventory.getBookQuantity(isbn) > 0) {
            inventory.removeBook(isbn, 1);

            /* Create a new Borrow record */
            /* BorrowID, bookID, Dates, Status, Penalty, Student*/
            Borrow borrow = new Borrow(borrowID, isbn, borrowDate, 0, dueDate, "Borrowed", 0, studentID);
            borrowRecords.add(borrow);

            return true;
        }
        return false;
    }

    public boolean returnBook(int borrowID, int returnDate) {
        for (Borrow borrow : borrowRecords) {
            if (borrow.getBorrowID() == borrowID && borrow.getBorrowStatus().equals("Borrowed")) {
                borrow.setReturnDate(returnDate);
                borrow.setBorrowStatus("Returned");

                /* Due Date Penalty */
                if (returnDate > borrow.getDueDate()) {
                    borrow.setPenalty(fixedPenalty);
                }

                /* Returned Book ++ */
                inventory.addBook(inventory.findBookByIsbn(borrow.getIsbn()), 1);

                return true;
            }
        }
        return false;
    }

    /* Borrowed Books List */
    public List<Borrow> getBorrowRecords() {
        return borrowRecords;
    }

    /* Inventory Functions */
    /* InvetoryAddBook means it will add the book to the invetory, not create a new one, so is the same for the others */
    public void addBookInventory(Book book, int quantity) {
        inventory.addBook(book, quantity);
    }
    public boolean removeBookInventory(String isbn, int quantity) {
        return inventory.removeBook(isbn, quantity);
    }
    public Book findBookByIsbn(String isbn) {
        return inventory.findBookByIsbn(isbn);
    }
    public int getBookQuantity(String isbn) {
        return inventory.getBookQuantity(isbn);
    }
    public Inventory getInventory() {
        return inventory;
    }

    /* Create a New Book */
    public void addNewBook(String title, String isbn, int publicationYear, String publisher, String genre, String authors) {
        Book book = new Book(title, isbn, publicationYear, publisher, genre, authors);
        inventory.addBook(book, 1);
    }
    public void removeBook(String isbn) {
        inventory.removeBook(isbn, 1);
    }
    public void updateBook(String isbn, String title, int publicationYear, String publisher, String genre) {
        Book book = inventory.findBookByIsbn(isbn);
        if (book != null) {
            book.setTitle(title);
            book.setPublicationYear(publicationYear);
            book.setPublisher(publisher);
            book.setGenre(genre);
        }
    }
    public void addAuthorToBook(String isbn, Author author) {
        Book book = inventory.findBookByIsbn(isbn);
        if (book != null) {
            book.addAuthor(author);
        }
    }
    public void removeAuthorFromBook(String isbn, Author author) {
        Book book = inventory.findBookByIsbn(isbn);
        if (book != null) {
            book.removeAuthor(author);
        }
    }
    public Map<Book, Integer> getAllBooks() {
        return inventory.getAllBooks();
    }
}