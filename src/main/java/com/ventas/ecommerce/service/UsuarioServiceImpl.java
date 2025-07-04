package com.ventas.ecommerce.service;

import com.ventas.ecommerce.model.Usuario;
import com.ventas.ecommerce.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Override
    public Optional<Usuario> findbyId(Integer id) {
        return usuarioRepository.findById(id);
    }
}
