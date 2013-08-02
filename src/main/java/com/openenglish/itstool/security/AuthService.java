package com.openenglish.itstool.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openenglish.itstool.dao.UserDao;

@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class AuthService implements UserDetailsService {
	
	@Autowired
    private UserDao userDao;
 
    // required by CGLIB
    public AuthService() {
    }
 

    public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    	System.out.println(username);
    	System.out.println(userDao == null);
        //User user = userRepository.findByLoginOpenId(username);
       throwExceptionIfNotFound(null, username);
        //Build UserDetails Spring 
        //return new AuthenticationUserDetails(user);
        return null;
    }
 
    private void throwExceptionIfNotFound(User user, String loginOpenId) {
        if (user == null) {
            throw new UsernameNotFoundException("User with open id login " + loginOpenId + "  has not been found.");
        }
    }
}
/*public class AuthService implements UserDetailsService {

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

}*/
