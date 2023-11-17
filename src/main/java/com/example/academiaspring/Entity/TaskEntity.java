package com.example.academiaspring.Entity;


import jakarta.persistence.*;

/*
* Usamos la anotacion @Entity para decirle a spring que esta clase
* es una tabla de la base de datos con sus columnas*/
@Entity
@Table(name = "tarea")
public class TaskEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombreTarea;

    @Column(name = "descripcion")
    private String descripcionTarea;
}
