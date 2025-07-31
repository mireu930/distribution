package com.distribution.app.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	WebSecurityCustomizer securityCustomizer() {
		return (web)->{
			web.ignoring().requestMatchers("/css/**","/js/**")
			.requestMatchers("/images/**","/imag/**","/vendor/**");
		};
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
					.cors(cors->cors.configurationSource(corsConfigurationSource()))
					.csrf(csrf->csrf.disable())
					.authorizeHttpRequests(authorizeRequest->{
						authorizeRequest
							.anyRequest().permitAll();
					})
					
					.formLogin(formLogin->{
						formLogin.disable();
					})
					
					.sessionManagement((session)->{
				 		session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				 		;
				 	})
				 	
				 	.httpBasic(httpBasic->httpBasic.disable())
				 	;
		
		return httpSecurity.build();
					
	}
	
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		
		corsConfiguration.setAllowedOriginPatterns(List.of("*"));
		corsConfiguration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","PATCH","OPTIONS"));
		
		 UrlBasedCorsConfigurationSource basedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		 //어떤url을 적용할것인가
		 basedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		 
		 return basedCorsConfigurationSource;
	}

}
