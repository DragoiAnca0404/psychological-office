/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author ARKAN01D
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        LoginWindow w = new LoginWindow("Cabinet Psihologic");
        w.setVisible(true);
        w.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
//        FileOutputStream fos=new FileOutputStream("Users");
//        ObjectOutputStream ous=new ObjectOutputStream(fos);
//        Utils.ous.writeObject(new User("PopMit7", "PopMit6", "Popescu", "Mitrut", "Asistent"));
//        Utils.ous.writeObject(new User("IonAnd7", "IonAnd7", "Ionescu", "Andreea", "Psiholog"));
//        Utils.ous.writeObject(new User("MitDan6", "MitDan6", "Mitrea", "Daniel", "Asistent"));
//        Utils.ous.writeObject(new User("VoiDan6", "VoiDan8", "Voinea", "Daniela", "Psiholog"));
//        Utils.ous.writeObject(new User("CioIoa7", "CioIoa5", "Ciobanu", "Ioana", "Asistent"));

//        FileOutputStream fos = new FileOutputStream("Patients");
//        ObjectOutputStream ous = new ObjectOutputStream(fos);
//        ous.writeObject(new Pacient("Popa", "Dumitru", 25));
//        ous.writeObject(new Pacient("Manole", "Radu", 37));
//        ous.writeObject(new Pacient("Ciutacu", "Victor", 45));
//        ous.writeObject(new Pacient("Stoica", "Andrei", 55));
//        ous.writeObject(new Pacient("Stan", "Andrei", 22));

//        FileOutputStream fos = new FileOutputStream("src\\ecabinetpsihologicnetbeans\\Files\\Appointments",true);
//        ObjectOutputStream ous = new ObjectOutputStream(fos);
//        ous.writeObject(new Appointment(new User("", "", "Popescu", "Mitrut", "Asistent"), new Pacient("Popa", "Dumitru", 25), new Date(2019,12,2019), "Psihoterapie"));
//        ous.writeObject(new Appointment(new User("", "", "Ionescu", "Andreea", "Psiholog"), new Pacient("Stan", "Andrei", 22), new Date(2019,12,2019), "Terapia prin muzica"));
//        ous.writeObject(new Appointment(new User("", "", "Mitrea", "Daniel", "Asistent"), new Pacient("Stoica", "Andrei", 55), new Date(2019,12,2019), "Unde Intracraniene"));
//        ous.writeObject(new Appointment(new User("", "", "Voinea", "Daniela", "Psiholog"), new Pacient("Manole", "Radu", 37), new Date(2019,12,2019), "Deficit de Atentie"));
//        ous.writeObject(new Appointment(new User("", "", "Ciobanu", "Ioana", "Asistent"), new Pacient("Ciutacu", "Victor", 45), new Date(2019,12,2019), "ADHD"));


//        FileOutputStream fis = new FileOutputStream("src\\ecabinetpsihologicnetbeans\\Files\\Therapies");
//        ObjectOutputStream ous = new ObjectOutputStream(fis);
//        ous.writeObject(new Therapy("Psihoterapie",50));
//        ous.writeObject(new Therapy("Terapia Prin Muzica",80));
//        ous.writeObject(new Therapy("Terapie Unde Intracraniene",120));
//        ous.writeObject(new Therapy("Terapie Deficit de Atentie",150));
//        ous.writeObject(new Therapy("ADHD",200));
    }
}
