package com.ing.meta.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("@authorise.checkUserHasExtraRole(authentication)")
public @interface ExtraUser {

}
