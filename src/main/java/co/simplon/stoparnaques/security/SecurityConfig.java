package co.simplon.stoparnaques.security;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Value("${stoparnaques.auth.rounds}")
    private int rounds;

    @Value("${stoparnaques.security.jwt.expiration}")
    private long tokenExpiration;

    @Value("${stoparnaques.security.jwt.issuer}")
    private String issuer;
    @Value("${stoparnaques.security.jwt.expiration}")
    private long expiration;
    @Value("${stoparnaques.security.jwt.zoneId}")
    private String zoneId;
    @Value("${stoparnaques.security.jwt.secret}")
    private String secret;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http)
	    throws Exception {
	http.cors(Customizer.withDefaults())
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests((authz) -> {
		    authz.requestMatchers(HttpMethod.POST,
			    "/users", "/users/sign-in",
			    "/articles", "/send-mail",
			    "/forms").permitAll()
			    .requestMatchers(HttpMethod.GET,
				    "/categories",
				    "/articles/{id}/detail",
				    "/roles", "/disputes",
				    "/articles/list-articles",
				    "forms/list-forms",
				    "/send-mail")
			    .permitAll()
			    .requestMatchers(HttpMethod.GET,
				    "/articles/articleLastAdded")
			    .hasAuthority("ADMIN")
			    .requestMatchers(
				    HttpMethod.DELETE,
				    "articles/byId/{id}")
			    .hasAuthority("ADMIN")
			    .requestMatchers(
				    HttpMethod.PATCH,
				    "articles/{id}")
			    .hasAuthority("ADMIN")
			    .anyRequest().authenticated();
		}

		).oauth2ResourceServer((oauth2) -> oauth2
			.jwt(Customizer.withDefaults()));
	;
	return http.build();

    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
	JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
	authoritiesConverter
		.setAuthoritiesClaimName("role");
	authoritiesConverter.setAuthorityPrefix("");
	JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
	authenticationConverter
		.setJwtGrantedAuthoritiesConverter(
			authoritiesConverter);
	return authenticationConverter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthHelper authHelper() {
	Algorithm algorithm = Algorithm.HMAC256(secret);
	PasswordEncoder encoder = new BCryptPasswordEncoder(
		rounds);
	return new AuthHelper.Builder().algorithm(algorithm)
		.passwordEncoder(encoder).issuer(issuer)
		.expiration(tokenExpiration).build();
    }

    @Bean
    JwtDecoder jwtDecoder() throws Exception {
	SecretKey key = new SecretKeySpec(secret.getBytes(),
		"HmacSHA256");
	return NimbusJwtDecoder.withSecretKey(key).build();
    }

}