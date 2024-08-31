package com.andinos.hca.controller;

import com.andinos.hca.model.entity.Usuario;
import com.andinos.hca.model.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> getUsuarios(){
        return new ResponseEntity<> (usuarioService.findAll(),
                HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<> (usuarioService.save(usuario),
                HttpStatus.ACCEPTED);
    }
}
