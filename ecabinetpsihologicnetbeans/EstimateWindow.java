/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


class EstimateWindow extends Frame{
    private final int MIN_PROG=1;
    private final int MAX_PROG=30;
    private final Label lbl1=new Label("Selectati terapia:");
    private final Label lbl2=new Label("Selectati numarul de sedinte:");
    private final Choice ch=new Choice();
    private Panel pnl=new Panel();
    private final Choice ch2=new Choice();
    private final Button btn=new Button("Calculeaza Cost");
    private void buildChoice(){
        for(Therapy i:Utils.terapii){
            ch.add(i.toString());
        }
        for(int i=MIN_PROG;i<=MAX_PROG;i++){
            ch2.add(String.valueOf(i));
        }
    }
    public EstimateWindow() throws HeadlessException {
    setTitle("Estimeaza Costuri");
    pnl.setLayout(new GridLayout(2,2,1,1));
    btn.setFont(Utils.fnt18);
    lbl1.setFont(Utils.fnt18);
    ch.setFont(Utils.fnt18);
    lbl2.setFont(Utils.fnt18);
    ch2.setFont(Utils.fnt18);
    pnl.add(lbl1);
    pnl.add(ch);
    pnl.add(lbl2);
    pnl.add(ch2);
    this.add(pnl,BorderLayout.CENTER);
    pnl=new Panel();
    pnl.add(btn);
    btn.addActionListener((ActionEvent e) -> {
        String s=ch.getSelectedItem();
        String [] s1=new String[10];
        s1=ch.getSelectedItem().split(" ");
        int nr=Integer.parseInt(ch2.getSelectedItem());
        int nr2=Integer.parseInt(s1[s1.length-2]);
JOptionPane.showMessageDialog(null,"Pretul este de: "+nr*nr2+" RON.");
    });
    this.add(pnl,BorderLayout.SOUTH);
    buildChoice();
    setVisible(true);
    setResizable(false);
    pack();
    }
    
}
