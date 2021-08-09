package com.informatorio.Ejercicios_complementarios_level_1.Controller;


import com.informatorio.Ejercicios_complementarios_level_1.Entity.Usuario;
import com.informatorio.Ejercicios_complementarios_level_1.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(value = "/usuarios")
    public @ResponseBody Iterable<Usuario> findEmpleados(){
        return repository.findAll();
    }
}
