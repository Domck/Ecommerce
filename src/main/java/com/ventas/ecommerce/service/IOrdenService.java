package com.ventas.ecommerce.service;

import com.ventas.ecommerce.model.DetalleOrden;
import com.ventas.ecommerce.model.Orden;

import java.util.List;

public interface IOrdenService {
    List<Orden> findAll();
    Orden save(Orden orden);
    String generarNumeroOrden( );
}
