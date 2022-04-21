package pt.esgs.presencas;

import pt.esgs.presencas.model.Student;
import pt.esgs.presencas.repository.StudentRepository;
import pt.esgs.presencas.service.ConsoleService;
import pt.esgts.brunojesus.attendancereport.PresenceReportFacade;
import pt.esgts.brunojesus.attendancereport.actions.Report;
import pt.esgts.brunojesus.attendancereport.model.Attendance;
import pt.esgts.brunojesus.attendancereport.model.ReportData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        final StudentRepository studentRepository = new StudentRepository();
        final List<Student> studentList = studentRepository.findAll();
        final ConsoleService consoleService = new ConsoleService();

        final ReportData reportData = new ReportData();
        reportData.setAcademicYear(2021);
        reportData.setAttendances(new ArrayList<>());
        reportData.setDate(LocalDate.now());
        reportData.setClassName("Engenharia");
        reportData.setCourseName("TPSI");
        reportData.setAttendances(consoleService.createAttendanceList(studentList));

        final PresenceReportFacade presenceReportFacade = new PresenceReportFacade();

        final Report report = presenceReportFacade.compileReport(reportData);
        presenceReportFacade.viewReport(report);

    }

}
