package com.myfreetime.service;

import org.springframework.security.core.GrantedAuthority;
import java.util.List;
import java.util.Collection;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.myfreetime.model.Rol;
import java.util.ArrayList;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.myfreetime.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import com.myfreetime.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UsuarioLoginServiceImpl implements UserDetailsService {
	
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario appUser = usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No existe el usuario"));
        List grantList = new ArrayList();
        for (Rol authority : appUser.getRoles()) {
            GrantedAuthority grantedAuthority = (GrantedAuthority)new SimpleGrantedAuthority(authority.getNombre());
            grantList.add(grantedAuthority);
        }
        final UserDetails usuario = (UserDetails)new User(appUser.getEmail(), appUser.getPassword(), (Collection)grantList);
        return usuario;
    }
}