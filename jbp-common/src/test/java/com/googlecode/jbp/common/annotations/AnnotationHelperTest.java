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

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.util.List;

public class AnnotationHelperTest {

    @Test
    public void testIsQualifiedAnnotationPresentNonePresent() {
        Assert.assertFalse(AnnotationHelper.isQualifiedAnnotationPresent(getClass(), QualifyingAnnotation.class), "The class has no qualified annotations but the method says it has...");
    }

    @Test
    public void testIsQualifiedAnnotationPresentOnePresent() {
        Assert.assertTrue(AnnotationHelper.isQualifiedAnnotationPresent(AnnotatedClass.class, QualifyingAnnotation.class), "The class has no qualified annotations but the method says it has...");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIsQualifiedAnnotationPresentAnnotParamNull() {
        AnnotationHelper.isQualifiedAnnotationPresent(getClass(), null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIsQualifiedAnnotationPresentObjectClassParamNull() {
        AnnotationHelper.isQualifiedAnnotationPresent(null, null);
    }

    @Test
    public void testGetQualifiedAnnotationsNone() {
        List<Annotation> annots = AnnotationHelper.getQualifiedAnnotations(getClass(), QualifyingAnnotation.class);
        Assert.assertEquals(annots.size(), 0, "No qualified annotations should be returned in the list.");
    }

    @Test
    public void testGetQualifiedAnnotationsOne() {
        List<Annotation> annots = AnnotationHelper.getQualifiedAnnotations(AnnotatedClass.class, QualifyingAnnotation.class);
        Assert.assertEquals(annots.size(), 1, "Exactly one qualified annotations should be returned in the list.");
    }

    @Test
    public void testGetQualifiedAnnotationsTwo() {
        List<Annotation> annots = AnnotationHelper.getQualifiedAnnotations(TwiceAnnotatedClass.class, QualifyingAnnotation.class);
        Assert.assertEquals(annots.size(), 2, "Exactly two qualified annotations should be returned in the list.");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetQualifiedAnnotationsAnnotParamNull() {
        AnnotationHelper.getQualifiedAnnotations(getClass(), null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetQualifiedAnnotationsObjectClassParamNull() {
        AnnotationHelper.getQualifiedAnnotations(null, null);
    }
}
