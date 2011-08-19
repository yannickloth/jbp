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

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.googlecode.jbp.common.requirements.ParamRequirements.PARAM_REQ;

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
        PARAM_REQ.requireAllInstanceOf(list, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the class parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testCollectionElementsInstanceOfWithNullClass() {
        PARAM_REQ.requireAllInstanceOf(
                new ArrayList<String>(), null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the collection parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testCollectionElementsInstanceOfWithNullCollection() {
        PARAM_REQ.requireAllInstanceOf(null, String.class);
    }

    @Test(description = "should do nothing special")
    public void testCollectionElementsInstanceOfWithStringCollAndStringClass() {
        PARAM_REQ.requireAllInstanceOf(
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
        PARAM_REQ.requireAllInstanceOf(list, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is Integer and the class parameter is String",
            expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithIntegerAndNullClass() {
        PARAM_REQ.requireInstanceOf(3, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithNullAndStringClass() {
        PARAM_REQ.requireInstanceOf(null, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the class parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithStringAndNullClass() {
        PARAM_REQ.requireInstanceOf("hi", null);
    }

    @Test(description = "should do nothing special")
    public void testInstanceOfWithStringAndStringClass() {
        PARAM_REQ.requireInstanceOf("hi", String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is an empty String",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithEmptyString() {
        PARAM_REQ.requireNotBlank("");
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithNull() {
        PARAM_REQ.requireNotBlank(null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is blank",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithSpaces() {
        PARAM_REQ.requireNotBlank("    ");
    }

    @Test(description = "should throw an IllegalArgumentException, as the Collection is empty",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotEmptyWithEmptyCollection() {
        final Collection<String> c = new ArrayList<String>();
        PARAM_REQ.requireNotEmpty(c);
    }

    @Test(description = "should do nothing special, as the Collection is filled")
    public void testNotEmptyWithFilledCollection() {
        final Collection<String> c = new ArrayList<String>();
        c.add("String1");
        c.add("String2");
        PARAM_REQ.requireNotEmpty(c);
    }

    @Test(description = "should throw an IllegalArgumentException, as the Collection is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotEmptyWithNull() {
        PARAM_REQ.requireNotEmpty(null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is negative",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeNorZeroWithNegativeInteger() {
        PARAM_REQ.requireNotNegative(-10);
    }

    @Test(description = "should do nothing special, as the parameter is positive")
    public void testNotNegativeNorZeroWithPositiveInteger() {
        PARAM_REQ.requireNotNegative(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeNorZeroWithZeroInteger() {
        PARAM_REQ.requireNotNegative(0);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is negative",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeWithNegativeInteger() {
        PARAM_REQ.requireNotStrictlyNegative(-10);
    }

    @Test(description = "should do nothing special, as the parameter is positive")
    public void testNotNegativeWithPositiveInteger() {
        PARAM_REQ.requireNotStrictlyNegative(10);
    }

    @Test(description = "should do nothing special, as the parameter is zero")
    public void testNotNegativeWithZeroInteger() {
        PARAM_REQ.requireNotStrictlyNegative(0);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotNullWithNull() {
        PARAM_REQ.requireNotNull(null);
    }

    @Test(description = "should do nothing special, as the Collection is filled")
    public void testNotNullWithString() {
        PARAM_REQ.requireNotNull("notNullString");
    }

    @Test(description = "should do nothing special, as the parameter is negative")
    public void testNotPositiveNorZeroWithNegativeInteger() {
        PARAM_REQ.requireNotPositive(-10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is positive",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveNorZeroWithPositiveInteger() {
        PARAM_REQ.requireNotPositive(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveNorZeroWithZeroInteger() {
        PARAM_REQ.requireNotPositive(0);
    }

    @Test(description = "should do nothing special, as the parameter is negative")
    public void testNotPositiveWithNegativeInteger() {
        PARAM_REQ.requireNotStrictlyPositive(-10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is positive",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveWithPositiveInteger() {
        PARAM_REQ.requireNotStrictlyPositive(10);
    }

    @Test(description = "should do nothing special, as the parameter is zero")
    public void testNotPositiveWithZeroInteger() {
        PARAM_REQ.requireNotStrictlyPositive(0);
    }

    @Test(description = "should do nothing special, as the parameter is not zero")
    public void testNotZeroWithPositiveInteger() {
        PARAM_REQ.requireNotZero(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotZeroWithZeroInteger() {
        PARAM_REQ.requireNotZero(0);
    }
}
