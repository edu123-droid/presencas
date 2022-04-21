package pt.esgs.presencas.service;

import pt.esgs.presencas.model.Student;
import pt.esgts.brunojesus.attendancereport.model.Attendance;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ConsoleService {

    public List<Attendance> createAttendanceList(List<Student> studentList){


        return studentList.stream().map(student -> new Attendance()
                .setNumber(student.getId())
                .setName(student.getName())
                .setPresent(askPresence(student.getName()))
        ).collect(Collectors.toList());
    }



    private static boolean askPresence(String name){
        final Scanner scanner = new Scanner(System.in);

        System.out.print(name + ":");
        String value = scanner.nextLine();

        return value.equals("y");

    }
}
