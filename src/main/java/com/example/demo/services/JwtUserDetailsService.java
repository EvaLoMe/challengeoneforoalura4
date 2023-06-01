package com.example.demo.services;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.Rol;
import com.example.demo.models.UsuarioDTO;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UserDao;





@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		UsuarioModel user = userDao.findBynombre(usuario);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario con el nombre: " + usuario+" no existe o no tiene suficientes permisos");
		}
		//Aqui cargamos el usuario y sus roles
		System.out.println("Usuario con el nombre: " + usuario+" ha ganado el Rol de: "+user.getAuthorities().iterator().next());
		User usuarioCargado=new org.springframework.security.core.userdetails.User(user.getNombre(),user.getContrasena(),
				user.getAuthorities());
		
		return usuarioCargado;
	}
	
	public PasswordEncoder getPasswordEncoder() {
		return bcryptEncoder;
	}
	public UsuarioModel save(UsuarioDTO user) {
		UsuarioModel newUser = new UsuarioModel();
		newUser.setNombre(user.getUsername());
		newUser.setContrasena(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setFecha(user.getFecha());
		newUser.setDateCreated(user.getDateCreated());
		newUser.setLastUpdated(user.getLastUpdated());
		newUser.setPermisos(user.getPermisos());
		if(user.getRol()==null)
		newUser.setRol(Rol.ROLE_USER);
		else
			newUser.setRol(Rol.ROLE_ADMIN);
		System.out.println(user.getRol()+": Rol Recibido");
		System.out.println(newUser.getRol()+": Rol Asignado");
		return userDao.save(newUser);
	}
}