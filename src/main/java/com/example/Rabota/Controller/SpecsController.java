package com.example.Rabota.Controller;

import com.example.Rabota.Models.Game;
import com.example.Rabota.Models.Specifications;
import com.example.Rabota.repo.SpecsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SpecsController {
    @Autowired
    private SpecsRepository specsRepository;
    @GetMapping("/Specs")
    public String GetSpecs(Model model)
    {
        Iterable<Specifications> specifications = specsRepository.findAll();
        model.addAttribute("Specifications",specifications);
        return "MainSpecs";
    }
    @GetMapping("/Add/Specs")
    public String GetAddSpecs(Specifications specifications)
    {
        return "Add-Specs";
    }

    @PostMapping("/Add/Specs")
    public String blogPostAdd(@ModelAttribute("specifications") @Valid Specifications specifications, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) return "Add-Specs";
        specsRepository.save(specifications);
        return "redirect:/Specs";
    }
    @GetMapping( path = "/Search/Specs")
    public String blogFilter(Model model)
    {
        return "Search-Specs";
    }

    @PostMapping("/Search/Specs-result")
    public String blogResult(@RequestParam String CPU, Model model)
    {
        List<Specifications> specifications = specsRepository.findByCPU(CPU);
        model.addAttribute("result", specifications);
        return "Search-Specs";
    }
    @PostMapping("/Search/Specs")
    public String simpleSearch(@RequestParam String GPU, Model model) {
        List<Specifications> specifications = specsRepository.findByGPUContains(GPU);
        model.addAttribute("result", specifications);
        return "Search-Specs";
    }

    @GetMapping("/blog/Specs/{id}/Edit")
    public String SpecsEdit(@PathVariable(value = "id") Long id, Model model) {
        Specifications specifications = specsRepository.findById(id).orElseThrow();
        model.addAttribute("specs", specifications);
        if (!specsRepository.existsById(id)) {
            return "redirect:/Specs";
        }
        return "Edit-Specs";
    }

    @PostMapping("/blog/Specs/{id}/Edit")
    public String SpecsUpdate(@ModelAttribute("specs") @Valid Specifications specs, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) return "Edit-Specs";
        specsRepository.save(specs);
        return "redirect:/Specs";
    }

    @PostMapping("/blog/Specs/{id}/Remove")
    public String blogSpecsDelete(
            @PathVariable(value = "id") Long id,
            Model model) {
        Specifications specifications = specsRepository.findById(id).orElseThrow();
        specsRepository.delete(specifications);
        return "redirect:/Specs";
    }

}
