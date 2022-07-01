package com.concessionaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.concessionaria.entities.Categoria;
import com.concessionaria.entities.Veiculo;
import com.concessionaria.repositories.categoriaRepository;
import com.concessionaria.repositories.veiculoRepository;

@Controller
public class veiculoController {

    @Autowired
    private veiculoRepository veiculoRepository;

    @Autowired
    private categoriaRepository categoriaRepository;
    
    @GetMapping("/veiculo")
    public String listarVeiculos(Model model){
        model.addAttribute("listadeveiculos", veiculoRepository.findAll());
        return "veiculo";
    }

    @GetMapping("/veiculo/novo")
    public String listarcategorias(Model model){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listarcategorias", listaCategorias);   
        return "novoVeiculo";
    }

    @PostMapping("/veiculo/save")
    public String salvar(Veiculo veiculo){        
        veiculoRepository.save(veiculo);
        
        return "redirect:/veiculo";
    }

    @GetMapping("/veiculo/editar/{id}")
    public ModelAndView editarVeiculo(@PathVariable(name = "id") Long id, Model model){
        ModelAndView view = new ModelAndView("editarVeiculo");
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        view.addObject("veiculos", veiculo);
        model.addAttribute("listarcategorias", categoriaRepository.findAll());
        return view;
    }

    @GetMapping("/veiculo/delete/{id}")
    public String deletar(@PathVariable(name = "id")Long id){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        veiculoRepository.delete(veiculo.get());
        return"redirect:/veiculo";
    }

}
