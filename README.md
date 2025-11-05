# 🎓 Student Information System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-323330?style=for-the-badge&logo=databricks&logoColor=white)
![Status](https://img.shields.io/badge/Status-Active-success?style=for-the-badge)

---

## 🧾 Overview

The **Student Information System** is a **Java console-based project** that helps manage student details efficiently.  
It connects to a database using **JDBC** and allows performing all essential **CRUD (Create, Read, Update, Delete)** operations.

---

## ✨ Features

✅ **Add Student** – Insert a new student record into the database.  
👀 **View All Students** – Display all student records stored in the database.  
✏️ **Update Student Marks** – Modify marks for existing students.  
🗑️ **Delete Student** – Remove a student record.  
🚪 **Exit** – Exit the application safely.

---

## 🧰 Technologies Used

| Component | Technology |
|------------|-------------|
| 💻 Programming Language | Java |
| 🗄️ Database | MySQL |
| 🔗 Connectivity | JDBC |
| 🧠 IDE (Optional) | IntelliJ IDEA / Eclipse / VS Code |

---

## ⚙️ How to Run the Project

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/Student-Information-System.git
Open the project in your preferred Java IDE.

Create the database

sql
Copy code
CREATE DATABASE student_db;
USE student_db;

CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  course VARCHAR(50),
  marks INT
);
Update database credentials in your code:

java
Copy code
String url = "jdbc:mysql://localhost:3306/student_db";
String user = "root";
String password = "your_password";
Run the main file

Copy code
StudentManagementSystem.java
💻 Sample Output
pgsql
Copy code
========================================
STUDENT INFORMATION SYSTEM
========================================
1. Add Student
2. View All Students
3. Update Student Marks
4. Delete Student
5. Exit
Enter your choice: 2
✅ Database connected successfully!
Student [id=1, name=Santhosh, course=cse, marks=78]
🌟 Future Enhancements
🖥️ Add GUI (JavaFX / Swing)

🔍 Add search and sorting options

✅ Input validation and exception handling

📤 Export student data to CSV or Excel

🔐 User authentication (Admin / Teacher roles)
