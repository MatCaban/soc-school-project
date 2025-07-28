package com.github.matcaban.school.school;

public class Grade {
    private final static int BEST_GRADE = 1;
    private final static int WORST_GRADE = 5;
    private double grade;

    public Grade(double grade) {
        this.setGrade(grade);
    }

    public double getGrade() {
        return grade;
    }

    void setGrade(double grade) {
        if (grade < BEST_GRADE || grade > WORST_GRADE) {
            throw new RuntimeException("Grade must be between " + BEST_GRADE + " and " + WORST_GRADE);
        } else {
            this.grade = grade;
        }
    }
}
