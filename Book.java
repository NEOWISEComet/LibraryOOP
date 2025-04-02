import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String isbn;    /* International Standard Book Number (ISBN) */
    private int publicationYear;
    private String publisher;
    private String genre;
    private List<Author> authors; /* List of author of a book, ie: New Book = .... */

    public Book(String title, String isbn, int publicationYear, String publisher, String genre, String authors) {
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.genre = genre;
        this.authors = new ArrayList<>();
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
    public List<Author> getAuthors() {
        return new ArrayList<>(authors);
    }
    public void addAuthor(Author author) {
        if (author != null) {
            authors.add(author);
        }
    }
    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    @Override
    public String toString() {
        StringBuilder bookDetails = new StringBuilder("Title: " + title +
                "\nISBN: " + isbn +
                "\nPublication Year: " + publicationYear +
                "\nPublisher: " + publisher +
                "\nGenre: " + genre +
                "\nAuthors: ");
        if (authors.isEmpty()) {
            bookDetails.append("No Authors");
        } else {
            for (Author author : authors) {
                bookDetails.append("\n").append(author.toString());
            }
        }
        return bookDetails.toString();
    }
}
