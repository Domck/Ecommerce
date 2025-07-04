package com.ventas.ecommerce.controller;

import com.ventas.ecommerce.model.Producto;
import com.ventas.ecommerce.service.ProductoService;
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
@RequestMapping("/")
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String home( Model model ) {
        model.addAttribute("productos", productoService.findAll());
        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id, Model model) {
        log.info("Id producto enviado como parametro {}", id);
        Optional<Producto> productoOptional = productoService.get(id);
        if (productoOptional.isPresent()) {
            model.addAttribute("producto", productoOptional.get());
            return "usuario/productohome";
        } else {
            log.error("Producto con id {} no encontrado", id);
            return "redirect:/"; // O puedes mostrar una página de error personalizada
        }
    }
    /*public String productoHome(@PathVariable Integer id, Model model    ) {
        log.info("Id producto enviado como parametro {}", id);
        Producto producto = new Producto();
        Optional<Producto> productoOptional = productoService.get(id);
        producto=productoOptional.get();
        model.addAttribute("producto", productoService.get(id).get());
        return "usuario/productohome";
    }*/

    @PostMapping("/cart")
    public String addCart() {
        log.info("Agregando producto al carrito");
        // Aquí puedes agregar la lógica para agregar un producto al carrito
        // Por ejemplo, podrías redirigir a una página de carrito de compras
        // o mostrar un mensaje de éxito.
        // Por ahora, simplemente redirigimos a la página del carrito.
        log.info("Redirigiendo al carrito de compras");
        // Puedes agregar lógica adicional aquí si es necesario
        // Por ejemplo, podrías agregar un mensaje de éxito al modelo
        return "usuario/carrito";
    }
}
