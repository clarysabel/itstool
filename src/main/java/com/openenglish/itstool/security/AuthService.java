package com.openenglish.itstool.security;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openenglish.itstool.bo.UserBo;
import com.openenglish.itstool.entity.Role;
import com.openenglish.itstool.exception.DataAccessException;
import com.openenglish.itstool.util.ITSConstants;


@Service("userDetailsService")
public class AuthService implements UserDetailsService, AuthenticationUserDetailsService<OpenIDAuthenticationToken>{
	
	@Autowired
    private UserBo userBo;
    @Autowired
    private OpenIDUserBuilder openIDUserBuilder;
	
	private static Logger logger = Logger.getLogger(AuthService.class);
 
    public AuthService() {
    }
 
	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public OpenIDUserBuilder getOpenIDUserBuilder() {
		return openIDUserBuilder;
	}

	public void setOpenIDUserBuilder(OpenIDUserBuilder openIDUserBuilder) {
		this.openIDUserBuilder = openIDUserBuilder;
	}

	@Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.openenglish.itstool.entity.User user = null;
    	try {
			user = userBo.findByUsername(username);
			if (user == null || !user.getStatus().equals(ITSConstants.USER_STATUS_ENABLED)) {
				 throw new UsernameNotFoundException("User with open id login " + username + "  has not been found.");
			} 
		} catch (com.openenglish.itstool.exception.DataAccessException e) {
			e.printStackTrace();
		}
    	return buildUserFromUserEntity(user);
    	
    }
	
	@Override
    @Transactional
	public UserDetails loadUserDetails(OpenIDAuthenticationToken token)
			throws UsernameNotFoundException {
        OpenIDUser openIDUser = openIDUserBuilder.build(token);
        com.openenglish.itstool.entity.User userEntity = null;
        logger.debug("Trying to log in user email: " + openIDUser.getEmailAddress());
        try {
			userEntity =  userBo.findByEmail(openIDUser.getEmailAddress());
		} catch (com.openenglish.itstool.exception.DataAccessException e) {
			logger.error("Exception trying to search user entity: " + openIDUser.getEmailAddress(), e);
		}
        if (userEntity == null || !userEntity.getStatus().equals(ITSConstants.USER_STATUS_ENABLED)){
        	throw new UsernameNotFoundException("User " + openIDUser.getEmailAddress() + " not found in database");
        } else if (userEntity.getUsername()==null || userEntity.getUsername().equals("")) {
        	userEntity.setUsername(token.getIdentityUrl());
        	userEntity.setLastModified(new Timestamp(System.currentTimeMillis()));
        	try {
				userBo.save(userEntity);
			} catch (DataAccessException e) {
				logger.error("Exception trying to save user entity: " + openIDUser.getEmailAddress(), e);
	        	throw new UsernameNotFoundException("User " + openIDUser.getEmailAddress() + " found in database, unable to save Identify URL.");
			}
        } else if (!userEntity.getUsername().equals(token.getIdentityUrl())) {
        	throw new UsernameNotFoundException("User " + openIDUser.getEmailAddress() + " not found in database");
        } 
    	return buildUserFromUserEntity(userEntity);
	}
	
	@Transactional(readOnly = true)
	private User buildUserFromUserEntity(com.openenglish.itstool.entity.User user) {
		boolean enabled = user.getStatus().equals(ITSConstants.USER_STATUS_ENABLED);
		boolean accountNonExpired = !user.getStatus().equals(ITSConstants.USER_STATUS_EXPIRED);
		boolean credentialsNonExpired = !user.getStatus().equals(ITSConstants.USER_STATUS_EXPIRED);
		boolean accountNonLocked = !user.getStatus().equals(ITSConstants.USER_STATUS_BANNED);
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			authorities.add(new GrantedAuthorityImpl(role.getName()));
		}
		User sUser = new User(user.getEmail(), user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		return sUser;
	}
}
