package com.trgs.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class User extends org.springframework.security.core.userdetails.User
{
   public User( String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
      boolean accountNonLocked, Collection< GrantedAuthority > authorities )
   {
      super( username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities );
   }

   public User()
   {
      super( "username", "password", true, true, true, true, AuthorityUtils.NO_AUTHORITIES );
   }

   private static final long serialVersionUID = 2018381185126758702L;

   // private boolean enable;
   // private Collection< GrantedAuthority > authorities;
   // private String password;
   // private String username;
   private Map< String, String > details = new HashMap< String, String >();

   public void addDetail( String key, String value )
   {
      details.put( key, value );
   }

   public String getDetail( String key )
   {
      return details.get( key );
   }

   public String getPassword()
   {
      return super.getPassword();
   }

   public String getUsername()
   {
      return super.getUsername();
   }

   public boolean isAccountNonExpired()
   {
      return super.isAccountNonExpired();
   }

   public boolean isAccountNonLocked()
   {
      return super.isAccountNonLocked();
   }

   public boolean isCredentialsNonExpired()
   {
      return false;
   }

   public boolean isEnabled()
   {
      return super.isEnabled();
   }

   public Collection< GrantedAuthority > getAuthorities()
   {
      return super.getAuthorities();
   }


}
