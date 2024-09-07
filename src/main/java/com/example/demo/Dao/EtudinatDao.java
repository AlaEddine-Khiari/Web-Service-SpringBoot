package com.example.demo.Dao;


import com.example.demo.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudinatDao extends JpaRepository<Etudiant, Integer> {
}
