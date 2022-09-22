/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tstulate file, choose Tools | Tstulates
 * and open the tstulate in the editor.
 */
package dbwithstudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author prosf
 */
public class DBWithStudent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String derbyClientDriver = "org.apache.derby.jdbc.ClientDriver";
        Class.forName(derbyClientDriver);

        String url = "jdbc:derby://localhost:1527/student";
        String user = "app";
        String passwd = "app";

        Connection con = DriverManager.getConnection(url, user, passwd);

        Statement stmt = con.createStatement();
        Student stu1 = new Student(1, "Porapipat", 3.14);
        Student stu2 = new Student(2, "Kaenput", 3.32);
        Student stu3 = new Student(3, "Sarun", 2.80);
        Student stu4 = new Student(4, "Kruskal", 1.22);
//        insertStudent(stmt, stu1);
//        insertStudent(stmt, stu2);
//        insertStudent(stmt, stu3);
//        insertStudent(stmt, stu4);

//        updateStudentGPA(stmt,stu3);
//        updateStudentName(stmt,stu3);

        deleteStudent(stmt,stu1);
        deleteStudent(stmt,stu2);
        deleteStudent(stmt,stu3);
        deleteStudent(stmt,stu4);

        

        stmt.close();
        con.close();

    }

    public static void printAllStudent(ArrayList<Student> student) {
        for (Student stu : student) {
            System.out.print(stu.getId() + " ");
            System.out.print(stu.getName() + " ");
            System.out.println(stu.getGpa() + " ");
        }
    }

    public static void insertStudent(Statement stmt, Student stu) throws SQLException {

        String sql = "insert into student (id, name, gpa)"
                + " values (" + stu.getId() + "," + "'" + stu.getName() + "'" + "," + stu.getGpa() + ")";
        int result = stmt.executeUpdate(sql);
        System.out.println("Insert " + result + " row");
    }

    public static void deleteStudent(Statement stmt, Student stu) throws SQLException {
        String sql = "delete from student where id = " + stu.getId();
        int result = stmt.executeUpdate(sql);

        System.out.println("delete " + result + " row");
    }

    public static void updateStudentGPA(Statement stmt, Student stu) throws SQLException {
        String sql = "update student set gpa  = " + stu.getGpa()
                + " where id = " + stu.getId();
        int result = stmt.executeUpdate(sql);

        System.out.println("update " + result + " row");
    }

    public static void updateStudentName(Statement stmt, Student stu) throws SQLException {
        String sql = "update student set name  = '" + stu.getName() + "'"
                + " where id = " + stu.getId();
        int result = stmt.executeUpdate(sql);

        System.out.println("update " + result + " row");
    }
}
