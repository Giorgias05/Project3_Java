package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;


@Entity
@Table(name = "utenti")
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente implements Serializable {

    @Id
    @Column(nullable = false, unique = true)
    private Long tessera;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private LocalDate datadinascita;

    public Utente() {

    }

    public Utente(long tessera, String nome, String surname, LocalDate datadinascita) {
        this.setTessera(tessera);
        this.setName(nome);
        this.setSurname(surname);
        this.setDatadinascita(datadinascita);
    }

    public Long getTessera() {
        return tessera;
    }
    public void setTessera(Long tessera) {
        this.tessera = tessera;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public LocalDate getDatadinascita() {
        return datadinascita;
    }
    public void setDatadinascita(LocalDate datadinascita) {
        this.datadinascita = datadinascita;
    }
    @Override
    public String toString() {
        return "Utente [tessera=" + tessera + ", name=" + name + ", surname=" + surname + ", datadinascita="
                + datadinascita + "]";
    }
    
    
}