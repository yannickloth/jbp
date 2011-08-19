package com.googlecode.jbp.common.annotations;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface QualifyingAnnotation {
}
