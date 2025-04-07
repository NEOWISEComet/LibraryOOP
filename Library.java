import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final int DEFAULT_PENALTY = 10; /* Default Penalty */
    private Inventory inventory;
    private List<Borrow> borrowRecords;
    private int fixedPenalty;
    private HashMap<String, Author> authorLists;

    public Library() {
        this.inventory = new Inventory();
        this.borrowRecords = new ArrayList<>();
        authorLists = new HashMap<>();
        /* Default Amount */
        this.fixedPenalty = DEFAULT_PENALTY;
    }

    public void addNewAuthor(Author author){
        authorLists.put(author.getAuthorID(), author);
    }
    public Map<String, Author> getAuthors() { /* Lists of authors */
    return Collections.unmodifiableMap(authorLists);
    }  
    public boolean checkAuthor(String authorID) {  /*checks if author exists in HashMap*/
        return authorLists.containsKey(authorID);
    }
    public List<String> getAuthorNames(List<String> authorIDs) {
        List<String> authorNames = new ArrayList<>();
        for (String authorID : authorIDs) {
            Author author = authorLists.get(authorID);
            if (author != null) {
                authorNames.add(author.getFullName());
            } else {
                authorNames.add("Unknown Author (ID: " + authorID + ")");
            }
        }
        return authorNames;
    }


    public void setFixedPenalty(int penalty) {
        this.fixedPenalty = penalty;
    }

    public void borrowBook(int borrowID, String isbn, LocalDate borrowDate, LocalDate dueDate, int studentID) {
        if (inventory.getBookQuantity(isbn) > 0) {
            inventory.removeBook(isbn, 1);

            /* Create a new Borrow record */
            /* BorrowID, bookID, Dates, Status, Penalty, Student*/
            Borrow borrow = new Borrow(borrowID, isbn, borrowDate, null, dueDate, Borrow.BorrowStatus.BORROWED, 0, studentID);
            borrowRecords.add(borrow);
        } else {
            throw new IllegalArgumentException("ISBN " + isbn + " is not available.");
        }
        
    }

    public void returnBook(int borrowID, LocalDate returnDate) {
        for (Borrow borrow : borrowRecords) {
            if (borrow.getBorrowID() == borrowID && borrow.getBorrowStatus() == Borrow.BorrowStatus.BORROWED) {
                borrow.setReturnDate(returnDate);
                borrow.setBorrowStatus(Borrow.BorrowStatus.RETURNED);

                /* Due Date Penalty */
                if (returnDate.isAfter(borrow.getDueDate())) {
                    borrow.setPenalty(fixedPenalty);
                }

                /* Returned Book ++ */
                inventory.addBook(inventory.findBookByIsbn(borrow.getIsbn()), 1);
                return;
            }
        }
        throw new IllegalArgumentException("Borrow ID " + borrowID + " not found or already returned.");
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
    public void removeBookInventory(String isbn, int quantity) {
        inventory.removeBook(isbn, quantity);
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
    public void addNewBook(String title, String isbn, int publicationYear, String publisher, String genre, String authorID) {
        if (inventory.findBookByIsbn(isbn) != null) {
            throw new IllegalArgumentException("ISBN " + isbn + " already exists.");
        }
        if (!checkAuthor(authorID)) {
            throw new IllegalArgumentException("AuthorID " + authorID + " does not exist.");
        }
        Book book = new Book(title, isbn, publicationYear, publisher, genre, authorID);
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
        } else {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist.");
        }
    }

    public void addAuthorToBook(String isbn, String authorID) {
        if (!checkAuthor(authorID)) {
            throw new IllegalArgumentException("AuthorID " + authorID + " does not exist.");
        }
        Book book = inventory.findBookByIsbn(isbn);
        if (book != null) {
            book.addAuthor(authorID);
        } else {
            throw new IllegalArgumentException("ISBN " + isbn + " does not exist.");
        }
    }
    public void removeAuthorFromBook(String isbn, String authorID) {
        if (!checkAuthor(authorID)) {
            throw new IllegalArgumentException("AuthorID " + authorID + " does not exist.");
        }
        Book book = inventory.findBookByIsbn(isbn);
        if (book != null) {
            book.removeAuthor(authorID);
        }
    }

    public Map<Book, Integer> getAllBooks() {
        return inventory.getAllBooks();
    }
}