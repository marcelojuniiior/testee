package com.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.concessionaria.entities.Categoria;
import com.concessionaria.repositories.categoriaRepository;



@RestController
@RequestMapping("/categoria")
public class categoriaController {
    
    @Autowired
    private categoriaRepository categoriaRepository;

    @GetMapping
    public String teste(){
        return "abc";
    }
    @PostMapping
    public String salvar(Categoria categoria, RedirectAttributes ra){
        categoriaRepository.save(categoria);
        ra.addFlashAttribute("message", "Quarto Cadastrado com sucesso");        
        return "redirect:/categorias";
    }    
    
}

