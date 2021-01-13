/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindow extends Frame {

    private final Button b1, b2, b3, b4;
    private Panel pnl;

    public MainWindow(String title, String user) throws HeadlessException {
        super(title);
        setVisible(true);
        setBounds(500, 250, 650, 300);
        setResizable(false);
        //setUndecorated(true);
        pnl = new Panel();
        Label lbl = new Label("Bun venit, " + Utils.userLogged.getNume() + " " + Utils.userLogged.getPrenume());
        lbl.setFont(Utils.fnt30);
        pnl.add(lbl);
        this.add(pnl, BorderLayout.NORTH);
        pnl = new Panel();
        pnl.setLayout(new GridLayout(2, 2, 40, 40));
        b1 = new Button("Realizeaza Programare");
        b2 = new Button("Estimeaza Cost");
        b3 = new Button("Anuleaza Programare");
        b4 = new Button("Redacteaza Aviz");
        b1.setFont(Utils.fnt24);
        b2.setFont(Utils.fnt24);
        b3.setFont(Utils.fnt24);
        b4.setFont(Utils.fnt24);
        pnl.add(b1);
        pnl.add(b2);
        pnl.add(b3);
        pnl.add(b4);
        AscultatorButoane ab = new AscultatorButoane();
        b1.addActionListener(ab);
        b2.addActionListener(ab);
        b3.addActionListener(ab);
        b4.addActionListener(ab);
        this.add(pnl, BorderLayout.CENTER);
        pack();
    }

    public class AscultatorButoane implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Realizeaza Programare":
                    AppointmentWindow aw = new AppointmentWindow("Realizeaza o programare");
                    aw.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            //System.exit(0);
                            Utils.app.clear();
                            aw.setVisible(false);
                        }
                    });
                    break;
                case "Estimeaza Cost":
                    Utils.Estimate();
                    break;
                case "Anuleaza Programare":
            {
                try {
                    Utils.Cancel();
                } catch (HeadlessException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case "Redacteaza Aviz":
            {
                try {
                    Utils.RedactionWindow();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
            }
        }

    }
}
