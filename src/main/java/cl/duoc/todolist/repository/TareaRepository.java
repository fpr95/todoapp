package cl.duoc.todolist.repository;

import cl.duoc.todolist.model.Tarea;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
//@NoArgsConstructor
@Getter
@Setter
@Data
public class TareaRepository {

    private List<Tarea> tareas;

    public TareaRepository(){
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea t){
        tareas.add(t);
    }

    private boolean existeTareaPorId(Long id){
        for(Tarea t:tareas){
            if(Objects.equals(t.getIdTarea(), id)){return true;}
        }
        return false;
    }

    public boolean eliminarTarea(Long idTarea){
        if(existeTareaPorId(idTarea)){
            for(Tarea t:tareas){
                if(Objects.equals(t.getIdTarea(), idTarea)){
                    tareas.remove(t);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean marcarTarea(Long id){
        if(existeTareaPorId(id)){
            for(Tarea t:tareas){
                if(Objects.equals(t.getIdTarea(), id)){
                    t.setCompleted(true);
                    return true;
                }
            }
        }
        return false;
    }

}
