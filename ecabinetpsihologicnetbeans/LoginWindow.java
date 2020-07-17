/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ARKAN01D
 */
public class LoginWindow extends Frame {

    private final Label titlu = new Label("eCabinetPsihologic");
    private final Label user = new Label("Username");
    private final Label password = new Label("Password");
    private TextField usr = new TextField("");
    private TextField pwd = new TextField("");
    private final Button btn = new Button("Log In");
    private Panel p1 = new Panel();

    public LoginWindow(String title) throws HeadlessException {
        super(title);
        
        titlu.setFont(Utils.fnt24);
        pwd.setEchoChar('*');
        setBounds(0, 0, 300, 240);
        setResizable(false);
        p1.add(titlu);
        this.add(p1, BorderLayout.NORTH);
        user.setFont(Utils.fnt20);
        password.setFont(Utils.fnt20);
        btn.setFont(Utils.fnt20);
        usr.setFont(Utils.fnt22);
        pwd.setFont(Utils.fnt22);
        p1 = new Panel();
        p1.setLayout(new GridLayout(2, 2, 5, 10));
        p1.add(user);
        p1.add(usr);
        p1.add(password);
        p1.add(pwd);
        this.add(p1, BorderLayout.CENTER);
        p1 = new Panel();        
        p1.add(btn);
        this.add(p1, BorderLayout.SOUTH);
        pack();
        btn.addActionListener((ActionEvent e) -> {
            try {
                //Utils.DeserializationLogin(usr.getText(), pwd.getText())
                //Utils.DeserializationLogin("PopMit7", "PopMit6")
                if (Utils.DeserializationLogin(usr.getText(), pwd.getText())) {
                    Utils.GetPacients();
                    Utils.GetAppointments();
                    Utils.GetTherapies();
                    Utils.AccesMainWindow(usr.getText());
                    Utils.UpcomingAppointments();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
