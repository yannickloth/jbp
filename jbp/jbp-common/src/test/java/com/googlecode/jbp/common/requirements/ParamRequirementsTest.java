/*
 * Copyright 2011 Yannick LOTH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.jbp.common.requirements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.testng.annotations.Test;

/**
 * Unit tests for {@code ParamValidator} operations.
 * 
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public class ParamRequirementsTest {

    @Test(description = "should do nothing special")
    public void testCollectionElementsInstanceOfWithFilledStringCollAndStringClass() {
        final List<String> list = new ArrayList<String>();
        list.add("String1");
        list.add("String2");
        ParamRequirements.INSTANCE.requireAllInstanceOf(list, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the class parameter is null",
    expectedExceptions = {IllegalArgumentException.class})
    public void testCollectionElementsInstanceOfWithNullClass() {
        ParamRequirements.INSTANCE.requireAllInstanceOf(
                new ArrayList<String>(), null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the collection parameter is null",
    expectedExceptions = {IllegalArgumentException.class})
    public void testCollectionElementsInstanceOfWithNullCollection() {
        ParamRequirements.INSTANCE.requireAllInstanceOf(null, String.class);
    }

    @Test(description = "should do nothing special")
    public void testCollectionElementsInstanceOfWithStringCollAndStringClass() {
        ParamRequirements.INSTANCE.requireAllInstanceOf(
                new ArrayList<String>(), String.class);
    }

    @SuppressWarnings("unchecked")
    @Test(description = "should throw an IllegalArgumentException, as the collection contains other types than String",
    expectedExceptions = {IllegalArgumentException.class})
    public void testCollectionElementsInstanceOfWithUncheckedCollAndStringClass() {
        @SuppressWarnings("rawtypes")
        final List list = new ArrayList();
        list.add("String1");
        list.add(Double.MAX_VALUE);
        ParamRequirements.INSTANCE.requireAllInstanceOf(list, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is Integer and the class parameter is String",
    expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithIntegerAndNullClass() {
        ParamRequirements.INSTANCE.requireInstanceOf(3, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is null",
    expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithNullAndStringClass() {
        ParamRequirements.INSTANCE.requireInstanceOf(null, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the class parameter is null",
    expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithStringAndNullClass() {
        ParamRequirements.INSTANCE.requireInstanceOf("hi", null);
    }

    @Test(description = "should do nothing special")
    public void testInstanceOfWithStringAndStringClass() {
        ParamRequirements.INSTANCE.requireInstanceOf("hi", String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is an empty String",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithEmptyString() {
        ParamRequirements.INSTANCE.requireNotBlank("");
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is null",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithNull() {
        ParamRequirements.INSTANCE.requireNotBlank(null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is blank",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithSpaces() {
        ParamRequirements.INSTANCE.requireNotBlank("    ");
    }

    @Test(description = "should throw an IllegalArgumentException, as the Collection is empty",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotEmptyWithEmptyCollection() {
        final Collection<String> c = new ArrayList<String>();
        ParamRequirements.INSTANCE.requireNotEmpty(c);
    }

    @Test(description = "should do nothing special, as the Collection is filled")
    public void testNotEmptyWithFilledCollection() {
        final Collection<String> c = new ArrayList<String>();
        c.add("String1");
        c.add("String2");
        ParamRequirements.INSTANCE.requireNotEmpty(c);
    }

    @Test(description = "should throw an IllegalArgumentException, as the Collection is null",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotEmptyWithNull() {
        ParamRequirements.INSTANCE.requireNotEmpty(null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is negative",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeNorZeroWithNegativeInteger() {
        ParamRequirements.INSTANCE.requireNotNegativeNorZero(-10);
    }

    @Test(description = "should do nothing special, as the parameter is positive")
    public void testNotNegativeNorZeroWithPositiveInteger() {
        ParamRequirements.INSTANCE.requireNotNegativeNorZero(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeNorZeroWithZeroInteger() {
        ParamRequirements.INSTANCE.requireNotNegativeNorZero(0);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is negative",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeWithNegativeInteger() {
        ParamRequirements.INSTANCE.requireNotNegative(-10);
    }

    @Test(description = "should do nothing special, as the parameter is positive")
    public void testNotNegativeWithPositiveInteger() {
        ParamRequirements.INSTANCE.requireNotNegative(10);
    }

    @Test(description = "should do nothing special, as the parameter is zero")
    public void testNotNegativeWithZeroInteger() {
        ParamRequirements.INSTANCE.requireNotNegative(0);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is null",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotNullWithNull() {
        ParamRequirements.INSTANCE.requireNotNull(null);
    }

    @Test(description = "should do nothing special, as the Collection is filled")
    public void testNotNullWithString() {
        ParamRequirements.INSTANCE.requireNotNull("notNullString");
    }

    @Test(description = "should do nothing special, as the parameter is negative")
    public void testNotPositiveNorZeroWithNegativeInteger() {
        ParamRequirements.INSTANCE.requireNotPositiveNorZero(-10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is positive",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveNorZeroWithPositiveInteger() {
        ParamRequirements.INSTANCE.requireNotPositiveNorZero(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveNorZeroWithZeroInteger() {
        ParamRequirements.INSTANCE.requireNotPositiveNorZero(0);
    }

    @Test(description = "should do nothing special, as the parameter is negative")
    public void testNotPositiveWithNegativeInteger() {
        ParamRequirements.INSTANCE.requireNotPositive(-10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is positive",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveWithPositiveInteger() {
        ParamRequirements.INSTANCE.requireNotPositive(10);
    }

    @Test(description = "should do nothing special, as the parameter is zero")
    public void testNotPositiveWithZeroInteger() {
        ParamRequirements.INSTANCE.requireNotPositive(0);
    }

    @Test(description = "should do nothing special, as the parameter is not zero")
    public void testNotZeroWithPositiveInteger() {
        ParamRequirements.INSTANCE.requireNotZero(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
    expectedExceptions = {IllegalArgumentException.class})
    public void testNotZeroWithZeroInteger() {
        ParamRequirements.INSTANCE.requireNotZero(0);
    }
}
