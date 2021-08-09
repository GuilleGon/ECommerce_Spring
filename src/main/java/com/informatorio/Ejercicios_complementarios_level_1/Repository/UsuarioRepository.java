package com.informatorio.Ejercicios_complementarios_level_1.Repository;

import com.informatorio.Ejercicios_complementarios_level_1.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
