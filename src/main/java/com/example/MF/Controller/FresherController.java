package com.example.MF.Controller;

import com.example.MF.Entity.Fresher;
import com.example.MF.Service.Impl.FresherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/freshers")
public class FresherController {
    @Autowired
    private FresherServiceImpl fresherServiceImpl;

    @GetMapping("")
    public String listFreshers(Model model) {
        List<Fresher> freshers = fresherServiceImpl.getAllFreshers();
        model.addAttribute("freshers", freshers);
        return "freshers/list";
    }

    @GetMapping("/add")
    public String addFresherForm(Model model) {
        model.addAttribute("fresher", new Fresher());
        return "freshers/add-edit";
    }

    @PostMapping("/add")
    public String addFresherSubmit(@ModelAttribute Fresher fresher) {
        fresherServiceImpl.saveOrUpdateFresher(fresher);
        return "redirect:/freshers";
    }

    @GetMapping("/edit/{id}")
    public String editFresherForm(@PathVariable Long id, Model model) {
        Optional<Fresher> fresher = fresherServiceImpl.getFresherById(id);
        fresher.ifPresent(f -> model.addAttribute("fresher", f));
        return "freshers/add-edit";
    }

    @PostMapping("/edit/{id}")
    public String editFresherSubmit(@PathVariable Long id, @ModelAttribute Fresher fresher) {
        fresher.setId(id);
        fresherServiceImpl.saveOrUpdateFresher(fresher);
        return "redirect:/freshers";
    }

    @GetMapping("/delete/{id}")
    public String deleteFresher(@PathVariable Long id) {
        fresherServiceImpl.deleteFresher(id);
        return "redirect:/freshers";
    }
}
