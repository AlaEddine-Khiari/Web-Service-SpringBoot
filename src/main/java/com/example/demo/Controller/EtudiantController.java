package com.example.demo.Controller;

import com.example.demo.Model.Etudiant;
import com.example.demo.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;

    @GetMapping("/all")
    public String getAllEtudiants(Model model) {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        model.addAttribute("etudiants", etudiants);
        model.addAttribute("newEtudiant", new Etudiant()); // Assuming you want an empty form for adding new students
        return "etudiant"; // Assuming "etudiant.html" is your page name
    }

    @PostMapping("/add")
    public String addNewEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantService.addEtudiant(etudiant);
        return "redirect:/etudiant/all"; // Redirect to the list of students after adding
    }

    @PostMapping("/delete/{id}")
    public String deleteEtudiant(@PathVariable("id") int id) {
        etudiantService.deleteEtudiantById(id);
        return "redirect:/etudiant/all"; // Redirect to the list of students after deleting
    }

    @PostMapping ("/update/{id}")
    public String updateEtudiant(@PathVariable("id") int id, @ModelAttribute Etudiant updatedEtudiant) {
        etudiantService.updateEtudiant(id, updatedEtudiant);
        return "redirect:/etudiant/all"; // Redirect to the list of students after updating
    }
}
