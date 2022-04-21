package pt.esgs.presencas.repository;

import pt.esgs.presencas.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentRepository {

    private final List<Student> studentList;

    public StudentRepository(){
        studentList = loadStudentsFile()
                .stream()
                .map(s -> s.split(","))
                .filter(s -> s.length > 1)
                .map(s -> new Student(Long.parseLong(s[0]), s[1]))
                .toList();

    }

    public List<Student> findAll(){
        return new ArrayList<>(studentList);
        //return Collections.unmodifiableList(studentList);
    }

    private List<String> loadStudentsFile(){
        List<String> result = null;

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("students.csv")) {


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );



            result = reader.lines().collect(Collectors.toList());
            //inputStream.close();
        } catch (IOException a){
            System.err.println("Failed to close file");
        }catch (NullPointerException b){
            System.err.println("Cannot open file");
            return Collections.emptyList();
        }

        return result;
    }
}
