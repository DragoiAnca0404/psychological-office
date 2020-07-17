/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.io.Serializable;
import java.time.*;
import java.util.Date;

/**
 *
 * @author ARKAN01D
 */
public class Appointment implements Serializable {
    private static final long serialVersionUID =123456789;
    private final User psiholog;
    private final Pacient patient;
    private final Date appTime;
    private final String tipProg;

    public Appointment(User psiholog, Pacient patient, Date appTime, String tipProg) {
        this.psiholog = psiholog;
        this.patient = patient;
        this.appTime = appTime;
        this.tipProg = tipProg;
    }

    public User getPsiholog() {
        return psiholog;
    }

    public Pacient getPatient() {
        return patient;
    }

    public Date getAppTime() {
        return appTime;
    }

    public String getTipProg() {
        return tipProg;
    }

    @Override
    public String toString() {
LocalDate localDate = appTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
int year  = localDate.getYear();
int month = localDate.getMonthValue();
int day   = localDate.getDayOfMonth();
        return "Data:" + day+"-"+month+"-"+year + " psiholog:" + psiholog.getNume()+" "+psiholog.getPrenume() + ", pacient:" + patient.getNume() +" "+patient.getPrenume()+", tipul programarii:" + tipProg +'.';
    }
    
}
