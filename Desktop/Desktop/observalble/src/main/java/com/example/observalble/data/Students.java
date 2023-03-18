package com.example.observalble.data;

public class Students implements Comparable<Students> {
    private String studentName;
    private double grade;

    public Students(String studentName, double grade) {
        this.studentName = studentName;
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "students{" +
                "studentName='" + studentName + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Students o) {
        if (this.grade > o.grade)
            return 1;
        return 0;
    }
}
