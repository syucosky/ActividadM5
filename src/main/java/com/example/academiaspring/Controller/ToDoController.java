package com.example.academiaspring.Controller;


import com.example.academiaspring.Entity.TaskEntity;
import com.example.academiaspring.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {

    @Autowired
    TaskService service;

    @GetMapping ("/")
    public String saludar(Model model) {
        List<TaskEntity> tareas = service.findAll();
        model.addAttribute("tareas", tareas);
        return "index";
    }
    @GetMapping ("/agregartarea")
    public String tareaNueva(Model model){
        model.addAttribute("TaskEntity",new TaskEntity());
        return "formTareaNueva";
    }
    @PostMapping ("/agregartarea")
    public String tareaNueva(@Validated TaskEntity tarea,Model model){
        model.addAttribute("TaskEntity",tarea);
        System.out.println(tarea.getNombreTarea());
        System.out.println(tarea.getDescripcionTarea());

        service.addTask(tarea);
        return "redirect:/";
    }
}
