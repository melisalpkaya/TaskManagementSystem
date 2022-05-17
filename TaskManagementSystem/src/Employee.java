public class Employee {
    private int EmployeeID;
    private String Name;
    private String Surname;
    private String Email;
    private String Password;
    private String PhoneNumber;
    private Character Gender;
    private String Department;
    private String JobTitle;

    Employee() {

    }

    public Employee(int employeeID) {
        EmployeeID = employeeID;
    }

    public Employee(String email, String password) {
        Email = email;
        Password = password;
    }

    public Employee(int employeeID, String name, String surname, String email, String password, String department, String jobTitle) {
        EmployeeID = employeeID;
        Name = name;
        Surname = surname;
        Email = email;
        Password = password;
        Department = department;
        JobTitle = jobTitle;
    }

    public Employee(int employeeID, String name, String surname, String email, String password, String phoneNumber, Character gender, String department, String jobTitle) {
        EmployeeID = employeeID;
        Name = name;
        Surname = surname;
        Email = email;
        Password = password;
        PhoneNumber = phoneNumber;
        Gender = gender;
        Department = department;
        JobTitle = jobTitle;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Character getGender() {
        return Gender;
    }

    public void setGender(Character gender) {
        Gender = gender;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {

            case "EmployeeID:":
                return EmployeeID;
            case "Name:":
                return Name;
            case "Surname":
                return Surname;
            case "Email":
                return Email;
            case "Password":
                return Password;
            case "PhoneNumber":
                return PhoneNumber;
            case "Gender":
                return Gender;
            case "Department":
                return Department;
            case "JobTitle":
                return JobTitle;
            default:
                return null;
        }
    }
    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + EmployeeID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Gender=" + Gender +
                ", Department='" + Department + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                '}';
    }
}
