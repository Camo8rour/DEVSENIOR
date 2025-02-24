package com.camo.model;

import com.camo.collection.Lists;
import com.camo.exception.InvalidPositionException;
import com.camo.exception.TaskNotFoundException;

public class Main {
    public static void main(String[] args) {
        var task = new Lists();

        // Agrega las tareas pendientes y tarea completada
        task.addTask("Reunión", false);
        task.addTask("Trabajos", false);
        task.addTask("Instalar", true);

        // Remueve la tarea completada
        try {
            task.removeTask("Instalar");
        } catch (TaskNotFoundException e) {
            System.err.println("\nHa ocurrido un error al eliminar la tarea.\n" + e.getMessage());
        }

        // Muestra las tareas pendientes
        task.showTasks();

        // Mostrar tarea por posision
        try {
            task.TaskPosition(0);
        } catch (InvalidPositionException e) {
            System.err.println("\nHa ocurrido un error al mostrar la tarea.\n" + e.getMessage());
        }

        System.out.println("\nGracias por usar el invantario.");
    }
}