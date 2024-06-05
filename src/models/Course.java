package models;

public class Course {
    private int id;
    private String name;
    private String category;
    private String teacherName; // Changed to teacherName to match the view logic


    public Course() {}

    public Course(int id, String name, String category, String teacherName) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.teacherName = teacherName;

    }

    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


}
