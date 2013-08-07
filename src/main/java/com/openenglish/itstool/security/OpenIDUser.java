package com.openenglish.itstool.security;

import java.io.Serializable;

public class OpenIDUser implements Serializable {

	private static final long serialVersionUID = -7161551544642102842L;
	
	private String userLocalIdentifier;
    private String emailAddress;
 
    public OpenIDUser(String userLocalIdentifier, String emailAddress) {
        this.userLocalIdentifier = userLocalIdentifier;
        this.emailAddress = emailAddress;
    }

	public String getUserLocalIdentifier() {
		return userLocalIdentifier;
	}

	public void setUserLocalIdentifier(String userLocalIdentifier) {
		this.userLocalIdentifier = userLocalIdentifier;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
 
}