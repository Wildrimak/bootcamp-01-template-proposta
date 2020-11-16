package br.com.zup.proposta.api.configurations;

//@Configuration
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter */ {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests(authorizeRequests -> 
//			authorizeRequests
//				.antMatchers(HttpMethod.GET, "/propostas/**").hasAuthority("SCOPE_propostas:read")
//				.antMatchers(HttpMethod.GET, "/cartoes/**").hasAuthority("SCOPE_cartoes:read")
//				.antMatchers(HttpMethod.POST, "/cartoes/**").hasAuthority("SCOPE_cartoes:write")
//				.antMatchers(HttpMethod.POST, "/propostas/**").hasAuthority("SCOPE_propostas:write")
//				.anyRequest().authenticated())
//		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//	}

}
