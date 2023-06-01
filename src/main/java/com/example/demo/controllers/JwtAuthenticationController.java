package com.example.demo.controllers;



import java.util.Objects;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.JwtRequest;
import com.example.demo.models.JwtResponse;
import com.example.demo.models.UsuarioDTO;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.services.JwtUserDetailsService;
import com.example.demo.services.UsuarioService;




@RestController
//@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
    UsuarioRepository usuarioR;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("El usuario ha sido encontrado");

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO nuevoUsuario) throws Exception {
		UsuarioDTO actualizable=new UsuarioDTO();
		actualizable.setUsername(nuevoUsuario.getUsername());
		actualizable.setPassword(nuevoUsuario.getPassword());
		actualizable.setEmail(nuevoUsuario.getEmail());
		actualizable.setFecha(nuevoUsuario.getFecha());
		actualizable.setPermisos(nuevoUsuario.getPermisos());
		actualizable.setRol(nuevoUsuario.getRol());
		if(nuevoUsuario.getDateCreated()==null) {
			ZoneOffset offset = ZoneOffset.UTC;
			OffsetDateTime tiempoHoy=java.time.LocalDateTime.now().atOffset(offset);
			actualizable.setDateCreated(tiempoHoy);
			System.out.println("Agregando fecha creacion");
		}
		if(nuevoUsuario.getLastUpdated()==null) {
			ZoneOffset offset = ZoneOffset.UTC;
			OffsetDateTime tiempoHoy=java.time.LocalDateTime.now().atOffset(offset);
			actualizable.setLastUpdated(tiempoHoy);
			System.out.println("Agregando fecha actualizacion");
		}
			System.out.println(actualizable.getDateCreated()+" "+actualizable.getLastUpdated());
			//usuarioR.save(new UsuarioModel(actualizable));
			UsuarioModel respuesta=null;
			try {
			respuesta=userDetailsService.save(actualizable);
			}catch(Exception e) {
				//String mensajeConsola=e.getLocalizedMessage();
				//if(mensajeConsola.indexOf("Duplicate entry")!=-1) {
					return (ResponseEntity<?>) ResponseEntity.badRequest().body("El usuario ya ha sido registrado");
				//}
			}
		return ResponseEntity.ok(respuesta);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}