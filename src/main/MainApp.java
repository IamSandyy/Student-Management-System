package main;


import java.util.*;
import dao.StudentDAO;
import model.Student;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice = 0;

        System.out.println("========================================");
        System.out.println("     STUDENT INFORMATION SYSTEM");
        System.out.println("========================================");

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Enter Course: ");
                String course = sc.next();
                System.out.print("Enter Marks: ");
                int marks = sc.nextInt();

                Student s = new Student(name, course, marks);
                dao.addStudent(s);
                break;

            case 2:
                List<Student> list = dao.getAllStudents();
                for (Student st : list) {
                    System.out.println(st);
                }
                break;

            case 3:
                System.out.print("Enter Student ID to Update: ");
                int uid = sc.nextInt();
                System.out.print("Enter New Marks: ");
                int newMarks = sc.nextInt();
                dao.updateStudent(uid, newMarks);
                break;

            case 4:
                System.out.print("Enter Student ID to Delete: ");
                int did = sc.nextInt();
                dao.deleteStudent(did);
                break;

            case 5:
                System.out.println("Exiting... Thank you!");
                break;

            default:
                System.out.println("Invalid Choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

