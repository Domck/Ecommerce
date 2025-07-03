package com.ventas.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileService.class);
    private String folder="images//";

    public String saveImage(MultipartFile file) throws IOException {
        LOGGER.info("[UploadFileService] Iniciando guardado de imagen: {}", file.getOriginalFilename());
        if (!file.isEmpty()) {
            byte [] bytes=file.getBytes();
            Path path = Paths.get(folder+file.getOriginalFilename());
            Files.write(path, bytes);
            LOGGER.info("[UploadFileService] Imagen guardada: {}", file.getOriginalFilename());
            return file.getOriginalFilename();
        }
        LOGGER.warn("[UploadFileService] Archivo vacío, se retorna imagen por defecto");
        return "default.jpg";
    }

    public void deleteImage(String nombre) {
        LOGGER.info("[UploadFileService] Eliminando imagen: {}", nombre);
        String ruta="images//";
        File file= new File(ruta+nombre);
        file.delete();
    }
}
