import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "company.com";

    Scanner input = new Scanner(System.in);

    // Constructor to receive the first and last name
    public Email(String firstname, String lastName) {
        this.firstName = firstname;
        this.lastName = lastName;

        // Call a method asking for the department
        this.department = setDepartment();

        // Call a method returns a random password
        this.password = randomPassword(defaultPasswordLength);

        // Combine Elements to generate email
        email = firstname.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "."
                + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print(
                "DEPARTMENT CODES\n1 - Sales\n2 - Development\n3 - Accounting\n0 - None\nEnter the department code: ");
        int depChoice = input.nextInt();

        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    public String getDepartment() {
        return department;
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuWwXxYyZz1234567890!@#$%&.";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getEmail() {
        return email;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // Show info
    public String showInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}