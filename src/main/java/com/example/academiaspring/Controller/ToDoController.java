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

@Controller
@RequestMapping("/")
public class ToDoController {

    @Autowired
    TaskService service;

    @GetMapping ("/saludo")
    public String saludar(Model model) {
        model.addAttribute("mensaje", "Holisss");
        return "saludo";
    }
    @PostMapping ("/agregartarea")
    public String tareaNueva(@Validated TaskEntity tarea){
        service.addTask(tarea);
        return "formTareaNueva";
    }
}
