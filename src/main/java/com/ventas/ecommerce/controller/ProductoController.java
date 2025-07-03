package com.ventas.ecommerce.controller;

import com.ventas.ecommerce.model.Producto;
import com.ventas.ecommerce.model.Usuario;
import com.ventas.ecommerce.service.ProductoService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String show (Model model) {
        LOGGER.info("Mostrando la lista de productos");
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        LOGGER.info("Accediendo al formulario de creación de producto");
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto){
        LOGGER.info("Este es el objeto producto {}", producto);
        Usuario u =new Usuario(1,"","","","","","","");
        productoService.save(producto);
        LOGGER.info("El usuario {} creó un nuevo producto: {}", u.getNombre(), producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto=new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto=optionalProducto.get();
        //LOGGER.info("Editando buscado: {}",producto);
        LOGGER.info("Editando producto con id {}: {}", id, producto);
        model.addAttribute("producto",producto);
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto){
        LOGGER.info("Actualizando producto: {}", producto);
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        LOGGER.info("Eliminando producto con id: {}", id);
        productoService.delete(id);
        return "redirect:/productos";
    }
}
