package dao;

import java.sql.*;
import java.util.*;
import model.Student;
import util.DBconnection;

public class StudentDAO {

    // ✅ 1. Insert new student record
    public boolean addStudent(Student s) {
        boolean isInserted = false;
        String query = "INSERT INTO students(name, course, marks) VALUES (?, ?, ?)";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, s.getName());
            pst.setString(2, s.getCourse());
            pst.setInt(3, s.getMarks());

            int rows = pst.executeUpdate();
            if (rows > 0) {
                isInserted = true;
                System.out.println("✅ Student added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error while adding student: " + e.getMessage());
        }
        return isInserted;
    }

    // ✅ 2. Fetch all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection con = DBconnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getInt("marks")
                );
                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching students: " + e.getMessage());
        }

        return list;
    }

    // ✅ 3. Get student by ID
    public Student getStudentById(int id) {
        Student s = null;
        String query = "SELECT * FROM students WHERE id=?";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getInt("marks")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching student by ID: " + e.getMessage());
        }

        return s;
    }

    // ✅ 4. Update student
    public void updateStudent(int id, int marks) {
        String sql = "UPDATE students SET marks=? WHERE id=?";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, marks);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student marks updated successfully!");
            } else {
                System.out.println("No student found with ID " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ✅ 5. Delete student
    public boolean deleteStudent(int id) {
        boolean isDeleted = false;
        String query = "DELETE FROM students WHERE id=?";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                isDeleted = true;
                System.out.println("✅ Student deleted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error while deleting student: " + e.getMessage());
        }

        return isDeleted;
    }
}

