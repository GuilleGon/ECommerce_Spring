package com.informatorio.Ejercicios_complementarios_level_1.Repository;

import com.informatorio.Ejercicios_complementarios_level_1.Entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
