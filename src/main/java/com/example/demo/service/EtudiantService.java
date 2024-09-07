package com.example.demo.service;


import com.example.demo.Dao.EtudinatDao;
import com.example.demo.Model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    EtudinatDao etudiantDao;

    public List<Etudiant> getAllEtudiants() {
        return this.etudiantDao.findAll();
    }

    public Etudiant addEtudiant(Etudiant etudiant) {
        return this.etudiantDao.save(etudiant);
    }

    public void deleteEtudiantById(int etudId) {
        this.etudiantDao.deleteById(etudId);
    }

    public Etudiant updateEtudiant(int etudId, Etudiant updatedEtudiant) {
        Etudiant etudiantToUpdate = this.etudiantDao.findById(etudId)
                .orElseThrow(() -> new RuntimeException("Etudiant not found"));
        etudiantToUpdate.setNom(updatedEtudiant.getNom());
        etudiantToUpdate.setPrenom(updatedEtudiant.getPrenom());
        etudiantToUpdate.setCin(updatedEtudiant.getCin());
        etudiantToUpdate.setDateNaissance(updatedEtudiant.getDateNaissance());
        etudiantToUpdate.setClasse(updatedEtudiant.getClasse());

        return this.etudiantDao.save(etudiantToUpdate);
    }
}


