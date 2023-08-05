package com.comfenalco.microservicios.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.comfenalco.microservicios.commons.usuario.models.entities.Usuario;
import com.comfenalco.microservicios.oauth.clients.UsuarioFeignClient;

import feign.FeignException;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioFeignClient client;

    @Override
    public Usuario findByUsername(String username) {
        return client.findByUsername(username);

    }

    @Override
    public Usuario update(Usuario usuario, Long id) {
        return client.update(usuario, id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {

            Usuario usuario = client.findByUsername(username);

            List<GrantedAuthority> authorities = usuario.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                    .peek(authority -> log.info("Role: ".concat(authority.getAuthority())))
                    .collect(Collectors.toList());

            log.info("Usuario autenticado: ".concat(username));

            return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
            authorities);

        } catch (FeignException e) {
            String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
            log.error(error);

            throw new UsernameNotFoundException(error);
        }

    }

}
