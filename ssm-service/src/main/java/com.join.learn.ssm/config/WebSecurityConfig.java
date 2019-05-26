package com.join.learn.ssm.config;

import com.join.learn.ssm.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * spring security 配置类，当然也可以在xml中配置
 * @author join
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * 重写其中的configure参数是HttpSecurity类型的方法
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
//        http.authorizeRequests().
//                //对所有请求进行验证
//                antMatchers("/**").authenticated()
//                .and()
//
//               /* //指向我们的login页面 成功后请求/hello permitAll()方法表示不验证
//                .formLogin().loginPage("/login").permitAll()
//                .defaultSuccessUrl("/hello")
//                .and()
//                .logout().logoutSuccessUrl("/login").permitAll()*/;
        http.
                formLogin()             // 定义当需要用户登录时候，转到的登录页面。
                .and()
                .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
                .anyRequest()           // 任何请求,登录后可以访问
                .authenticated();

    }

    /**
     * 通过Autowired 获取AuthenticationManagerBuilder实例
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //设置自定义的 userDetailsService，并且设置加密方式
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

        /*auth.authenticationProvider(new AuthenticationProvider() {

            @Override
            public boolean supports(Class<?> authentication) {
                return true;
            }

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {

                //UserDetails user = (UserDetails) authentication.getPrincipal();
                //String account = user.getUsername();
                String account= (String) authentication.getPrincipal();
                String providedPassword = (String) authentication.getCredentials();
                //LOG.debug("进行用户名密码认证,mobile={}, passwd={}", mobile, providedPassword);
                UserDetailsServiceImpl customUserDetailsServiceImpl = userDetailsService;
                UserDetails user = userDetailsService.loadUserByUsername(account);
                if(!user.getPassword().equals(providedPassword)){
                    throw new SsmException("用户名或秘密不正确");
                }
                return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            }
        } );*/
    }
}
