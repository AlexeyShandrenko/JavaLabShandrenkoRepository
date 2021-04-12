package ru.itis.javalab.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<ValidMatchPassword, Object> {

    private String passwordPropertyName;
    private String passwordRepeatPropertyName;


    @Override
    public void initialize(ValidMatchPassword constraintAnnotation) {
        this.passwordPropertyName = constraintAnnotation.password();
        this.passwordRepeatPropertyName = constraintAnnotation.password_repeat();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Object password = new BeanWrapperImpl(value).getPropertyValue(passwordPropertyName);
        Object password_repeat = new BeanWrapperImpl(value).getPropertyValue(passwordRepeatPropertyName);

        return password != null && password.equals(password_repeat);
    }
}
