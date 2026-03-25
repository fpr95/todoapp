package cl.duoc.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    private Long idTarea;


    private String descripcion;
    private boolean isCompleted = false;
}
