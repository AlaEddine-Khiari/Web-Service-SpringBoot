package com.example.demo.Controller;

import com.example.demo.Model.Matiere;
import com.example.demo.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matiere")
public class MatiereController {
    @Autowired
    private MatiereService matiereService;

    @GetMapping("/all")
    public String getAllMatieres(Model model) {
        List<Matiere> matieres = matiereService.getAllMatieres();
        model.addAttribute("matieres", matieres);
        model.addAttribute("newMatiere", new Matiere()); // Assuming you want an empty form for adding new Matieres
        return "matiere"; // Assuming "matiere.html" is your page name
    }

    @PostMapping("/add")
    public String addMatiere(@ModelAttribute Matiere matiere) {
        matiereService.addMatiere(matiere);
        return "redirect:/matiere/all"; // Redirect to the list of Matieres after adding
    }

    @PostMapping("/delete/{id}")
    public String deleteMatiere(@PathVariable("id") int id) {
        matiereService.deleteMatiereById(id);
        return "redirect:/matiere/all"; // Redirect to the list of Matieres after deleting
    }

    @PostMapping("/update/{id}")
    public String updateMatiere(@PathVariable("id") int id, @ModelAttribute Matiere updatedMatiere) {
        matiereService.updateMatiere(id, updatedMatiere);
        return "redirect:/matiere/all"; // Redirect to the list of Matieres after updating
    }
}
