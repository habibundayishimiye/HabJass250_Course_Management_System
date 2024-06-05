package models;

import models.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private Connection con;

    public CourseDAO() {
        con = DatabaseConnection.getConnection();
    }

    // Fetch all courses from the database
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT c.id, c.name, c.category, t.name as teacherName FROM course c JOIN Teacher t ON c.teacher_id = t.id";
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                String teacherName = rs.getString("teacherName");
                courses.add(new Course(id, name, category, teacherName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    // Fetch all teacher names from the database
    public List<String> getAllTeacherNames() {
        List<String> teachers = new ArrayList<>();
        String sql = "SELECT name FROM Teacher";
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                teachers.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    // Add a new course to the database
    public void addCourse(Course course) {
        String sql = "INSERT INTO course (name, category, teacher_id) VALUES (?, ?, (SELECT id FROM Teacher WHERE name = ?))";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, course.getName());
            pst.setString(2, course.getCategory());
            pst.setString(3, course.getTeacherName());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing course in the database
    public void updateCourse(Course course) {
        String sql = "UPDATE course SET name = ?, teacher_id = (SELECT id FROM Teacher WHERE name = ?), category = ? WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, course.getName());
            pst.setString(2, course.getCategory());
            pst.setString(3, course.getTeacherName());
            pst.setInt(4, course.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a course from the database
    public void deleteCourse(int id) {
        String sql = "DELETE FROM course WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
