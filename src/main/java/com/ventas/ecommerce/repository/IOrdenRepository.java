package com.ventas.ecommerce.repository;

import com.ventas.ecommerce.model.Orden;
import com.ventas.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {

}
