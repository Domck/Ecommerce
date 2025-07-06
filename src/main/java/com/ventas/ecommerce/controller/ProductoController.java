package com.ventas.ecommerce.controller;

import com.ventas.ecommerce.model.Producto;
import com.ventas.ecommerce.model.Usuario;
import com.ventas.ecommerce.service.IUsuarioService;
import com.ventas.ecommerce.service.ProductoService;
import com.ventas.ecommerce.service.UploadFileService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private UploadFileService upload;

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
    public String save(Producto producto, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
        LOGGER.info("Este es el objeto producto {}", producto);
        Usuario u =usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
        producto.setUsuario(u);

        // Imagen
        if (producto.getId() == null) {
            LOGGER.info("Creando nuevo producto: {}", producto);
            LOGGER.info("Se procederá a guardar la imagen para el nuevo producto...");
            String nombreImagen = upload.saveImage(file);
            LOGGER.info("Imagen guardada con nombre: {}", nombreImagen);
            producto.setImagen(nombreImagen);
        } else {
        }

        productoService.save(producto);
        LOGGER.info("El usuario {} creó un nuevo producto: {}", u.getNombre(), producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto=new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto=optionalProducto.get();
        LOGGER.info("Editando producto con id {}: {}", id, producto);
        model.addAttribute("producto",producto);
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto,@RequestParam("img") MultipartFile file) throws IOException {

        Producto p =new Producto();
        p = productoService.get(producto.getId()).get();
        if (file.isEmpty()) {
            producto.setImagen(p.getImagen());
        } else {
            if (p.getImagen().equals("default.jpg")) {
                upload.deleteImage(p.getImagen());
            }
            LOGGER.info("Se subió una nueva imagen. Procediendo a guardar...");
            String nombreImagen = upload.saveImage(file);
            LOGGER.info("Nueva imagen guardada con nombre: {}", nombreImagen);
            producto.setImagen(nombreImagen);
        }
        producto.setUsuario(p.getUsuario());
        LOGGER.info("Actualizando producto: {}", producto);
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        LOGGER.info("Eliminando producto con id: {}", id);
        Producto p= new Producto();
        p= productoService.get(id).get();

        // Corrige la condición para eliminar solo imágenes personalizadas
        if (!p.getImagen().equals("default.jpg")) {
            upload.deleteImage(p.getImagen());
        }
        productoService.delete(id);
        return "redirect:/productos";
    }
}
