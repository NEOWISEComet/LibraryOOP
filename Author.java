class Author extends Person {
    private String authorId;
    private String authorStatus;

    public Author(String firstName, String lastName, String authorStatus, int age) {
        super(firstName, lastName, age);
        this.authorStatus = authorStatus;
    }

    public String getAuthorStatus() {
        return authorStatus;
    }

    public void setAuthorStatus(String authorStatus) {
        this.authorStatus = authorStatus;
    }
    public String getAuthorID(){
        return authorId;
    }
    public void setAuthorID(String authorID){
        this.authorId = authorID;
    }
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "\tauthorId: " + authorId +
                "\tauthorStatus: " + authorStatus + " --";
    }
    
}