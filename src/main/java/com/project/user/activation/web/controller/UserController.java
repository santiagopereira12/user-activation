package com.project.user.activation.web.controller;

import com.project.user.activation.persistence.entity.UserEntity;
import com.project.user.activation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserEntity> getId(@PathVariable Integer idUser){
        return ResponseEntity.ok(this.userService.getById(idUser));
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        if (user.getIdUser() == null || !this.userService.userExist(user.getIdUser())){
            System.out.println("Usuario Creado");
            return ResponseEntity.ok(this.userService.saveUser(user));
        }else {
            System.out.println("El Usuario ya existe");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user){
        if (user.getIdUser() != null && this.userService.userExist(user.getIdUser())){
            System.out.println("Elemento Actualizado");
            return ResponseEntity.ok(this.userService.saveUser(user));
        }else {
            System.out.println("El Registro no existe");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Integer idUser){
        UserEntity user = this.userService.getById(idUser);
        if (user != null && this.userService.userExist(idUser)){
            this.userService.deleteUser(idUser);
            System.out.println("Registro Eliminado");
            return ResponseEntity.ok(user);
        }else {
            System.out.println("El registro no existe");
            return ResponseEntity.badRequest().build();
        }
    }
}
