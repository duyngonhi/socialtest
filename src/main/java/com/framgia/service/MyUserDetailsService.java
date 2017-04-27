package com.framgia.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.stereotype.Service;

import com.framgia.dao.MyUserAccountDAO;
import com.framgia.model.MyUserAccount;
import com.framgia.user.MySocialUserDetails;
 
  
// Lấy thông tin User dưới database.
@Service
public class MyUserDetailsService implements UserDetailsService {
 
  @Autowired
  private MyUserAccountDAO myUserAccountDAO;
 
  public MyUserDetailsService() {
 
  }
 
  
  // (Phương thức này được sử dụng bởi Spring Security API).
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
 
      MyUserAccount myUserAccount = myUserAccountDAO.findByUserName(userName);
 
      if (myUserAccount == null) {
          throw new UsernameNotFoundException("No user found with userName: " + userName);
      }
   
      // Chú ý: SocialUserDetails mở rộng từ interface UserDetails.
      SocialUserDetails principal = new MySocialUserDetails(myUserAccount);
 
      return principal;
  }
 
}