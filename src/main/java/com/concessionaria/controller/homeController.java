package com.concessionaria.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.concessionaria.repositories.categoriaRepository;
import com.concessionaria.entities.Categoria;

@Controller
public class homeController {
    @Autowired
    private categoriaRepository categoriaRepository;
    
    @GetMapping("/categorias")
    public String categorias(Model model){
        model.addAttribute("listarcategorias", categoriaRepository.findAll());
        return "categoria";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/categorias/nova")
    public String criarCategoria(){
        return "novaCategoria";
    }

    @PostMapping("/categorias/save")
    public String salvar(Categoria categoria, RedirectAttributes ra){
        categoriaRepository.save(categoria);
               
        return "redirect:/categorias";
    } 

    @GetMapping("/categorias/editar/{id}")
    public ModelAndView editarCategorias(@PathVariable(name = "id") Long id){
        ModelAndView editView = new ModelAndView("editarCategoria");
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        editView.addObject("categorias", categoria);        
        return editView;
    
    }

    @GetMapping("categorias/delete/{id}")
    public String deletarCategoria(@PathVariable(name = "id") Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        categoriaRepository.delete(categoria.get());
        return "redirect:/categorias";
    }
    
    

    

}
