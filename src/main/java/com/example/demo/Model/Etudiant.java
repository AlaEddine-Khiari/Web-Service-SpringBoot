package com.example.demo.Model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "etudiants")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "cin")
    private String cin;

    @Column(name = "date_naissance")
    private String dateNaissance;

    @Column(name = "classe")
    private String classe;

    // Constructors, getters, setters,... done by lombok
}
