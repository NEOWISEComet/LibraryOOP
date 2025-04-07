class Author{
    private String authorId;
    private String authorStatus;
    private String firstName;
    private String lastName;
    private int age;

    public Author(String firstName, String lastName, String authorStatus, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.authorId = firstName + lastName + age;
        this.authorStatus = authorStatus;
    }

    public String getAuthorID(){
        return authorId;
    }
    public void setAuthorID(String authorID){
        this.authorId = authorID;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    @Override
    public String toString() {
        return "Author Details:\n" +
               "Name: " + getFullName() + "\n" +
               "Author ID: " + authorId + "\n" +
               "Status: " + authorStatus + "\n" +
               "Age: " + age;
    }

}