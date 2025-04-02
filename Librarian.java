class Librarian extends Person {
    private String employeeId;
    private String employeeStatus;
    private String email;
    private String address;
    private int phoneNumber;

    public Librarian(String firstName, String lastName, String email, String address, int phoneNumber, String employeeId, String employeeStatus, int age) {
        super(firstName, lastName, age);
        this.employeeId = employeeId;
        this.employeeStatus = employeeStatus;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeStatus() {
        return employeeStatus;
    }
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nemployeeId: " + employeeId +
                "\nemployeeStatus: " + employeeStatus +
                "\naddress: " + address +
                "\nemail: " + email +
                "\nphoneNumber: " + phoneNumber + "\t --";
    }
}