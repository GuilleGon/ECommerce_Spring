package com.informatorio.Ejercicios_complementarios_level_1.Controller;


import com.informatorio.Ejercicios_complementarios_level_1.Entity.Usuario;
import com.informatorio.Ejercicios_complementarios_level_1.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    //CEAR USUARIO
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }

    //MOSTRAR USUARIO POR ID
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario mostrarUsuarioId(@PathVariable("id") Long id){
        return repository.findById(id).get();
    }

    //MOSTRAR TODOS LOS USUARIOS
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public ResponseEntity<?> mostrarUsuarioTodos(){
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }

    //MODIFICAR USUARIO POR ID
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
    public Usuario modificarUsuarioId(@PathVariable("id") Long id, @RequestBody Usuario usuarioModif){
        Usuario usuarioExis = repository.findById(id).get();
        usuarioExis.setNombre(usuarioModif.getNombre());
        usuarioExis.setApellido(usuarioModif.getApellido());
        usuarioExis.setDireccion(usuarioModif.getDireccion());
        return repository.save(usuarioExis);
    }

    //BORRAR USUARIO POR ID
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void borrarUsuarioId(@PathVariable("id") Long id){
        repository.deleteById(id);
    }

}