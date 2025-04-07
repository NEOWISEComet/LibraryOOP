import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String isbn;    /* International Standard Book Number (ISBN) */
    private int publicationYear;
    private String publisher;
    private String genre;
    private List<String> authors; /* List of author of a book .... */
    private Library library;

    public Book(String title, String isbn, int publicationYear, String publisher, String genre, String authorID, Library library) {
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.genre = genre;
        this.authors = new ArrayList<>();
        this.authors.add(authorID);
        this.library = library;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /* Author Functions */
    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }
    public void addAuthor(String authorID) {
        if (authorID != null) {
            authors.add(authorID);
        }
    }
    public void removeAuthor(String authorID) {
        authors.remove(authorID);
    }
    public List<String> getAuthorNames(Library library) {
        return library.getAuthorNames(authors);
    }

    @Override
    public String toString() {

        List<String> authorNames = library.getAuthorNames(authors);

        return "Book Details:\n" +
               "Title: " + title + "\n" +
               "ISBN: " + isbn + "\n" +
               "Publication Year: " + publicationYear + "\n" +
               "Publisher: " + publisher + "\n" +
               "Genre: " + genre + "\n" +
               "Authors: " + String.join(", ", authorNames) + "\n";
    }
    
}
