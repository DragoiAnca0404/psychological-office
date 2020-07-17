/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ARKAN01D
 */
public class CancelWindow extends Frame{
    
    private Panel pnl=new Panel();
    private final Label lbl=new Label("Selectati Programarea");
    private Choice ch=new Choice();
    private final Button btn=new Button("Anuleaza Programarea");
    private void BuildChoice() throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader("src\\ecabinetpsihologicnetbeans\\Files\\CAppointments"));
        while(br.ready()){
        ch.add(br.readLine());
        }
    }
    public CancelWindow() throws HeadlessException, FileNotFoundException, IOException, ClassNotFoundException {
    setTitle("Anulati o programare");
    
    Utils.GetAppointments();
    BuildChoice();
    lbl.setFont(Utils.fnt18);
    ch.setFont(Utils.fnt18);
    btn.setFont(Utils.fnt18);
    pnl.add(lbl);
    pnl.add(ch);
    this.add(pnl,BorderLayout.CENTER);
    pnl=new Panel();
    pnl.add(btn);
    btn.addActionListener((ActionEvent e) -> {
        try{
            if(!Utils.app.isEmpty()){
                Utils.app.remove(ch.getSelectedItem());
                PrintWriter pw=new PrintWriter(new FileWriter("src\\ecabinetpsihologicnetbeans\\Files\\CAppointments"));
                for(String i:Utils.app){
                    pw.write(i);
                }
                pw.close();
                ch.removeAll();
                for(String i:Utils.app){
                    ch.add(i);
                }
                JOptionPane.showMessageDialog(null,"Programare eliminata cu succes.");
                Utils.UpcomingAppointments();
            }else{
                JOptionPane.showMessageDialog(null," Nicio programare in sistem.Nu se poate elimina nimic.");
            }
        } catch (IOException ex) {
            Logger.getLogger(CancelWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    this.add(pnl,BorderLayout.SOUTH);
    setVisible(true);
    setResizable(false);
    pack();
    }
    
    
}
