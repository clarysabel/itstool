package com.openenglish.itstool.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openenglish.itstool.bean.Role;
import com.openenglish.itstool.bo.UserBo;
import com.openenglish.itstool.util.ITSConstants;

@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class AuthService implements UserDetailsService {

	@Autowired
	private UserBo userBo;
	
	private static Logger logger = Logger.getLogger(AuthService.class);

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException, DataAccessException {

		com.openenglish.itstool.bean.User userEntity = null;
		
		try {
			userEntity = userBo.findByEmail(email);
		} catch (com.openenglish.itstool.exception.DataAccessException dae) {
			logger.error("There was an error obtaining user");
		}
		if (userEntity == null)
			throw new UsernameNotFoundException("user not found");

		return buildUserFromUserEntity(userEntity);
	}

	@Transactional(readOnly = true)
	User buildUserFromUserEntity(com.openenglish.itstool.bean.User user) {

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

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserDao(UserBo userBo) {
		this.userBo = userBo;
	}

}
