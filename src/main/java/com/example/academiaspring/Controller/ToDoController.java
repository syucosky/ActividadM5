package com.example.academiaspring.Controller;


import com.example.academiaspring.Entity.TaskEntity;
import com.example.academiaspring.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ToDoController {

    @Autowired
    TaskService service;

    @GetMapping ("/")
    public String listarTareas(Model model) {
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
    public String guardarTarea(@Validated TaskEntity tarea){
         service.addTask(tarea);
        return "redirect:/";
    }

    @GetMapping ("/editar/{id}")
    public String editarTarea(@PathVariable int id, Model model){
          TaskEntity tarea = service.findById(id).get();
          model.addAttribute("TaskEntity",tarea);
        return "formTareaNueva";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/";
    }
}
