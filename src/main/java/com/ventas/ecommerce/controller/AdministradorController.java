package com.ventas.ecommerce.controller;

import com.ventas.ecommerce.model.Orden;
import com.ventas.ecommerce.model.Producto;
import com.ventas.ecommerce.model.Usuario;
import com.ventas.ecommerce.service.IOrdenService;
import com.ventas.ecommerce.service.IUsuarioService;
import com.ventas.ecommerce.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private IUsuarioService  usuarioService;

    @Autowired
    private IOrdenService ordensService;

    private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

    @GetMapping("")
    public String home(Model model) {
        List<Producto> productos= productoService.findAll();
        model.addAttribute("productos", productos);
        return "administrador/home";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll();
        logg.info("Usuarios encontrados: {}", usuarios.size());
        usuarios.forEach(u -> logg.info("Usuario: {}", u.getNombre()));
        model.addAttribute("usuarios", usuarios);
        return "administrador/usuarios";

        //model.addAttribute("usuarios", usuarioService.findAll());
        //return "administrador/usuarios";
    }

    @GetMapping("/ordenes")
    public String ordenes(Model model) {
        logg.info("Cargando ordenes para el administrador");
        model.addAttribute("ordenes", ordensService.findAll());
        return "administrador/ordenes";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(Model model, @PathVariable Integer id) {
        logg.info("Id de la orden {}",id);
        Orden orden= ordensService.findById(id).get();

        model.addAttribute("detalles", orden.getDetalle());

        return "administrador/detalleorden";
    }


}
