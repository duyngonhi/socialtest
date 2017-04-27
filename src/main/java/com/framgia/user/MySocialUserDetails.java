package com.framgia.user;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import com.framgia.model.MyUserAccount;

public class MySocialUserDetails implements SocialUserDetails {

   private static final long serialVersionUID = -5246117266247684905L;

   private List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
   private MyUserAccount myUserAccount;

   public MySocialUserDetails(MyUserAccount myUserAccount) {
       this.myUserAccount = myUserAccount;
       String role = myUserAccount.getRole();

       GrantedAuthority grant = new SimpleGrantedAuthority(role);
       this.list.add(grant);
   }

   public String getUserId() {
       return this.myUserAccount.getId();
   }

   public String getUsername() {
       return myUserAccount.getUserName();
   }

   public Collection<? extends GrantedAuthority> getAuthorities() {
       return list;
   }

   public String getPassword() {
       return myUserAccount.getPassword();
   }

   public boolean isAccountNonExpired() {
       return true;
   }

   public boolean isAccountNonLocked() {
       return true;
   }

   public boolean isCredentialsNonExpired() {
       return true;
   }

   public boolean isEnabled() {
       return true;
   }

}
