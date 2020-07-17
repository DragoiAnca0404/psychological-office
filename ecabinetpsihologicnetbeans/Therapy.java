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
public class Therapy implements Serializable{
    private final String name;
    private final int price;
    private static final long serialVersionUID=22222222;

    public Therapy(String name, int price) {
        this.name = name;
        this.price = price;
    }
    

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ", pret: " + price+" RON/sedinta.";
    }
    
}
