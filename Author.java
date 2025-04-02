class Author extends Person {
    private String authorId;
    private String authorStatus;

    public Author(String firstName, String lastName, String authorId, String authorStatus, int age) {
        super(firstName, lastName, age);
        this.authorId = authorId;
        this.authorStatus = authorStatus;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorStatus() {
        return authorStatus;
    }

    public void setAuthorStatus(String authorStatus) {
        this.authorStatus = authorStatus;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "\tauthorId: " + authorId +
                "\tauthorStatus: " + authorStatus + " --";
    }
    
}