package com.example.Rabota.Controller;

import com.example.Rabota.Models.Game;
import com.example.Rabota.repo.GamesRepository;
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
public class GameController {

    @Autowired
    private GamesRepository gamesRepository;

    @GetMapping("/")
    public String GetGame(Model model)
    {
        Iterable<Game> games = gamesRepository.findAll();
        model.addAttribute("Games",games);
        return "MainGame";
    }
    @GetMapping("/Add/Game")
    public String GetAddGame(Game game)
    {
        return "Add-Game";
    }

    @PostMapping("/Add/Game")
    public String blogPostAdd(@ModelAttribute("game") @Valid Game game, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) return "Add-Game";
        gamesRepository.save(game);
        return "redirect:/";
    }

    @GetMapping(path = "/Search/Game")
    public String blogFilter(Game game)
    {
        return "Search-Game";
    }

    @PostMapping("/Search/Game-result")
    public String blogResult(@RequestParam String name, Model model)
    {
        List<Game> games = gamesRepository.findByName(name);
        model.addAttribute("result", games);
        return "Search-Game";
    }
    @PostMapping("/Search/Game")
    public String simpleSearch(@RequestParam float price, Model model)
    {
        List<Game> games = gamesRepository.findByPriceContains(price);
        model.addAttribute("result", games);
        return "Search-Game";
    }

    @GetMapping("/blog/Game/{id}/Edit")
    public String GameEdit(@PathVariable(value = "id") Long id, Model model) {
        Game game = gamesRepository.findById(id).orElseThrow();
        model.addAttribute("game", game);
        if (!gamesRepository.existsById(id)) {
            return "redirect:/";
        }
        return "Edit-Game";
    }

    @PostMapping("/blog/Game/{id}/Edit")
    public String GameUpdate(@ModelAttribute("game") @Valid Game game, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) return "Edit-Game";
        gamesRepository.save(game);
        return "redirect:/";
    }


    @PostMapping("/blog/Game/{id}/Remove")
    public String blogGameDelete(
            @PathVariable(value = "id") Long id,
            Model model) {
        Game game = gamesRepository.findById(id).orElseThrow();
        gamesRepository.delete(game);
        return "redirect:/";
    }
}
