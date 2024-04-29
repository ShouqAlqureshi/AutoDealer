import java.util.Scanner;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
public class AutoDealer {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Connection connection = null;
            String url = "jdbc:mariadb://localhost:3306/comp";
            String user = "root";
            String pwd = "";
            try {
                connection = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Successfully connected to database");

            System.out.println("Owner,\nInsurance,\nCar_OwnerEnter,\nCar_Registration,\nEmployee,\nBranch,\nCBEassociation\n  Enter table name: ");
            String tableName = scanner.nextLine(); // Get table name from user
            insert(scanner, tableName, connection);

            scanner.close();
        }

        public static void insert(Scanner scanner, String tableName, Connection connection) {
            try {
            Statement stmt = connection.createStatement();
            String query;
            ResultSet rs = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            switch (tableName) {
                case "Owner":

                    int ownerID;
                    String ownerName;
                    String address;
                    System.out.println("Owner ID:");
                    ownerID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Owner Name:");
                    ownerName = scanner.nextLine();
                    System.out.println("Address:");
                    address = scanner.nextLine();
                    // Initialize variables for each attribute in the table

                    //CHECK
                    System.out.println("Insert a new record (Y/N)?");
                    String insertChoice1 = scanner.next();
                    if (insertChoice1.equalsIgnoreCase("Y")) {
                        query = "INSERT INTO Emp VALUES("
                                +ownerID+",'"+ownerName+"',"+address+")";
                        stmt.executeUpdate(query);
                        rs = stmt.executeQuery("SELECT * FROM Owner");
                        while(rs.next()) {
                            System.out.print(rs.getInt("ownerID") + "\t");
                            System.out.print(rs.getString("ownerName") + "\t");
                            System.out.print(rs.getString("address") + "\t");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Record not inserted.");
                    }
                    break;
                case "Insurance":
                    int insuranceID;
                    String insuranceName;
                    String policyNumber;
                    System.out.println("Insurance ID:");
                    insuranceID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Insurance Name:");
                    insuranceName = scanner.nextLine();
                    System.out.println("Policy Number:");
                    policyNumber = scanner.nextLine();
                    // Initialize variables for each attribute in the table

                    //CHECK
                    System.out.println("Insert a new record (Y/N)?");
                    String insertChoice2 = scanner.next();
                    if (insertChoice2.equalsIgnoreCase("Y")) {
                        // Perform the insertion here
                         query = "INSERT INTO Emp VALUES("
                                +insuranceID+",'"+insuranceName+"',"+policyNumber+")";
                        stmt.executeUpdate(query);
                        rs = stmt.executeQuery("SELECT * FROM Insurance");
                        while(rs.next()) {
                            System.out.print(rs.getInt("insuranceID") + "\t");
                            System.out.print(rs.getString("insuranceName") + "\t");
                            System.out.print(rs.getString("policyNumber") + "\t");
                            System.out.println();
                      }
                    } else {
                        System.out.println("Record not inserted.");
                    }
                    break;
                case "Car_Owner":
                    System.out.println("car ID:");
                    int carID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Insurance ID:");
                    int CownerID = scanner.nextInt();
                    scanner.nextLine();
                    // Initialize variables for each attribute in the table
                    System.out.println("Insert a new record (Y/N)?");
                    String insertChoice3 = scanner.next();
                    if (insertChoice3.equalsIgnoreCase("Y")) {
                        query = "INSERT INTO Emp VALUES("
                                +carID+",'"+CownerID+")";
                        stmt.executeUpdate(query);
                        rs = stmt.executeQuery("SELECT * FROM Car_Owner");
                        while(rs.next()) {
                            System.out.print(rs.getInt("carID") + "\t");
                            System.out.print(rs.getInt("ownerID") + "\t");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Record not inserted.");
                    }
                    break;
                case "Car_Registration":
                    System.out.println("license Number:");
                    String licenseNumber = scanner.nextLine();
                    System.out.println("Registration Date \"yyyy-MM-dd\":");
                    try {
                        Date regDate = dateFormat.parse(scanner.nextLine());
                        System.out.println("Registration expire Date \"yyyy-MM-dd\":");
                        Date regExDate =dateFormat.parse(scanner.nextLine()) ;
                    // Initialize variables for each attribute in the table
                    System.out.println("Insert a new record (Y/N)?");
                    String insertChoice4 = scanner.next();
                    if (insertChoice4.equalsIgnoreCase("Y")) {
                        query = "INSERT INTO Emp VALUES("
                                +licenseNumber+",'"+regDate+"',"+regExDate+")";
                        stmt.executeUpdate(query);
                        rs = stmt.executeQuery("SELECT * FROM Car_Registration");
                        while(rs.next()) {
                            System.out.print(rs.getString("licenseNumber") + "\t");
                            System.out.print(rs.getDate("regDate") + "\t");
                            System.out.print(rs.getDate("regExDate") + "\t");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Record not inserted.");
                    }
                    }catch (ParseException e) {
                    System.out.println("Error parsing date: " + e.getMessage());
                    }
                    break;
                case "Employee":
                    System.out.println("Employee ID:");
                    int eid = Integer.parseInt(scanner.nextLine());
                    System.out.println("Employee Name:");
                    String eName = scanner.nextLine();
                    System.out.println("Employee phone:");
                    String ePhone= scanner.nextLine();
                    System.out.println("Employee email:");
                    String email= scanner.nextLine();
                    System.out.println("Employee date of birth \"yyyy-MM-dd\":");
                    try {
                        Date dob = dateFormat.parse(scanner.nextLine());
                    System.out.println("Employee branch ID:");
                    int ebranchID = Integer.parseInt(scanner.nextLine());
                    System.out.println("Insert a new record (Y/N)?");
                    String insertChoice5 = scanner.next();
                    if (insertChoice5.equalsIgnoreCase("Y")) {
                        query = "INSERT INTO Emp VALUES("
                                +eid+",'"+eName+"',"+ePhone+"',"+email+"',"+dob+"',"+ebranchID+")";
                        stmt.executeUpdate(query);
                        rs = stmt.executeQuery("SELECT * FROM Employee");
                        while(rs.next()) {
                            System.out.print(rs.getInt("eid") + "\t");
                            System.out.print(rs.getString("eName") + "\t");
                            System.out.print(rs.getString("ePhone") + "\t");
                            System.out.print(rs.getString("email") + "\t");
                            System.out.print(rs.getString("dob") + "\t");
                            System.out.print(rs.getString("branchID") + "\t");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Record not inserted.");
                    }
                    }catch (ParseException e) {
                        System.out.println("Error parsing dob date: " + e.getMessage());
                    }
                    break;
                case "Branch":
                    int branchID;
                    String bPhone;
                    String city;
                    String state;
                    String zip;
                    int managerID;

                    System.out.println("Branch ID:");
                    branchID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Branch Phone Number:");
                    bPhone = scanner.nextLine();
                    System.out.println("Branch City:");
                    city = scanner.nextLine();
                    System.out.println("Branch State:");
                    state = scanner.nextLine();
                    System.out.println("Branch Zip Code:");
                    zip = scanner.nextLine();
                    System.out.println("manager ID:");
                    managerID = Integer.parseInt(scanner.nextLine());
                    System.out.println("Insert a new record (Y/N)?");
                    String insertChoice6 = scanner.next();
                    if (insertChoice6.equalsIgnoreCase("Y")) {
                        // Perform the insertion here
                        query = "INSERT INTO Emp VALUES("
                                +branchID+",'"+bPhone+"',"+city+"',"+state+"',"+zip+"',"+managerID+")";
                        stmt.executeUpdate(query);
                        rs = stmt.executeQuery("SELECT * FROM Employee");
                        while(rs.next()) {
                            System.out.print(rs.getInt("branchID") + "\t");
                            System.out.print(rs.getString("bPhone") + "\t");
                            System.out.print(rs.getString("city") + "\t");
                            System.out.print(rs.getString("state") + "\t");
                            System.out.print(rs.getString("zip") + "\t");
                            System.out.print(rs.getInt("managerID") + "\t");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Record not inserted.");
                    }
                    break;
                case "CBEassociation":
                    String CBElicenseNumber;
                    int CBEbranchID;
                    int CBEeid;

                    System.out.println("License Number:");
                    CBElicenseNumber = scanner.nextLine();
                    System.out.println("Branch ID:");
                    CBEbranchID = scanner.nextInt();
                    System.out.println("Employee ID:");
                    CBEeid = scanner.nextInt();
                    // Initialize variables for each attribute in the table
                    System.out.println("Insert a new record (Y/N)?");
                    String insertChoice7 = scanner.next();
                    if (insertChoice7.equalsIgnoreCase("Y")) {
                        query = "INSERT INTO Emp VALUES('"
                                +CBElicenseNumber+"',"+CBEbranchID+","+CBEeid+")";
                        stmt.executeUpdate(query);
                        rs = stmt.executeQuery("SELECT * FROM Employee");
                        while(rs.next()) {
                            System.out.print(rs.getString("CBElicenseNumber") + "\t");
                            System.out.print(rs.getInt("CBEbranchID") + "\t");
                            System.out.print(rs.getInt("CBEeid") + "\t");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Record not inserted.");
                    }
                    break;
                default:
                    System.out.println("Invalid table name");
                    break;
            }

            stmt.close();} catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

