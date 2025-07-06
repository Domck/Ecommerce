package com.ventas.ecommerce.repository;

import com.ventas.ecommerce.model.Orden;
import com.ventas.ecommerce.model.Producto;
import com.ventas.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {
    List<Orden> findByUsuario(Usuario usuario);
}
