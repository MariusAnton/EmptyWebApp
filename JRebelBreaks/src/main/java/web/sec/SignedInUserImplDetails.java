package web.sec;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author MariusAnton
 *
 */
public class SignedInUserImplDetails implements UserDetails {

  private String _username;
  private String _password;
  private Collection<GrantedAuthority> _authorities;
  

  public SignedInUserImplDetails(String username, String password) {
    _username = username;
    _password = password;
  }  

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return _authorities;
  }

  public void addRole(String roleName) {
    if (_authorities == null) {
      _authorities = new ArrayList<GrantedAuthority>();
    }

    _authorities.add(new SimpleGrantedAuthority(roleName));
  }
  
  /**
   * Checks if current authorities contains given role.
   * 
   * @param roleName
   * @return
   */
  public boolean hasRole(String roleName) {

    if (_authorities != null) {
      for (GrantedAuthority ga : _authorities) {
        if (ga.getAuthority().equals(roleName)) {
          return true;
        }
      }
    }

    return false;
  }    
  
  @Override
  public String getPassword() {
    return _password;
  }   

  @Override
  public String getUsername() {
    return _username;
  }
  
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

} 