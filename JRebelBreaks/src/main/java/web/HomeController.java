package web;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.sec.SignedInUserImplDetails;

/**
 * @author MariusAnton
 *
 */
@Controller
public class HomeController {

  @RequestMapping(value = { "/home"}, method = RequestMethod.GET)
  public void home() throws IOException {

	  System.out.println("7");
	  
	  System.out.println("Sign in principal " + SecurityContextHolder.getContext().getAuthentication()
              .getPrincipal());
	  
	  if( SecurityContextHolder.getContext().getAuthentication()
              .getPrincipal() instanceof SignedInUserImplDetails){
		  SignedInUserImplDetails userDetails = ((SignedInUserImplDetails) SecurityContextHolder.getContext().getAuthentication()
				  .getPrincipal());
		  
		  System.out.println("Sign in user roles : " + userDetails.getAuthorities());
	  }
	  
  }

}
