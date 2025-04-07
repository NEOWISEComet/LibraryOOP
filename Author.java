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
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
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