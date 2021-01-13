/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.text.*;
import java.util.Date;
import java.util.logging.*;
import javax.swing.JOptionPane;

public class AppointmentWindow extends Frame {

    private final Button btn = new Button("Creeaza Programare");
    private final Label lbl1 = new Label("Selectati un pacient:");
    private final Choice cp = new Choice();
    private final Label lbl2 = new Label("Selectati tipul terapiei:");
    private final Choice ct = new Choice();
    private final Label lbl3 = new Label("Introd. data ZZ-LL-AAAA:");
    private final TextField txt = new TextField();
    private Panel pnl = new Panel();

    public void BuildChoices() {
        for (Pacient i : Utils.pacienti) {
            cp.add(i.toString());
        }
        for (Therapy i : Utils.terapii) {
            ct.add(i.getName());
        }
    }

    public AppointmentWindow(String title) throws HeadlessException {
        super(title);
        setVisible(true);
        setBounds(0, 0, 600, 200);
        BuildChoices();
        lbl1.setFont(Utils.fnt18);
        lbl2.setFont(Utils.fnt18);
        lbl3.setFont(Utils.fnt18);
        btn.setFont(Utils.fnt18);
        cp.setFont(Utils.fnt18);
        ct.setFont(Utils.fnt18);
        txt.setFont(Utils.fnt30);
        pnl.setLayout(new GridLayout(3, 2, 10, 10));
        pnl.add(lbl1);
        pnl.add(cp);
        pnl.add(lbl2);
        pnl.add(ct);
        pnl.add(lbl3);
        pnl.add(txt);
        this.add(pnl, BorderLayout.CENTER);
        pnl = new Panel();
        btn.addActionListener((ActionEvent e) -> {
            try {
                String fileName = "src\\ecabinetpsihologicnetbeans\\Files\\CAppointments";
                FileWriter fw = new FileWriter(fileName, true);
                PrintWriter pw = new PrintWriter(fw);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date data = new Date();
                data = formatter.parse(txt.getText());
                Pacient p = Pacient.FindMe(cp.getSelectedItem());
                Appointment app = new Appointment(Utils.userLogged, p, data, ct.getSelectedItem());
                if(!Utils.app.contains(app.toString())){
                Utils.app.add(app.toString());
                pw.print(app + "\n");
                pw.close();
                JOptionPane.showMessageDialog(null,"Programare creata cu succes.");
                Utils.UpcomingAppointments();
                }else{
                    JOptionPane.showMessageDialog(null, "Progamarea exista deja in sistem.");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Data introdusa este invalida.");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AppointmentWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AppointmentWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        pnl.add(btn);
        this.add(pnl, BorderLayout.SOUTH);
        setResizable(false);
        pack();
    }
}
