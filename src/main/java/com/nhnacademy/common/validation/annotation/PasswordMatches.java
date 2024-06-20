package com.nhnacademy.common.validation.annotation;

import com.nhnacademy.common.validation.validator.PasswordMatchesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
public @interface PasswordMatches {

    String message() default "비밀번호가 일치하지 않습니다.";

    String passwordField() default "password";

    String passwordConfirmField() default "passwordConfirm";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
