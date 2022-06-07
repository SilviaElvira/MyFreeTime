package com.myfreetime.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myfreetime.model.Empresa;
import com.myfreetime.model.Rol;
import com.myfreetime.repository.EmpresaRepository;

@Service
public class EmpresaLoginServiceImpl implements UserDetailsService {

	@Autowired
	EmpresaRepository empresaRepository;
	
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		Empresa appUser = empresaRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No existe el usuario"));
		List grantList = new ArrayList();
		for (final Rol authority : appUser.getRoles()) {
			final GrantedAuthority grantedAuthority = (GrantedAuthority)new SimpleGrantedAuthority(authority.getNombre());
            grantList.add(grantedAuthority);
		}
		UserDetails empresa = (UserDetails) new  User(appUser.getEmail(), appUser.getPassword(), (Collection)grantList);
		return empresa;
	}
}
