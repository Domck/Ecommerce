package com.ventas.ecommerce.service;

import com.ventas.ecommerce.model.DetalleOrden;
import com.ventas.ecommerce.model.Orden;
import com.ventas.ecommerce.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IOrdenService {
    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save(Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario(Usuario usuario);
}
