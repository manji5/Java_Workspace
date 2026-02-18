import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("----- Welcome to Account Manager -----");
        int choice;

        while (true) {
            try {
                System.out.print("\n1 - Create a new employee\n2 - Exit\nEnter the choice: ");

                choice = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please only use numerical entry!");
                input.nextLine();
            }
        }
        switch (choice) {
            case 1:
                boolean employeeMenu = true;

                while (employeeMenu) {
                    System.out.print("First Name: ");
                    String firstName = input.next();

                    System.out.print("Last Name: ");
                    String lastName = input.next();

                    Email employee = new Email(firstName, lastName);
                    System.out.println("Employee is created.");

                    while (employeeMenu) {
                        int choice1;
                        while (true) {
                            try {
                                System.out.print(
                                        "\n1 - Show Department" +
                                                "\n2 - Show Company Email" +
                                                "\n3 - Show Password" +
                                                "\n4 - Alternate Mail" +
                                                "\n5 - Mailbox Capacity" +
                                                "\n6 - Show info" +
                                                "\n0 - Exit" +
                                                "\nWhat do you do with this employee: ");
                                choice1 = input.nextInt();
                                break;
                            } catch (Exception e) {
                                System.out.println("Please only use numerical entry!");
                                input.nextLine();
                            }
                        }

                        switch (choice1) {
                            case 1:
                                System.out.println("Employee department is: " + employee.getDepartment());
                                break;

                            case 2:
                                System.out.println("Company Email: " + employee.getEmail());
                                break;

                            case 3:
                                System.out.println("Company Email Password: " + employee.getPassword());
                                break;

                            case 4:
                                int choice2;

                                while (true) {
                                    try {
                                        System.out.print(
                                                "\n1 - Add a alternate mail\n2 - Show alternate mail\n0 - Return to employee menu\nWhat do you want to do: ");
                                        choice2 = input.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Please only use numerical entry!");
                                        input.nextLine();
                                    }
                                }

                                if (choice2 == 1) {
                                    System.out.print("Alternate Mail: ");
                                    String alternateMail = input.next();
                                    employee.setAlternateEmail(alternateMail);

                                    System.out.println(
                                            "Alternate mail is added. Alternate Mail: " + employee.getAlternateEmail());
                                    break;
                                } else if (choice2 == 2) {
                                    System.out.println("Alternate Mail: " + employee.getAlternateEmail());
                                    break;
                                } else {
                                    System.out.println("Returning to employee menu...");
                                    break;
                                }

                            case 5:
                                int choice3;

                                while (true) {

                                    try {
                                        System.out.print(
                                                "\n1 - Set Mailbox Capacity\n2 - Show Mailbox Capacity\n0 - Return to employee menu\nWhat do you want to do: ");

                                        choice3 = input.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Please only use numerical entry!");
                                        input.nextLine();
                                    }
                                }

                                if (choice3 == 1) {
                                    int mailboxCapacity;

                                    while (true) {
                                        try {
                                            System.out.print("\nMailbox Capacity: ");
                                            mailboxCapacity = input.nextInt();
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Please only use numerical entry!");
                                            input.nextLine();
                                        }
                                    }

                                    employee.setMailboxCapacity(mailboxCapacity);

                                    System.out.println(
                                            "Mailbox capacity is changed. New Capacity: "
                                                    + employee.getMailboxCapacity());
                                    break;
                                } else if (choice3 == 2) {
                                    System.out.println("Mailbox Capacity: " + employee.getMailboxCapacity());
                                    break;
                                } else {
                                    System.out.println("Returning to employee menu...");
                                    break;
                                }

                            case 6:
                                System.out.println(employee.showInfo());
                                break;

                            case 0:
                                System.out.println("Exiting...");
                                employeeMenu = false;
                                break;

                            default:
                                System.out.println("Please enter a valid number!");
                                break;
                        }
                    }
                }

            case 2:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Please enter a valid number!");
                break;
        }
    }
}