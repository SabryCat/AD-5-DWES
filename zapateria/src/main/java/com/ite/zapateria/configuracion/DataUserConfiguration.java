package com.ite.zapateria.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DataUserConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth
	.jdbcAuthentication().dataSource(dataSource)
	.usersByUsernameQuery("select email, password, enabled from Usuarios where email=?")
	.authoritiesByUsernameQuery("select u.email, r.nombre "
								+ "from Roles r " +  
									"inner join Usuarios u on u.id_rol = r.id_rol " + 
									"where u.email = ?");
	}
	
	//Configuracion de roles url permitidas y no permitidas
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			// Los directorios estáticos no requieren autenticacion
			.antMatchers("/bootstrap/**",  "/images/**", "/css/**", "js/**").permitAll()
			
			// Las vistas públicas no requieren autenticación
			.antMatchers("/").permitAll()
			.antMatchers("/index").permitAll() 
			.antMatchers("/productos/todos").permitAll()
			.antMatchers("/productos/detalle/**").permitAll()
			.antMatchers("/usuarios/registro/cliente").permitAll()
			
			.antMatchers("/usuarios/registro/administrador").hasAnyAuthority("Administrador")
			.antMatchers("/logout").hasAnyAuthority("Administrador","Cliente")
			
			// Todas las demás URLs de la Aplicación requieren autenticación
			.anyRequest().authenticated()
			// El formulario de Login no requiere autenticacion
			.and().formLogin().permitAll()
			// El formulario de logout no requiere autenticacion
	//		.and().logout().permitAll()
			;
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}