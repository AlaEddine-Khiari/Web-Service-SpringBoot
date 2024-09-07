package com.example.demo.service;


import com.example.demo.Dao.MatiereDao;
import com.example.demo.Model.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {
    @Autowired
    private MatiereDao matiereDao;

    public List<Matiere> getAllMatieres() {
        return matiereDao.findAll();
    }

    public Matiere addMatiere(Matiere matiere) {
        return matiereDao.save(matiere);
    }

    public void deleteMatiereById(int matiereId) {
        matiereDao.deleteById(matiereId);
    }

    public Matiere updateMatiere(int matiereId, Matiere updatedMatiere) {
        Matiere matiereToUpdate = matiereDao.findById(matiereId)
                .orElseThrow(() -> new RuntimeException("Matiere not found"));

        matiereToUpdate.setNomMatiere(updatedMatiere.getNomMatiere());
        matiereToUpdate.setSemester(updatedMatiere.getSemester());
        matiereToUpdate.setProfesseur(updatedMatiere.getProfesseur());
        matiereToUpdate.setAnneeUniv(updatedMatiere.getAnneeUniv());

        return matiereDao.save(matiereToUpdate);
    }
}
