package com.camo.collection;

import java.util.LinkedList;
import java.util.List;

import com.camo.exception.InvalidPositionException;
import com.camo.exception.TaskNotFoundException;
import com.camo.model.Task;

public class Lists {

    private List<Task> task;

    public Lists(){
        task = new LinkedList<>();
    }

    public void addTask(String name, boolean completed){
        task.add(new Task(name, completed));
        System.out.printf("La tarea %s fue agregada con exito.%n", name);
    }

    public Task removeTask (String name){
        for(Task taskName : task){
            if(taskName.getName().equals(name) && taskName.isCompleted() == true){
                task.remove(taskName);
                System.out.printf("%nLa tarea %s fue eliminada con exito.%n", name);
                return taskName;
            }
        }
        throw new TaskNotFoundException("No existe la tarea completada: " + name);
    }

    public void showTasks(){
        System.out.println("\nTareas pendientes:");

        for(Task taskName : task){
            if (taskName.isCompleted() == false){
                System.out.println(taskName);
            }
        }
    }

    public void TaskPosition(int position) throws InvalidPositionException{
        if (position < 0 || position > task.size()) {
            throw new InvalidPositionException("La posición ingresada es incorrecta.");
        }

        System.out.printf("%nLa tarea en la posición %d es: %s.%n", (position + 1), task.get(position));
    }
}
