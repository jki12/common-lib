package com.nhnacademy.common.validation.validator;

import com.nhnacademy.common.validation.annotation.PasswordMatches;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;

@Slf4j
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    private String password;
    private String passwordConfirm;

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        this.password = constraintAnnotation.passwordField();
        this.passwordConfirm = constraintAnnotation.passwordConfirmField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return Objects.equals(getValue(value, password), getValue(value, passwordConfirm));
    }

    private Object getValue(Object obj, String name) {
        Field f = ReflectionUtils.findField(obj.getClass(), name);

        if (f == null) {
            throw new IllegalArgumentException();
        }

        ReflectionUtils.makeAccessible(f);

        try {
            Object value = f.get(obj);

            log.info("value : {}", value);
            return value;
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
