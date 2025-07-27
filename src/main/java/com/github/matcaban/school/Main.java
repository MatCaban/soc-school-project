package com.github.matcaban.school;

import com.github.matcaban.school.members.Student;
import com.github.matcaban.school.members.Teacher;
import com.github.matcaban.school.school.SchoolClass;
import com.github.matcaban.school.school.Subject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        SchoolClass prima = new SchoolClass("prima");
        SchoolClass sekunda = new SchoolClass("sekunda");

        Teacher babic = new Teacher("babic");
        Teacher kobzova = new Teacher("kobzova");
        Teacher smrecan = new Teacher("smrecan");

        Subject math = new Subject("math", kobzova);
        Subject biology = new Subject("biology", babic);
        Subject history = new Subject("history", babic);
        Subject germanLanguage = new Subject("german language", smrecan);
        Subject chemistry = new Subject("chemistry", smrecan);
        Subject physics = new Subject("physics", kobzova);

        Student peter = new Student("peter", prima);
        Student eva = new Student("eva", prima);
        Student anna = new Student("anna", prima);
        Student jozef = new Student("jozef", sekunda);
        Student jan = new Student("jan", sekunda);
        Student emma = new Student("emma", sekunda);

        for (int i = 0; i < 9; i++) {
            if (i < 3) {
                peter.setSubjects(math, setRandomGrade());
                eva.setSubjects(germanLanguage, setRandomGrade());
                anna.setSubjects(physics, setRandomGrade());
                jozef.setSubjects(history,setRandomGrade());
                jan.setSubjects(biology, setRandomGrade());
                emma.setSubjects(germanLanguage, setRandomGrade());
            } else if (i < 6) {
                peter.setSubjects(biology, setRandomGrade());
                eva.setSubjects(chemistry, setRandomGrade());
                anna.setSubjects(chemistry, setRandomGrade());
                jozef.setSubjects(math,setRandomGrade());
                jan.setSubjects(physics, setRandomGrade());
                emma.setSubjects(history, setRandomGrade());
            } else {
                peter.setSubjects(history, setRandomGrade());
                eva.setSubjects(math, setRandomGrade());
                anna.setSubjects(germanLanguage, setRandomGrade());
                jozef.setSubjects(physics,setRandomGrade());
                jan.setSubjects(math, setRandomGrade());
                emma.setSubjects(chemistry, setRandomGrade());
            }
        }

//        peter.setSubjects(math, setRandomGrade());
//        peter.setSubjects(math, setRandomGrade());
//        peter.setSubjects(math, setRandomGrade());
//        peter.setSubjects(biology, setRandomGrade());
//        peter.setSubjects(biology, setRandomGrade());
//        peter.setSubjects(biology, setRandomGrade());
//        peter.setSubjects(history, setRandomGrade());
//        peter.setSubjects(history, setRandomGrade());
//        peter.setSubjects(history, setRandomGrade());
//
//        eva.setSubjects(germanLanguage, setRandomGrade());
//        eva.setSubjects(germanLanguage, setRandomGrade());
//        eva.setSubjects(chemistry, setRandomGrade());
//        eva.setSubjects(chemistry, setRandomGrade());
//        eva.setSubjects(chemistry, setRandomGrade());
//        eva.setSubjects(math, setRandomGrade());
//        eva.setSubjects(math, setRandomGrade());
//        eva.setSubjects(math, setRandomGrade());
//        eva.setSubjects(germanLanguage, setRandomGrade());
//
//        anna.setSubjects(physics, setRandomGrade());
//        anna.setSubjects(physics, setRandomGrade());
//        anna.setSubjects(physics, setRandomGrade());
//        anna.setSubjects(chemistry, setRandomGrade());
//        anna.setSubjects(chemistry, setRandomGrade());
//        anna.setSubjects(chemistry, setRandomGrade());
//        anna.setSubjects(germanLanguage, setRandomGrade());
//        anna.setSubjects(germanLanguage, setRandomGrade());
//        anna.setSubjects(germanLanguage, setRandomGrade());
//
//        jozef.setSubjects(history, setRandomGrade());
//        jozef.setSubjects(history, setRandomGrade());
//        jozef.setSubjects(history, setRandomGrade());
//        jozef.setSubjects(math, setRandomGrade());
//        jozef.setSubjects(math, setRandomGrade());
//        jozef.setSubjects(math, setRandomGrade());
//        jozef.setSubjects(physics, setRandomGrade());
//        jozef.setSubjects(physics, setRandomGrade());
//        jozef.setSubjects(physics, setRandomGrade());
//
//        jan.setSubjects(biology, setRandomGrade());
//        jan.setSubjects(biology, setRandomGrade());
//        jan.setSubjects(biology, setRandomGrade());
//        jan.setSubjects(chemistry, setRandomGrade());
//        jan.setSubjects(chemistry, setRandomGrade());
//        jan.setSubjects(chemistry, setRandomGrade());
//        jan.setSubjects(physics, 3);
//        jan.setSubjects(physics, 2);
//        jan.setSubjects(physics, 2);
//
//        emma.setSubjects(germanLanguage, 3);
//        emma.setSubjects(germanLanguage, 2);
//        emma.setSubjects(germanLanguage, 2);
//        emma.setSubjects(history, 2);
//        emma.setSubjects(history, 4);
//        emma.setSubjects(history, 3);
//        emma.setSubjects(math, 2);
//        emma.setSubjects(math, 1.5);
//        emma.setSubjects(math, 2);

//        schoolMembers.add(babic);
//        schoolMembers.add(kobzova);
//        schoolMembers.add(smrecan);
        students.add(peter);
        students.add(eva);
        students.add(anna);
        students.add(jozef);
        students.add(jan);
        students.add(emma);

        System.out.println("Sorted students by their average grades: ");
        students.stream()
                .sorted(Comparator.comparing(Student::getAverageGradePerStudent))
                .forEach(s -> System.out.printf(
                        "%s - %.2f\n",s.getName(), s.getAverageGradePerStudent()
                ));


        students.forEach(s -> System.out.println(s.getAverageGradePerSubject()));


        emma.addSubjectAndGrade(math, 3);
        emma.addSubjectAndGrade(math, 2);
        emma.addSubjectAndGrade(biology, 2);

        emma.getSubjectsList().forEach(s -> System.out.println(s.getGrades()));
    }

    public static double setRandomGrade(){
        return (new Random().nextDouble() * 4) + 1;
    }
}
