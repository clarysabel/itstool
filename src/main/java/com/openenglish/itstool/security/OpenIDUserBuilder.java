package com.openenglish.itstool.security;

import java.util.*;


import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;

public class OpenIDUserBuilder {
    private Set<String> emailAddressAttributeNames = new HashSet<String>();
 
    public OpenIDUser build(OpenIDAuthenticationToken openIdAuthenticationToken) {
        String userLocalIdentifier = openIdAuthenticationToken.getIdentityUrl();
        String emailAddress = setUpEmailAddress(openIdAuthenticationToken);
        return new OpenIDUser(userLocalIdentifier, emailAddress);
    }
 

    private String setUpEmailAddress(OpenIDAuthenticationToken openIdAuthenticationToken) {
        for (OpenIDAttribute openIDAttribute : openIdAuthenticationToken.getAttributes()) {
            if (setContainsAndAttributeHasValue(emailAddressAttributeNames, openIDAttribute)) {
                return openIDAttribute.getValues().get(0);
            }
        }
        return null;
    }
 
    private boolean setContainsAndAttributeHasValue(Set<String> emailAddressAttributeNames, OpenIDAttribute openIDAttribute) {
        return emailAddressAttributeNames.contains(openIDAttribute.getName()) && attributeHasValue(openIDAttribute);
    }
 
    private boolean attributeHasValue(OpenIDAttribute openIDAttribute) {
        return openIDAttribute.getValues() != null && openIDAttribute.getValues().size() > 0;
    }
 

    public void setEmailAddressAttributeNames(Set<String> emailAddressAttributeNames) {
        this.emailAddressAttributeNames = emailAddressAttributeNames;
    }

	public Set<String> getEmailAddressAttributeNames() {
		return emailAddressAttributeNames;
	}
    
}