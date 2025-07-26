package com.github.matcaban.school;

import com.github.matcaban.school.members.Student;
import com.github.matcaban.school.members.Teacher;
import com.github.matcaban.school.school.SchoolClass;

public class Main {
    public static void main(String[] args) {
        SchoolClass prima = new SchoolClass("prima");
        SchoolClass sekunda = new SchoolClass("sekunda");
        Teacher babic = new Teacher("Babic", prima);
        Teacher vancova = new Teacher("Vancova", prima);
        Student jano = new Student("jano", prima);

        System.out.println(prima.getStudents());
        System.out.println(prima.getPrimaryTeacher());
        System.out.println(babic.getSchoolClass());


    }
}
