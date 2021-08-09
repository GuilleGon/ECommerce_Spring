package com.informatorio.Ejercicios_complementarios_level_1.Controller;

import com.informatorio.Ejercicios_complementarios_level_1.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    private String[] categorias = {"Congelados", "Pan", "Pasta", "Bebidas", "Harinas", "Embutidos"};

    @Autowired
    private ProductoRepository repository;
}
