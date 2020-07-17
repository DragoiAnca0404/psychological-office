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
public class User implements Serializable{
    private static final long serialVersionUID =314159265;
    private final String user, password,nume,prenume,rol;

    public User(String user, String password, String nume, String prenume, String rol) {
        this.user = user;
        this.password = password;
        this.nume = nume;
        this.prenume = prenume;
        this.rol = rol;
    }

   
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean equals(User obj) {
        return (this.user.equals(obj.user) && this.password.equals(obj.password));
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getRol() {
        return rol;
    }

}
