package com.example.MF.Controller;

import com.example.MF.Entity.Center;
import com.example.MF.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/centers")
public class CenterController {

    @Autowired
    private CenterService centerService;

    @GetMapping("")
    public String listCenters(Model model) {
        List<Center> centers = centerService.getAllCenters();
        model.addAttribute("centers", centers);
        return "centers/list";
    }

    @GetMapping("/add")
    public String addCenterForm(Model model) {

        model.addAttribute("center", new Center());
        return "centers/add-edit";
    }

    @PostMapping("/add")
    public String addCenterSubmit(@ModelAttribute Center center) {
        centerService.saveOrUpdateCenter(center);
        return "redirect:/centers";
    }

    @GetMapping("/edit/{id}")
    public String editCenterForm(@PathVariable Long id, Model model) {
        Optional<Center> center = centerService.getCenterById(id);
        center.ifPresent(c -> model.addAttribute("center", c));
        return "centers/add-edit";
    }

    @PostMapping("/edit/{id}")
    public String editCenterSubmit(@PathVariable Long id, @ModelAttribute Center center) {
        center.setId(id);
        centerService.saveOrUpdateCenter(center);
        return "redirect:/centers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCenter(@PathVariable Long id) {
        centerService.deleteCenter(id);
        return "redirect:/centers";
    }
}
