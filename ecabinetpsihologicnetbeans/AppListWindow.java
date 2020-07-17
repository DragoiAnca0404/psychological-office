/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.awt.*;

/**
 *
 * @author ARKAN01D
 */
public class AppListWindow extends Frame {
    public  static AppListWindow last;
    private final Panel pnl;
    private Label lbl=new Label("Nicio programare in sistem.");

    public AppListWindow(String title) throws HeadlessException {
        super(title);
        setVisible(true);
        setLocation(50,50);
        lbl.setFont(Utils.fnt18);
        if (Utils.app.isEmpty()) {
            pnl=new Panel();
            pnl.add(lbl);
        } else {
            pnl = new Panel(new GridLayout(Utils.app.size(), 1, 10, 10));
            for (String i : Utils.app) {
                lbl = new Label(i);
                lbl.setFont(Utils.fnt18);
                pnl.add(lbl);
            }
        }
        this.add(pnl, BorderLayout.CENTER);
        setResizable(false);
        pack();
    }
}
