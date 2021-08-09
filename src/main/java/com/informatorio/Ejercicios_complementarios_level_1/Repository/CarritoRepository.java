package com.informatorio.Ejercicios_complementarios_level_1.Repository;

import com.informatorio.Ejercicios_complementarios_level_1.Entity.Carrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends CrudRepository<Carrito, Long> {
}
