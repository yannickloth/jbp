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
        PARAM_REQ.Object.requireAllInstanceOf(list, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the class parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testCollectionElementsInstanceOfWithNullClass() {
        PARAM_REQ.Object.requireAllInstanceOf(
                new ArrayList<String>(), null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the collection parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testCollectionElementsInstanceOfWithNullCollection() {
        PARAM_REQ.Object.requireAllInstanceOf(null, String.class);
    }

    @Test(description = "should do nothing special")
    public void testCollectionElementsInstanceOfWithStringCollAndStringClass() {
        PARAM_REQ.Object.requireAllInstanceOf(
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
        PARAM_REQ.Object.requireAllInstanceOf(list, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is Integer and the class parameter is String",
            expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithIntegerAndNullClass() {
        PARAM_REQ.Object.requireInstanceOf(3, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithNullAndStringClass() {
        PARAM_REQ.Object.requireInstanceOf(null, String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the class parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testInstanceOfWithStringAndNullClass() {
        PARAM_REQ.Object.requireInstanceOf("hi", null);
    }

    @Test(description = "should do nothing special")
    public void testInstanceOfWithStringAndStringClass() {
        PARAM_REQ.Object.requireInstanceOf("hi", String.class);
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is an empty String",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithEmptyString() {
        PARAM_REQ.String.requireNotBlank("");
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithNull() {
        PARAM_REQ.String.requireNotBlank(null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the String is blank",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotBlankWithSpaces() {
        PARAM_REQ.String.requireNotBlank("    ");
    }

    @Test(description = "should throw an IllegalArgumentException, as the Collection is empty",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotEmptyWithEmptyCollection() {
        final Collection<String> c = new ArrayList<String>();
        PARAM_REQ.Object.requireNotEmpty(c);
    }

    @Test(description = "should do nothing special, as the Collection is filled")
    public void testNotEmptyWithFilledCollection() {
        final Collection<String> c = new ArrayList<String>();
        c.add("String1");
        c.add("String2");
        PARAM_REQ.Object.requireNotEmpty(c);
    }

    @Test(description = "should throw an IllegalArgumentException, as the Collection is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotEmptyWithNull() {
        PARAM_REQ.Object.requireNotEmpty(null);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is negative",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeNorZeroWithNegativeInteger() {
        PARAM_REQ.Number.requireNotNegative(-10);
    }

    @Test(description = "should do nothing special, as the parameter is positive")
    public void testNotNegativeNorZeroWithPositiveInteger() {
        PARAM_REQ.Number.requireNotNegative(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeNorZeroWithZeroInteger() {
        PARAM_REQ.Number.requireNotNegative(0);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is negative",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotNegativeWithNegativeInteger() {
        PARAM_REQ.Number.requireNotStrictlyNegative(-10);
    }

    @Test(description = "should do nothing special, as the parameter is positive")
    public void testNotNegativeWithPositiveInteger() {
        PARAM_REQ.Number.requireNotStrictlyNegative(10);
    }

    @Test(description = "should do nothing special, as the parameter is zero")
    public void testNotNegativeWithZeroInteger() {
        PARAM_REQ.Number.requireNotStrictlyNegative(0);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is null",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotNullWithNull() {
        PARAM_REQ.Object.requireNotNull(null);
    }

    @Test(description = "should do nothing special, as the Collection is filled")
    public void testNotNullWithString() {
        PARAM_REQ.Object.requireNotNull("notNullString");
    }

    @Test(description = "should do nothing special, as the parameter is negative")
    public void testNotPositiveNorZeroWithNegativeInteger() {
        PARAM_REQ.Number.requireNotPositive(-10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is positive",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveNorZeroWithPositiveInteger() {
        PARAM_REQ.Number.requireNotPositive(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveNorZeroWithZeroInteger() {
        PARAM_REQ.Number.requireNotPositive(0);
    }

    @Test(description = "should do nothing special, as the parameter is negative")
    public void testNotPositiveWithNegativeInteger() {
        PARAM_REQ.Number.requireNotStrictlyPositive(-10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is positive",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotPositiveWithPositiveInteger() {
        PARAM_REQ.Number.requireNotStrictlyPositive(10);
    }

    @Test(description = "should do nothing special, as the parameter is zero")
    public void testNotPositiveWithZeroInteger() {
        PARAM_REQ.Number.requireNotStrictlyPositive(0);
    }

    @Test(description = "should do nothing special, as the parameter is not zero")
    public void testNotZeroWithPositiveInteger() {
        PARAM_REQ.Number.requireNotZero(10);
    }

    @Test(description = "should throw an IllegalArgumentException, as the parameter is zero",
            expectedExceptions = {IllegalArgumentException.class})
    public void testNotZeroWithZeroInteger() {
        PARAM_REQ.Number.requireNotZero(0);
    }
}
