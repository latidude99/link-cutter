package com.latidude99.links.util;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LinkValidator implements ConstraintValidator<LinkConstraint, String> {

    @Override
    public void initialize(LinkConstraint linkConstraint) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regex = "(http(s)?://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ;,./?%&=]*)?";
        if(value == null)
            return false;
        if(value.length() < 4)
            return false;
        if(value.contains(" "))
            return false;
        if(value.matches(regex))
            return true;
        else
            return true;
    }
}
