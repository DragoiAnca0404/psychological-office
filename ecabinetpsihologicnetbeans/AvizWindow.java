/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ARKAN01D
 */
public class AvizWindow extends Frame {
    private final int MIN_AGE=18;
    private final int MAX_AGE=99;
    private Panel pnl = new Panel();
    private final Label lbl = new Label("Nume:");
    private final Label lbl2 = new Label("Prenume:");
    private final TextField t1 = new TextField();
    private final TextField t2 = new TextField();
    private final Label type = new Label("Selectati tipul avizului:");
    private final Button btn = new Button("Salvare Aviz");
    private final Choice ch = new Choice();
    private final CheckboxGroup cg = new CheckboxGroup();
    private final Checkbox m = new Checkbox("Masculin", cg, true);
    private final Checkbox f = new Checkbox("Feminin", cg, false);
    private final Label lbl3=new Label("Varsta:");
    private final Choice chAge=new Choice();

    public AvizWindow() throws HeadlessException, FileNotFoundException, IOException {
        super("Redacteaza Aviz");
        GetChoiceData();
        setResizable(false);
        setVisible(true);
        pnl.setLayout(new GridLayout(5, 2, 10, 10));
        t1.setFont(Utils.fnt18);
        t2.setFont(Utils.fnt18);
        ch.setFont(Utils.fnt18);
        lbl.setFont(Utils.fnt18);
        lbl2.setFont(Utils.fnt18);
        lbl3.setFont(Utils.fnt18);
        chAge.setFont(Utils.fnt18);
        type.setFont(Utils.fnt18);
        btn.setFont(Utils.fnt18);
        m.setFont(Utils.fnt18);
        f.setFont(Utils.fnt18);
        pnl.add(lbl);
        pnl.add(t1);
        pnl.add(lbl2);
        pnl.add(t2);
        pnl.add(m);
        pnl.add(f);
        pnl.add(lbl3);
        BuildAge();
        pnl.add(chAge);
        pnl.add(type);
        pnl.add(ch);
        this.add(pnl, BorderLayout.CENTER);
        pnl = new Panel();
        pnl.add(btn);
        this.add(pnl, BorderLayout.SOUTH);
        btn.addActionListener((ActionEvent e) -> {
            try {
                if(Available()){
                    JOptionPane.showMessageDialog(null, "Aviz exportat cu succes.");
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
                    Document doc = new Document();
                    PdfWriter.getInstance(doc, new FileOutputStream("src\\ecabinetpsihologicnetbeans\\Files\\SAvize\\eAviz_"+formatter.format(date)+".pdf"));
                    doc.open();
                    doc.add(new Paragraph("eCabinetPsihologic"));
                    doc.add(new Paragraph(new Date().toString()));
                    Paragraph ph = new Paragraph("Aviz Psihologic",FontFactory.getFont(FontFactory.TIMES_BOLDITALIC,36));
                    ph.setAlignment(Element.ALIGN_CENTER);
                    doc.add(ph);
                    doc.add(new Paragraph(" "));
                    doc.add(new Paragraph(" "));
                    Paragraph ph1=new Paragraph("Prin prezenta se certifica faptul ca, ",FontFactory.getFont(FontFactory.TIMES_ITALIC,22));
                    ph1.add(t1.getText()+" "+t2.getText()+",");
                    ph1.add(" in varsta de "+chAge.getSelectedItem());
                    ph1.add(" ani, sexul "+cg.getSelectedCheckbox().getLabel());
                    ph1.add(", a promovat cu succes examenul psihologic,fiind ");
                    if(cg.getSelectedCheckbox().getLabel().equals("Masculin")){
                        ph1.add("evaluat");
                    }else if (cg.getSelectedCheckbox().getLabel().equals("Feminin")){
                        ph1.add("evaluata");
                    }
                    ph1.add(" de catre "+Utils.userLogged.getNume()+" "+Utils.userLogged.getPrenume());
                    ph1.add(", in calitate de "+Utils.userLogged.getRol()+".");
                    ph1.setAlignment(Element.ALIGN_CENTER);
                    doc.add(ph1);
                    Paragraph ph2=new Paragraph("Avizul se elibereaza pentru a ii sevi la: ",FontFactory.getFont(FontFactory.TIMES_ITALIC,22));
                    ph2.add(ch.getSelectedItem()+".");
                    ph2.setAlignment(Element.ALIGN_CENTER);
                    doc.add(new Paragraph(" "));
                    doc.add(ph2);
                    doc.close();
                }else{
                    JOptionPane.showMessageDialog(null, "Toate campurile trebuie completate!");
                }
            } catch (DocumentException ex) {
                //Logger.getLogger(JavaApplication14.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AvizWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        pack();
    }
    private boolean Available(){
        if(t1.getText().isEmpty()||t2.getText().isEmpty()){
            return false;
        }
        return true;
    }
    private void BuildAge(){
        for(int i=MIN_AGE;i<=MAX_AGE;i++){
            chAge.add(String.valueOf(i));
        }
    }
    private void GetChoiceData() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\ecabinetpsihologicnetbeans\\Files\\Avize"));
        while (br.ready()) {
            ch.add(br.readLine());
        }
    }
}
