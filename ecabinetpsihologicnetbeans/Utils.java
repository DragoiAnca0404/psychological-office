/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Utils {
    public static final Font fnt30 = new Font("TimesRoman", Font.ITALIC, 30);
    public static final Font fnt24 = new Font("TimesRoman", Font.ITALIC, 24);
    public static final Font fnt22= new Font("TimesRoman", Font.PLAIN, 22);
    public static final Font fnt20 = new Font("TimesRoman", Font.ITALIC, 20);
    public static final Font fnt18 = new Font("TimesRoman", Font.ITALIC, 18);
    public static User userLogged;
    public static ArrayList<Pacient> pacienti = new ArrayList();
    public static ArrayList<Therapy> terapii = new ArrayList();
    public static Set<String> app = new TreeSet();

    public static void GetAppointments() throws FileNotFoundException, IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("src\\ecabinetpsihologicnetbeans\\Files\\CAppointments"));
        String str;
        while ((str = br.readLine()) != null && str.length() != 0) {
            app.add(str);
        }
    }

    public static void GetTherapies() throws FileNotFoundException, IOException, ClassNotFoundException {
        if (terapii.isEmpty()) {
            FileInputStream fis = new FileInputStream("src\\ecabinetpsihologicnetbeans\\Files\\Therapies");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Therapy aux = (Therapy) ois.readObject();
                Utils.terapii.add(aux);
            }
        }
    }

    public static boolean DeserializationLogin(String usr, String pwd) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src\\ecabinetpsihologicnetbeans\\Files\\Users");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User usrAux;
        while (fis.available() > 0) {
            usrAux = (User) ois.readObject();
            if (usrAux.equals(new User(usr, pwd, "", "", ""))) {
                Utils.userLogged = usrAux;
                return true;
            }
        }
        return false;
    }

    public static void GetPacients() throws IOException, ClassNotFoundException {
        if (pacienti.isEmpty()) {
            FileInputStream fis = new FileInputStream("src\\ecabinetpsihologicnetbeans\\Files\\Patients");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Pacient aux = (Pacient) ois.readObject();
                Utils.pacienti.add(aux);
            }
        }
    }

    public static void AccesMainWindow(String user) {
        MainWindow f1 = new MainWindow("Cabinet Psihologic", user);
        f1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f1.setVisible(false);
            }
        });

    }

    public static void UpcomingAppointments() {

        AppListWindow ap = new AppListWindow("Urmatoarele programari");
        if (AppListWindow.last == null) {
            AppListWindow.last = ap;
        } else {
            AppListWindow.last.setVisible(false);
            AppListWindow.last = ap;
        }
    }

    public static void RedactionWindow() throws IOException {
        AvizWindow avz = new AvizWindow();
        avz.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                avz.setVisible(false);
            }
        });
    }

    public static void Cancel() throws HeadlessException, IOException, FileNotFoundException, ClassNotFoundException {
        CancelWindow cw = new CancelWindow();
        cw.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cw.setVisible(false);
            }
        });
    }

    static void Estimate() {
        EstimateWindow ew=new EstimateWindow();
        ew.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e ){
            ew.dispose();
        }
        });
    }

}
