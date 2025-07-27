package com.github.matcaban.school;

import com.github.matcaban.school.members.Student;
import com.github.matcaban.school.members.Teacher;
import com.github.matcaban.school.school.SchoolClass;
import com.github.matcaban.school.school.Subject;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<SchoolClass> school = new ArrayList<>();

        Teacher babic = new Teacher("babic");
        Teacher kobzova = new Teacher("kobzova");
        Teacher smrecan = new Teacher("smrecan");

        SchoolClass prima = new SchoolClass("prima", babic);
        SchoolClass sekunda = new SchoolClass("sekunda", kobzova);

        Subject math = new Subject("math", kobzova);
        Subject biology = new Subject("biology", babic);
        Subject history = new Subject("history", babic);
        Subject germanLanguage = new Subject("german language", smrecan);
        Subject chemistry = new Subject("chemistry", smrecan);
        Subject physics = new Subject("physics", kobzova);

        Student peter = new Student("peter");
        Student eva = new Student("eva");
        Student anna = new Student("anna");
        Student jozef = new Student("jozef");
        Student jan = new Student("jan");
        Student emma = new Student("emma");

        prima.addStudent(peter);
        prima.addStudent(eva);
        prima.addStudent(anna);
        sekunda.addStudent(jozef);
        sekunda.addStudent(jan);
        sekunda.addStudent(emma);

        school.add(prima);
        school.add(sekunda);

        for (int i = 0; i < 9; i++) {
            if (i < 3) {
                peter.addSubjectAndGrade(math, setRandomGrade());
                eva.addSubjectAndGrade(germanLanguage, setRandomGrade());
                anna.addSubjectAndGrade(physics, setRandomGrade());
                jozef.addSubjectAndGrade(history, setRandomGrade());
                jan.addSubjectAndGrade(biology, setRandomGrade());
                emma.addSubjectAndGrade(germanLanguage, setRandomGrade());
            } else if (i < 6) {
                peter.addSubjectAndGrade(biology, setRandomGrade());
                eva.addSubjectAndGrade(chemistry, setRandomGrade());
                anna.addSubjectAndGrade(chemistry, setRandomGrade());
                jozef.addSubjectAndGrade(math, setRandomGrade());
                jan.addSubjectAndGrade(physics, setRandomGrade());
                emma.addSubjectAndGrade(history, setRandomGrade());
            } else {
                peter.addSubjectAndGrade(history, setRandomGrade());
                eva.addSubjectAndGrade(math, setRandomGrade());
                anna.addSubjectAndGrade(germanLanguage, setRandomGrade());
                jozef.addSubjectAndGrade(physics, setRandomGrade());
                jan.addSubjectAndGrade(math, setRandomGrade());
                emma.addSubjectAndGrade(chemistry, setRandomGrade());
            }
        }

        System.out.println("Sorted students by their average grades: ");
        school.stream()
                .flatMap(schoolClass -> schoolClass.getStudentsList().stream())
                .sorted(Comparator.comparing(Student::averageGradeOfStudent))
                .forEach(s -> System.out.printf(
                        "%s - %.2f\n", s.getName(), s.averageGradeOfStudent()
                ));


        Map<Subject, Double> subjectAverage = new HashMap<>();
        subjectAverage.put(math, averageOfSubject("math", school));
        subjectAverage.put(biology, averageOfSubject("biology", school));
        subjectAverage.put(history, averageOfSubject("history", school));
        subjectAverage.put(germanLanguage, averageOfSubject("german language", school));
        subjectAverage.put(chemistry, averageOfSubject("chemistry", school));
        subjectAverage.put(physics, averageOfSubject("physics", school));

        System.out.println("\nSorted subjects by average of grades given to students:");

        subjectAverage.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e ->
                        System.out.printf("%s - %.2f\n", e.getKey(), e.getValue()));

        school.stream()
                .flatMap(schoolClass -> schoolClass.getStudentsList().stream())
                .flatMap(student -> student.getSubjectsList().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.averagingDouble(Subject::getAverageGrade)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.printf("%s - %.2f\n", e.getKey(), e.getValue()));


        System.out.println("\nSorted classes with the best students: ");

        school.stream()
                .sorted(Comparator.comparing(SchoolClass::averageGradeOfClass))
                .forEach(schoolClass ->
                        System.out.printf("%s - %.2f\n", schoolClass.getName(), schoolClass.averageGradeOfClass()));

    }

    public static double setRandomGrade() {
        return (new Random().nextDouble() * 4) + 1;
    }

    public static double averageOfSubject(String subjectName, List<SchoolClass> schoolClasses) {

        return schoolClasses.stream()
                .flatMap(schoolClass -> schoolClass.getStudentsList().stream())
                .map(Student::getSubjectsList)
                .flatMap(subjects -> subjects.stream()
                        .filter(subject -> subject.getName().equals(subjectName)))
                .mapToDouble(Subject::getAverageGrade)
                .average()
                .orElse(0);

    }
}
