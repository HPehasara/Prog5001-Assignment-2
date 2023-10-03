import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Student here.
 *
 * @author (Homila Pehasara Thevarapperuma)
 * @version (a version number or a date)
 */

public class Student {
    private String lastName;
    private String firstName;
    private String studentID;
    private Double assign1;
    private Double assign2;
    private Double assign3;
    private Double totalMarks;
    public Student(String lastName, String firstName, double totalMarks) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.totalMarks = totalMarks;
    }
    
     public String getlastName() {
        return lastName;
    }

    public String getfirstName() {
        return firstName;
    }
    
    public String getstudentID() {
        return studentID;
    }

    public double gettotalMarks() {
        return totalMarks;
    }
    
    public double getassign1() {
        return assign1;
    }
    
    public double getassign2() {
        return assign1;
    }
    
    public double getassign3() {
        return assign1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("                                **********Greetings, Have A Nice Day!**********");
        System.out.println("                                **********Student Assessment Calculation Portal**********");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Student Information & Total Marks");
            System.out.println("2. Student Marks Less Than A Threshold");
            System.out.println("3. Student Highest & Lowest Marks");
            System.out.println("4. Exit System");
            System.out.print("Please Enter Your Desired Menu: ");

            int choice = input.nextInt();
            input.nextLine(); // Move to newline
            //List<Student> allStudents = readStudentsData(fName);
            List<Student> students = new ArrayList<>();
            switch (choice) {
                case 1:
                    System.out.println("Successfully Logged In");
                    System.out.print("Please Enter Required File Name To Proceed: ");
                    String fName = input.nextLine();
                    printStudentData(fName);
                    break;
                case 2:
                    System.out.println("Successfully Logged In");
                    System.out.print("Please Enter The Threshold To Proceed: ");
                    double th = input.nextDouble();
                    input.nextLine(); // Move to newline
                    studentMarksThreshold(th);
                    break;
                case 3:
                    System.out.println("Successfully Logged In");
                    System.out.print("Please Enter Required File Name To Proceed: ");
                    String hL = input.nextLine();
                    printStudentHighestAndLowest(hL);
                        break;          
                case 4:
                    System.out.println("Please Wait...Exiting System. Have A Great Day!");
                    System.exit(0);
                default:
                    System.out.println("Incorrect Selection. Please enter 1, 2, 3 or 4");
            }
        }
    }
               /**
                 * Below code shows how the lines are separated using commas as the delimeter &
                 * checks whether there are sufficient data to proceed & display the student information
                 * along with the assignment marks total.
                 */
    public static void printStudentData(String fName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 6) {
                    String lastName = values[0];
                    String firstName = values[1];
                    String studentID = values[2];
                    double assign1 = Double.parseDouble(values[3]);
                    double assign2 = Double.parseDouble(values[4]);
                    double assign3 = Double.parseDouble(values[5]);
                    double totalMarks = assign1 + assign2 + assign3;
                    /**
                     * Process & display student data
                     */
                    System.out.println("\nStudent Results:");
                    System.out.println("Last Name: " + lastName);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Student ID: " + studentID);
                    System.out.println("Assignment 1: " + assign1);
                    System.out.println("Assignment 2: " + assign2);
                    System.out.println("Assignment 3: " + assign3);
                    System.out.println("Total Score: " + totalMarks);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
               /**
                 * Below code shows how the system checks the student marks after reading the CSV '
                 * file for certain threshold.
                 */
    public static void studentMarksThreshold(double th) {
        try (BufferedReader br = new BufferedReader(new FileReader("prog5001_students_grade_2022.csv"))) {
            String line;
            System.out.println("\nPlease Enter , Total Marks Below " + th + ":");
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 6) {
                    String lastName = values[0];
                    String firstName = values[1];
                    String studentID = values[2];
                    double assign1 = Double.parseDouble(values[3]);
                    double assign2 = Double.parseDouble(values[4]);
                    double assign3 = Double.parseDouble(values[5]);

                    double totalMarks = assign1 + assign2 + assign3;

                    if (totalMarks < th) {
                        System.out.println("Last Name: " + lastName);
                        System.out.println("First Name: " + firstName);
                        System.out.println("Student ID: " + studentID);
                        System.out.println("Total Score: " + totalMarks);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
}   
public static void printStudentHighestAndLowest(String hL) {
    String highestMarks = null;
    double highestMark = Double.MIN_VALUE;
    String lowestMarks = null;
    double lowestMark = Double.MAX_VALUE;
    try (BufferedReader br = new BufferedReader(new FileReader(hL))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length >= 6) {
                String lastName = values[0];
                String firstName = values[1];
                String studentID = values[2];
                double assign1 = Double.parseDouble(values[3]);
                double assign2 = Double.parseDouble(values[4]);
                double assign3 = Double.parseDouble(values[5]);
                double totalMarks = assign1 + assign2 + assign3;
                
                /**
                 * Process & display student data
                 */
                System.out.println("\nStudent Results:");
                System.out.println("Last Name: " + lastName);
                System.out.println("First Name: " + firstName);
                System.out.println("Student ID: " + studentID);
                System.out.println("Assignment 1: " + assign1);
                System.out.println("Assignment 2: " + assign2);
                System.out.println("Assignment 3: " + assign3);
                System.out.println("Total Score: " + totalMarks);
                // Check for highest mark in student list
                if (totalMarks > highestMark) {
                    highestMark = totalMarks;
                    highestMarks = firstName + " " + lastName + " = " + totalMarks;
                }
                // Checks for lowest mark in student list
                if (totalMarks < lowestMark) {
                    lowestMark = totalMarks;
                    lowestMarks = firstName + " " + lastName + " = " + totalMarks;
                }
            }
        }
        // Print the name & marks of the highest student marks and lowest student marks
        if (highestMarks != null) {
            System.out.println("\nHighest Student Score: " + highestMarks);
        }
        if (lowestMarks != null) {
            System.out.println("Lowest Student Score: " + lowestMarks);
        }
    } catch (IOException | NumberFormatException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}         