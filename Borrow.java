import java.time.LocalDate;

class Borrow{
    private int borrowID;
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private BorrowStatus borrowStatus;
    private int penalty;
    private int studentID;

    public Borrow(int borrowID, String isbn, LocalDate borrowDate, LocalDate returnDate, LocalDate dueDate, BorrowStatus borrowStatus, int penalty, int studentID) {
        this.borrowID = borrowID;
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
        this.borrowStatus = borrowStatus;
        this.penalty = penalty;
        this.studentID = studentID;
    }
    public enum BorrowStatus {
        BORROWED,
        RETURNED
    }
    public int getBorrowID() {
        return borrowID;
    }
    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        if (dueDate != null && borrowDate.isAfter(dueDate)) {
            throw new IllegalArgumentException("Borrow date Invalid");
        }
        this.borrowDate = borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        if (borrowDate != null && returnDate.isBefore(borrowDate)) {
            throw new IllegalArgumentException("Invalid return Date");
        }
        this.returnDate = returnDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public BorrowStatus getBorrowStatus() {
        return borrowStatus;
    }
    public void setBorrowStatus(BorrowStatus borrowStatus) {
        this.borrowStatus = borrowStatus;
    }
    public int getPenalty() {
        return penalty;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}