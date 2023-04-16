package com.bitirme.web.Security;

import com.bitirme.web.CustomUserDetails.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomUserDetails userDetails=(CustomUserDetails)authentication.getPrincipal();
        System.out.println("Username"+userDetails.getUsername());
        Collection<? extends GrantedAuthority> authorities=userDetails.getAuthorities();

        AtomicReference<String> role= new AtomicReference<>("");
        authorities.forEach(auth-> role.set(auth.getAuthority()));

        if(role.get().equals("ADMIN")){
            response.sendRedirect("/home");
        }
        else if(role.get().equals("USER")){
            response.sendRedirect("/ogrenci-panel");
        }
    }
}
