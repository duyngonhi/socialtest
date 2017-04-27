package com.framgia.ulti;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.framgia.model.MyUserAccount;
import com.framgia.user.MySocialUserDetails;
 
public class SecurityUtil {
 
  
   // Tự động đăng nhập.
   public static void logInUser(MyUserAccount user) {
 
       MySocialUserDetails userDetails = new MySocialUserDetails(user);
 
       Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
               userDetails.getAuthorities());
       SecurityContextHolder.getContext().setAuthentication(authentication);
   }
  
}
