package pt.esgs.presencas;

import pt.esgts.brunojesus.attendancereport.PresenceReportFacade;
import pt.esgts.brunojesus.attendancereport.actions.Report;
import pt.esgts.brunojesus.attendancereport.model.ReportData;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        final ReportData reportaData = new ReportData();
        reportaData.setAcademicYear(2021);
        reportaData.setAttendances(new ArrayList<>());
        reportaData.setDate(LocalDate.now());
        reportaData.setClassName("Engenharia");
        reportaData.setCourseName("TPSI");

        final PresenceReportFacade presenceReportFacade = new PresenceReportFacade();

        final Report report = presenceReportFacade.compileReport(reportaData);
        presenceReportFacade.viewReport(report);
    }
}
