package com.comfenalco.microservicios.oauth.services;

import com.comfenalco.microservicios.commons.usuario.models.entities.Usuario;

public interface UsuarioService {

     public Usuario findByUsername(String username);
	
	public Usuario update(Usuario usuario, Long id);
    
}
