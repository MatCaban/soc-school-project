## Project from learning site Street Of Code
Project focused on composition and on using stream API

### Assingment: 
School consists of these entities:

    Classes - group of students
    Teachers
    Students
    Subjects
    Grades

Relationships between entities (Rules):

    Every class has one primary teacher (it’s just a role) and multiple students
    Teacher can teach multiple subjects
    Student can take multiple subjects
    Student must be member of exactly one class
    Every subject has exactly one teacher
    Student must have a grade in each subject. (Grades are between 1 and 5)
Statistical data:

    Print sorted students by their average grades
    Print sorted subjects by average of grades given to students
    Print sorted classes with the best students (by average of each student’s average grade)

#### I decided to handle the composition in this project as follows. The SchoolClass contains list of Student objects, Student class contains a list of Subject objects, and the Subject class contains a list of Grade objects.

#### To maintain the relationships between the entities, I created a ClassManagementService class. This service ensures that each class has only one homeroom teacher and that each student is enrolled in only one class. (A single teacher cannot be the homeroom teacher for multiple classes, and a single class cannot have multiple homeroom teachers. Similarly, a single student cannot be enrolled in multiple classes.)

#### In the Main class, I created a list of StudentClass objects. Using this list and the Stream API, I printed the statistical data required by the assignment.
