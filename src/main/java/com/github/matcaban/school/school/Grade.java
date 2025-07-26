package com.github.matcaban.school.school;

public class Grade {
    private static final int BEST_GRADE = 1;
    private static final int WORST_GRADE = 5;
    private int grade;

    public Grade(int grade) {
        this.setGrade(grade);
    }

    public void setGrade(int grade) {
        if (grade < BEST_GRADE || grade > WORST_GRADE) {
            throw new RuntimeException("Grade must be between " + BEST_GRADE + " and " + WORST_GRADE);
        } else {
            this.grade = grade;
        }
    }
}
