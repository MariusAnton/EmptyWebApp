package web.sec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author MariusAnton
 *
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService{

  
  @Override
  public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException {
	  
	System.out.println("Sign in using username " + username);  
	  
	SignedInUserImplDetails userDetails = new SignedInUserImplDetails("test", "test");
	userDetails.addRole(Roles.USER);  
	
    return userDetails;
  }

}
