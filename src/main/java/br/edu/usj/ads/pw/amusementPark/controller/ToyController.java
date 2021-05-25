package br.edu.usj.ads.pw.amusementPark.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.usj.ads.pw.amusementPark.model.Toy;
import br.edu.usj.ads.pw.amusementPark.repository.ToyRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ToyController {

    @Autowired
    ToyRepository toyRepository;

    @GetMapping(value="/")
    public ModelAndView getIndex() {
        Toy toy = new Toy();

        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("toy", toy);

        return modelAndView;
    }
    
    @GetMapping(value="/gerenciar")
    public ModelAndView getGerenciar() {
        List<Toy> list = new ArrayList<>();

        list = toyRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("gerenciar");

        modelAndView.addObject("list", list);

        return modelAndView;
    }

    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {
        Toy toy = new Toy();
        toy = toyRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("detalhes");

        modelAndView.addObject("toy", toy);

        return modelAndView;
    }
    

    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro() {
        Toy toy = new Toy();

        ModelAndView modelAndView = new ModelAndView("cadastro");

        modelAndView.addObject("toy", toy);

        return modelAndView;
    }

    @PostMapping(value="/detalhes")
    public ModelAndView postAdicionar(Toy toy) {
        toyRepository.save(toy);

        ModelAndView modelAndView = new ModelAndView("detalhes");

        modelAndView.addObject("toy", toy);

        return modelAndView;
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        Toy toy = new Toy();
        toy = toyRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("editar");

        modelAndView.addObject("toy", toy);

        return modelAndView;
    }
    

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        toyRepository.deleteById(id);

        return "redirect:/gerenciar";
    }
    
    
}
