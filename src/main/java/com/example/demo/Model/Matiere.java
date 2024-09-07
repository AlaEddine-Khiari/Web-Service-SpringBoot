package com.example.demo.Model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "matieres")
public class Matiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom_mat")
    private String nomMatiere;

    @Column(name = "semster")
    private int semester;

    @Column(name = "prof")
    private String professeur;

    @Column(name = "annee_univ")
    private String anneeUniv;


    // Constructors, getters, setters, etc. (handled by Lombok)
}
