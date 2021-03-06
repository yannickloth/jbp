/*
 *  Copyright 2011 Yannick LOTH.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.googlecode.jbp.common.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.googlecode.jbp.common.requirements.Reqs.PARAM_REQ;

/**
 * Provides utility methods process annotations.
 *
 * @author Yannick LOTH
 */
public final class AnnotationHelper {

    private AnnotationHelper() {
    }

    /**
     * Checks if a class has specific qualified annotations (these annotations are, in turn, also annotated).
     *
     * @param classParam               The class that may have a qualified annotations.
     * @param annotationQualifierClass The annotations that may qualifie the annotations on the class parameter.
     * @return {@code true} if the class has a qualified annotations, {@code false} else.
     */
    public static boolean isQualifiedAnnotationPresent(final Class<?> classParam, final Class<? extends Annotation> annotationQualifierClass) {
        validateParametersForQualifiedAnnotationsOperations(classParam, annotationQualifierClass);
        final Annotation[] annotations = classParam.getAnnotations();
        for (final Annotation annotation : annotations) {
            if (annotation.annotationType().isAnnotationPresent(annotationQualifierClass)) {
                return true;
            }
        }
        return false;
    }

    private static void validateParametersForQualifiedAnnotationsOperations(final Class<?> classParam, final Class<? extends Annotation> annotationQualifierClass) {
        PARAM_REQ.Object.requireNotNull(classParam, "The annotated class must not be null.");
        PARAM_REQ.Object.requireNotNull(annotationQualifierClass, "The qualifying annotation class must not be null.");
        final Target targetAnnot = annotationQualifierClass.getAnnotation(Target.class);
        final ElementType[] elementTypes = targetAnnot.value();
        PARAM_REQ.Logic.requireTrue(Arrays.asList(elementTypes).contains(ElementType.ANNOTATION_TYPE), "The specified annotations qualifier class must have the target element type ANNOTATION_TYPE, but does not.");
        PARAM_REQ.Logic.requireTrue(annotationQualifierClass.isAnnotation(), "Parameter 'annotationQualifierClass' must be the Class of an annotations type, but is not.");
    }

    /**
     * Returns all qualified annotations of the specified class.
     *
     * @param classParam               The class that may have qualified annotations.
     * @param annotationQualifierClass The class of the annotations that may qualify other annotations.
     * @return A {@code Set<Annotation>} with all found qualified annotations on the class.  May be an empty list, but must not be {@code null}.
     */
    public static Set<Annotation> getQualifiedAnnotations(final Class<?> classParam, final Class<? extends Annotation> annotationQualifierClass) {
        validateParametersForQualifiedAnnotationsOperations(classParam, annotationQualifierClass);
        final Set<Annotation> qualifiedAnnotations = new HashSet<Annotation>();
        final Annotation[] annotations = classParam.getAnnotations();
        for (final Annotation annotation : annotations) {
            if (annotation.annotationType().isAnnotationPresent(annotationQualifierClass)) {
                qualifiedAnnotations.add(annotation);
            }
        }
        return Collections.unmodifiableSet(qualifiedAnnotations);
    }
}
