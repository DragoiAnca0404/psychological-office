/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecabinetpsihologicnetbeans;

import java.io.Serializable;

/**
 *
 * @author ARKAN01D
 */
public class Pacient implements Serializable {

    private static final long serialVersionUID = 55555555;
    private final String nume, prenume;
    private final int varsta;

    public Pacient(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public static Pacient FindMe(String a) {
        String[] aux = a.split(" ");
        for (Pacient i : Utils.pacienti) {
            if (i.equals(new Pacient(aux[0],aux[1],-1))) {
                return i;
            }
        }
        return null;
    }

    public boolean equals(Pacient obj) {
        return this.nume.equals(obj.nume)&&this.prenume.equals(obj.prenume);
    }

    @Override
    public String toString() {
        return nume + " " + prenume + " ," + varsta + " ani.";
    }

}
