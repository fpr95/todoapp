package cl.duoc.todolist.service;

import cl.duoc.todolist.model.Tarea;
import cl.duoc.todolist.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TareaService {

    private TareaRepository repo;

    @Autowired
    public TareaService(TareaRepository repo) {
        this.repo = repo;
    }

    public List<Tarea> obtenerTareas(){
        List<Tarea> tareas = repo.getTareas();
        if(tareas != null && tareas.size() > 0){
            return tareas;
        }
        return Collections.emptyList();
    }

    public boolean agregarTarea(Tarea t){
        try{
            repo.agregarTarea(t);

            return true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }


    public boolean eliminarTarea(Long idTarea){
        return repo.eliminarTarea(idTarea);
    }


    public boolean marcarTareaCompletada(Long idTarea){
        return repo.marcarTarea(idTarea);
    }

}
