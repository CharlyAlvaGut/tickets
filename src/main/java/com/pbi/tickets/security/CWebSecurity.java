package com.pbi.tickets.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CWebSecurity {
	
	@Autowired
	CErrores errores;
	
	/*
	 * Este método es para configurar Usuarios y roles de forma personalizada (Se
	 * debe especificar a qué tablas pertenecen nuestros usuarios y perfiles)
	 */
	@Bean
	UserDetailsManager usersCustom(DataSource dataSource) {
	    JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

	    users.setUsersByUsernameQuery(
	        "SELECT d_v_email, d_v_password, IF(w_v_status = 'A', 1, 0) AS enabled " +
	        "FROM c_usuario WHERE d_v_email = ?");  

	    users.setAuthoritiesByUsernameQuery(
	        "SELECT a.d_v_email, b.d_v_perfil " +   
	        "FROM c_usuario a INNER JOIN c_perfil b " +
	        "ON (a.pk_i_perfil = b.pk_i_perfil) " +
	        "WHERE a.d_v_email = ?");               

	    return users;
	}

	/*
	 * Este método sirve para personalizar accesos a las URL's
	 * 
	 */
	@Bean
	SecurityFilterChain filtro(HttpSecurity http) throws Exception {
		// Dentro de este método, especificaremos qué URL's serán protegidas
		http.authorizeHttpRequests(authorize -> authorize
				// Los recursos estáticos no requieren autenticación
				.requestMatchers("assets/**").permitAll()

				// Las vistas publicas no requieren autorización
				.requestMatchers("/").permitAll()

				/*
				 * Asignar permisos a las URL's por ROLES En este caso los administradores
				 * tienen acceso a todas las vistas mientras que los supervisores no pueden ver
				 * el apartado de usuarios: EJEMPLO
				 * 
				 * 
				 * 
				 * .requestMatchers("/solicitudes/create/**",
				 * "/solicitudes/save/**").hasAnyAuthority("USUARIO")
				 * .requestMatchers("/solicitudes/**").hasAnyAuthority("SUPERVISOR",
				 * "ADMINISTRADOR")
				 * .requestMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR",
				 * "ADMINISTRADOR")
				 * .requestMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR",
				 * "ADMINISTRADOR")
				 * .requestMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
				 */

				// Todas las demás URL's de la aplicación requieren autenticación
				.anyRequest().authenticated());

		// El formulario del Login no requiere autenticación
		http.formLogin(form -> form.loginPage("/login")
				.failureUrl("/login?error=true")
				.permitAll());
		
		 // Ignorar CSRF para endpoints específicos
	    http.csrf(csrf -> csrf
	            .ignoringRequestMatchers("/tickets/usuarios/asignarArea")
	    );

		return http.build();

	}
	

	/*
	 * Método para encriptar las contraseñas con ByCript
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
