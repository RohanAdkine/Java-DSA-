import java.util.*;

public class BankManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        
        System.out.println("Welcome to the Bank Management System");
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Customer Login");
            System.out.println("2. Employee Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bank.customerLogin();
                    break;
                case 2:
                    bank.employeeLogin();
                    break;
                case 3:
                    bank.adminLogin();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Bank Management System.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}

class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private Admin admin = new Admin("Kunal", "kunal123");

    public Bank() {
        customers.add(new Customer("Rohan", "Rohan123", 1000000));
        customers.add(new Customer("Aditya", "Aditya123", 500000));
        employees.add(new Employee("emp1", "emp123", "Manager"));
    }

    // Customer login
    public void customerLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Customer customer = findCustomer(username, password);
        if (customer != null) {
            customerMenu(customer);
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    // Employee login
    public void employeeLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Employee employee = findEmployee(username, password);
        if (employee != null) {
            System.out.println("Welcome, " + employee.getName());
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    // Admin login
    public void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println("Welcome, Admin.");
            boolean exit = false;
            while (!exit) {
                System.out.println("\n1. View All Accounts");
                System.out.println("2. Add Employee");
                System.out.println("3. Add Customer");
                System.out.println("4. Update Admin Details");
                System.out.println("5. Exit");
                System.out.print("Select an option: ");
                
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        viewAllAccounts();
                        break;
                    case 2:
                        addEmployee();
                        break;
                    case 3:
                        addCustomer();
                        break;
                    case 4:
                        updateAdminDetails();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    private Customer findCustomer(String username, String password) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    private Employee findEmployee(String username, String password) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return employee;
            }
        }
        return null;
    }

    // Menu for the customer actions
    private void customerMenu(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. View Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your current balance: " + customer.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    customer.deposit(depositAmount);
                    System.out.println("Deposit successful! New balance: " + customer.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (customer.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful! New balance: " + customer.getBalance());
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Admin viewing all accounts
    public void viewAllAccounts() {
        System.out.println("\nCustomer Accounts:");
        for (Customer customer : customers) {
            System.out.println("Username: " + customer.getUsername() + ", Balance: " + customer.getBalance());
        }
    }

    // Method for admin to add employees
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee username: ");
        String username = scanner.nextLine();
        System.out.print("Enter employee password: ");
        String password = scanner.nextLine();
        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();

        employees.add(new Employee(username, password, position));
        System.out.println("Employee added successfully!");
    }

    // Method for admin to add customers
    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer username: ");
        String username = scanner.nextLine();
        System.out.print("Enter customer password: ");
        String password = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        customers.add(new Customer(username, password, balance));
        System.out.println("Customer added successfully!");
    }

    // Method for admin to update admin details
    public void updateAdminDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new admin username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter new admin password: ");
        String newPassword = scanner.nextLine();

        admin.setUsername(newUsername);
        admin.setPassword(newPassword);
        System.out.println("Admin details updated successfully!");
    }
}

// Customer class to handle customer details and operations
class Customer {
    private String username;
    private String password;
    private double balance;

    public Customer(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money, only if sufficient balance is available
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Employee class to handle employee details
class Employee {
    private String username;
    private String password;
    private String position;

    public Employee(String username, String password, String position) {
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return username;
    }
}

// Admin class to handle admin details
class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
