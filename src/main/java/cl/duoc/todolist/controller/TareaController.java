package cl.duoc.todolist.controller;

import cl.duoc.todolist.model.Tarea;
import cl.duoc.todolist.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/tareas")
public class TareaController {

    private TareaService service;

    @Autowired
    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerListaTareas(){
        List<Tarea> lista = service.obtenerTareas();
        if(lista.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PostMapping
    public ResponseEntity<Tarea> agregarTarea(@RequestBody Tarea t){
        boolean res = service.agregarTarea(t);

        if(res) return ResponseEntity.status(HttpStatus.CREATED).body(t);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("/{idTarea}")
    public ResponseEntity<Boolean> marcarTareaCompletada(@PathVariable Long idTarea){
        boolean res = service.marcarTareaCompletada(idTarea);

        if(res) return ResponseEntity.status(HttpStatus.OK).body(true);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{idTarea}")
    public void eliminarTarea(@PathVariable Long idTarea){
        service.eliminarTarea(idTarea);
    }


}
