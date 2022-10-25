package br.com.agencia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.agencia.services.UserDetailsServiceImpl;

//Mapeia URL, endereços, autoriza ou bloqueia acesso a URL
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	// Configura as solicitações de acesso por HTTP
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().antMatchers("/resources/***").permitAll()
				.antMatchers("/", "/contato", "/destino", "/formCadastro", "/acesso", "/promoint", "/promonacional").permitAll().antMatchers("/icons/***").permitAll().antMatchers("/css/***").permitAll()
				.anyRequest().authenticated().and()
		
		.formLogin().and().httpBasic();
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
		.logoutSuccessUrl("/login");
		
		http.rememberMe()
		.key("chaverememberme");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
