package com.googlecode.jbp.common.annotations;

import java.lang.annotation.*;

@QualifyingAnnotation
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface QualifiedAnnotation {
}
