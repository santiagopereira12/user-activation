package com.project.user.activation.web.controller;

import com.project.user.activation.persistence.entity.StateEntity;
import com.project.user.activation.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class StateController {
    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public ResponseEntity<List<StateEntity>> getAll(){
        return ResponseEntity.ok(this.stateService.getAll());
    }

    @GetMapping("/{idState}")
    public ResponseEntity<StateEntity> getById(@PathVariable Integer idState){
        return ResponseEntity.ok(this.stateService.getById(idState));
    }

    @PostMapping
    public ResponseEntity<StateEntity> saveState(@RequestBody StateEntity state){
        if (state.getIdState() == null || !this.stateService.stateExist(state.getIdState())){
            System.out.println("Se agrego un estado al Usuario" + state.getIdUsuario());
            return ResponseEntity.ok(this.stateService.addState(state));
        }else {
            System.out.println("El estado no puede ser Agregado");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<StateEntity> updateState(@RequestBody StateEntity state){
        if (state.getIdState() != null && this.stateService.stateExist(state.getIdState())){
            System.out.println("Usuario Actualizado");
            return ResponseEntity.ok(this.stateService.addState(state));
        }else {
            System.out.println("El Usuario no se ha actualizado");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idState}")
    public ResponseEntity<StateEntity> deleteState(@PathVariable Integer idState){
        StateEntity estado = this.stateService.getById(idState);
        if (estado != null && this.stateService.stateExist(idState)){
            this.stateService.deleteState(idState);
            System.out.println("El estado fue eliminado");
            return ResponseEntity.ok(estado);
        }else {
            System.out.println("El estado no se pudo eliminar");
            return ResponseEntity.badRequest().build();
        }
    }
}
