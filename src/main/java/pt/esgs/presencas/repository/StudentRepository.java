package pt.esgs.presencas.repository;

import pt.esgs.presencas.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StudentRepository {

    private final List<Student> studentList;

    public StudentRepository(){
        studentList = new ArrayList<>();
        studentList.add(Student.of(59239, "Filipe Silva"));
        studentList.add(Student.of(59232, "Joaquim Silva"));
        studentList.add(Student.of(59233, "Manel Silva"));
        studentList.add(Student.of(59234, "Tiago Silva"));
    }

    public List<Student> findAll(){
        return Collections.unmodifiableList(studentList);
    }
}
