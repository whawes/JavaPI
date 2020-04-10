/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.time.LocalDateTime;

/**
 *
 * @author Selim Chikh Zaouali
 */
public class Permutation {
    private int id;
    private String classe_s;
    private String raison;
    private LocalDateTime date;
    private String etat;
    private int eleve_id;
    private int parent;
    
public Permutation(String classe_s,String raison, LocalDateTime date, String etat, int eleve_id, int parent) {
    this.classe_s = classe_s;
    this.raison = raison;
    this.date = date;
    this.etat = etat;
    this.eleve_id = eleve_id;
    this.parent = parent;
}

    public void setId(int id) {
        this.id = id;
    }

    public void setClasse_s(String classe_s) {
        this.classe_s = classe_s;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setEleve_id(int eleve_id) {
        this.eleve_id = eleve_id;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public String getClasse_s() {
        return classe_s;
    }

    public String getRaison() {
        return raison;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getEtat() {
        return etat;
    }

    public int getEleve_id() {
        return eleve_id;
    }

    public int getParent() {
        return parent;
    }

}
