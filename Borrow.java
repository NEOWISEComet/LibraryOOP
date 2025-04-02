class Borrow{
    private int borrowID;
    private String isbn;
    private int borrowDate;
    private int returnDate;
    private int dueDate;
    private String borrowStatus;
    private int penalty;

    public Borrow(int borrowID, String isbn, int borrowDate, int returnDate, int dueDate, String borrowStatus, int penalty, int studentID) {
        this.borrowID = borrowID;
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
        this.borrowStatus = borrowStatus;
        this.penalty = penalty;
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
    public int getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(int borrowDate) {
        this.borrowDate = borrowDate;
    }
    public int getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(int returnDate) {
        this.returnDate = returnDate;
    }
    public int getDueDate() {
        return dueDate;
    }
    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }
    public String getBorrowStatus() {
        return borrowStatus;
    }
    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }
    public int getPenalty() {
        return penalty;
    }
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}