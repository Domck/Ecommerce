package com.ventas.ecommerce.service;


import com.ventas.ecommerce.model.Usuario;

import java.util.Optional;

public interface IUsuarioService {
    Optional <Usuario> findbyId(Integer id);
    Usuario save(Usuario usuario);

}
