package com.openenglish.itstool.security;

import java.io.Serializable;

public class OpenIDUser implements Serializable {

	private static final long serialVersionUID = -7161551544642102842L;
	
	private String userLocalIdentifier;
    private String emailAddress;
    private String fullName;
    private String loginReplacement;
 
    public OpenIDUser(String userLocalIdentifier, String emailAddress, String fullName, String loginReplacement) {
        this.userLocalIdentifier = userLocalIdentifier;
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.loginReplacement = loginReplacement;
    }
 
    public String getUserLocalIdentifier() {
        return userLocalIdentifier;
    }
 
    public String getEmailAddress() {
        return emailAddress;
    }
 
    public String getFullName() {
        return fullName;
    }
 
    public String getLoginReplacement() {
        return loginReplacement;
    }
}