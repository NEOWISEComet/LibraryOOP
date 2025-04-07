import java.time.LocalDate;
import java.util.List;
import java.util.Map;

class Librarian extends Person {
    private String employeeId;
    private String email;
    private String address;
    private int phoneNumber;
    private Library library;

    public Librarian(Library library, String firstName, String lastName, String email, String address, int phoneNumber, String employeeId, int age) {
        super(firstName, lastName, age);
        this.employeeId = employeeId;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.library = library;
    }

    // Add a new author to the library
    public void addAuthor(String firstName, String lastName, String authorStatus, int age, String authorID) {
        Author author = new Author(firstName, lastName, authorStatus, age);
        author.setAuthorID(authorID);
        library.addNewAuthor(author);
    }

    // Add a new book to the library
    public void addBook(String title, String isbn, int publicationYear, String publisher, String genre, String authorID, int quantity) {
        library.addNewBook(title, isbn, publicationYear, publisher, genre, authorID);
        library.addBookInventory(library.findBookByIsbn(isbn), quantity);
    }

    // Borrow a book
    public void borrowBook(int borrowID, String isbn, LocalDate borrowDate, LocalDate dueDate, int studentID) {
        library.borrowBook(borrowID, isbn, borrowDate, dueDate, studentID);
    }

    // Return a book
    public void returnBook(int borrowID, LocalDate returnDate) {
        library.returnBook(borrowID, returnDate);
    }

    // Add an author to an existing book
    public void addAuthorToBook(String isbn, String authorID) {
        library.addAuthorToBook(isbn, authorID);
    }

    // Remove an author from an existing book
    public void removeAuthorFromBook(String isbn, String authorID) {
        library.removeAuthorFromBook(isbn, authorID);
    }

    // Update book details
    public void updateBook(String isbn, String title, int publicationYear, String publisher, String genre) {
        library.updateBook(isbn, title, publicationYear, publisher, genre);
    }

    // Get all books in the library
    public Map<Book, Integer> getAllBooks() {
        return library.getAllBooks();
    }

    // Get all borrow records
    public List<Borrow> getBorrowRecords() {
        return library.getBorrowRecords();
    }

    // Get author names for a book
    public List<String> getAuthorNamesForBook(String isbn) {
        Book book = library.findBookByIsbn(isbn);
        if (book != null) {
            return book.getAuthorNames(library);
        }
        throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist.");
    }

    public Map<String, Author> getAllAuthors() {
        return library.getAuthors();
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nemployeeId: " + employeeId +
                "\naddress: " + address +
                "\nemail: " + email +
                "\nphoneNumber: " + phoneNumber + "\t --";
    }
}