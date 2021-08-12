package com.informatorio.Ejercicios_complementarios_level_1.Controller;

import com.informatorio.Ejercicios_complementarios_level_1.Entity.Producto;
import com.informatorio.Ejercicios_complementarios_level_1.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    private String[] categorias = {"Congelados", "Pan", "Pasta", "Bebidas", "Harinas", "Embutidos"};

    @Autowired
    private ProductoRepository repository;


    //CEAR PRODUCTO
    @RequestMapping(value = "/producto", method = RequestMethod.POST)
    public Producto crearProducto(@RequestBody Producto producto){
        return repository.save(producto);
    }

    //MOSTRAR PRODUCTO POR ID
    @RequestMapping(value = "/producto/{id}", method = RequestMethod.GET)
    public Producto mostrarProductoId(@PathVariable("id") Long id){
        return repository.findById(id).get();
    }

    //MOSTRAR TODOS LOS PRODUCTO
    @RequestMapping(value = "/producto", method = RequestMethod.GET)
    public ResponseEntity<?> mostrarProductoTodos(){
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }

    //MODIFICAR PRODUCTO POR ID
    @RequestMapping(value = "/producto/{id}", method = RequestMethod.PUT)
    public Producto modificarProductoId(@PathVariable("id") Long id, @RequestBody Producto productoModif){
        Producto productoExis = repository.findById(id).get();
        productoExis.setNombre(productoModif.getNombre());
        productoExis.setDescripcion(productoModif.getDescripcion());
        productoExis.setPrecio_unitario(productoModif.getPrecio_unitario());
        productoExis.setCodigo((productoModif.getCodigo()));
        productoExis.setCategoria(productoModif.getCategoria());
        return repository.save(productoExis);
    }

    //BORRAR PRODUCTO POR ID
    @RequestMapping(value = "/producto/{id}", method = RequestMethod.DELETE)
    public void borrarProductoId(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}
