package com.openenglish.itstool.security;

import java.util.*;

import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;

import antlr.StringUtils;

public class OpenIDUserBuilder {
    private Set<String> emailAddressAttributeNames = new HashSet<String>();
    private Set<String> firstNameAttributeNames = new HashSet<String>();
    private Set<String> lastNameAttributeNames = new HashSet<String>();
    private Set<String> fullNameAttributeNames = new HashSet<String>();
 
    public OpenIDUser build(OpenIDAuthenticationToken openIdAuthenticationToken) {
        String userLocalIdentifier = openIdAuthenticationToken.getIdentityUrl();
        String emailAddress = setUpEmailAddress(openIdAuthenticationToken);
        String fullName = setUpFullName(openIdAuthenticationToken);
        String loginReplacement = setUpLoginReplacement(openIdAuthenticationToken);
        return new OpenIDUser(userLocalIdentifier, emailAddress, fullName, loginReplacement);
    }
 
    private String setUpLoginReplacement(OpenIDAuthenticationToken openIdAuthenticationToken) {
        String separator = ".";
        return getNameFromFirstAndLast(openIdAuthenticationToken, separator).toLowerCase();
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
 
    private String setUpFullName(OpenIDAuthenticationToken openIdAuthenticationToken) {
        String fullName = getAttributeValue(openIdAuthenticationToken, fullNameAttributeNames);
        if (fullName == null) {
            String separator = " ";
            fullName = getNameFromFirstAndLast(openIdAuthenticationToken, separator);
        }
 
        return fullName;
    }
 
    private String getAttributeValue(OpenIDAuthenticationToken openIdAuthenticationToken, Set<String> stringSet) {
        for (OpenIDAttribute openIDAttribute : openIdAuthenticationToken.getAttributes()) {
            if (attributeHasValue(openIDAttribute)) {
                if (stringSet.contains(openIDAttribute.getName())) {
                    return openIDAttribute.getValues().get(0);
                }
            }
        }
        return null;
    }
 
    private String getNameFromFirstAndLast(OpenIDAuthenticationToken openIdAuthenticationToken, String separator) {
        String firstName = getAttributeValue(openIdAuthenticationToken, firstNameAttributeNames);
        String lastName = getAttributeValue(openIdAuthenticationToken, lastNameAttributeNames);
        return firstName + " " + lastName; 
    }
 
    public void setEmailAddressAttributeNames(Set<String> emailAddressAttributeNames) {
        this.emailAddressAttributeNames = emailAddressAttributeNames;
    }
 
    public void setFirstNameAttributeNames(Set<String> firstNameAttributeNames) {
        this.firstNameAttributeNames = firstNameAttributeNames;
    }
 
    public void setLastNameAttributeNames(Set<String> lastNameAttributeNames) {
        this.lastNameAttributeNames = lastNameAttributeNames;
    }
 
    public void setFullNameAttributeNames(Set<String> fullNameAttributeNames) {
        this.fullNameAttributeNames = fullNameAttributeNames;
    }
}