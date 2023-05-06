package com.security.java17.config;
import com.security.java17.services.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration  {

    private final UserAccessService userAccessService;

    @Autowired
    public SecurityConfiguration(UserAccessService userAccessService) {
        this.userAccessService = userAccessService;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .addFilterBefore(new SecurityFilter(userAccessService), BasicAuthenticationFilter.class)
//                .antMatcher("/services/data/**")
//                .csrf()
//                .disable();
//    }

}
