package com.ventas.ecommerce.repository;


import com.ventas.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
