package com.pilatesapp.agendamento.controller;

import com.pilatesapp.agendamento.model.AgendamentoModel;
import com.pilatesapp.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping("/cadastroAluno")
    public String cadastro(){
        return "agendamentoView/formularioAgendamento";
    }

    @PostMapping("/cadastroAluno")
    public String cadastro(AgendamentoModel agendamentoModel) {
        agendamentoRepository.save(agendamentoModel);
        return "redirect:/cadastroAluno";
    }

    @GetMapping("/agendados")
    public ModelAndView agendados(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<AgendamentoModel> agendados = agendamentoRepository.findAll();
        modelAndView.addObject("agendados", agendados);

        return modelAndView;
    }
    @RequestMapping("/deletar")
    public String deletar(long id){
        AgendamentoModel agendamentoModel = agendamentoRepository.findById(id);
        agendamentoRepository.delete(agendamentoModel);
        return "redirect:/agendados";
    }

}
