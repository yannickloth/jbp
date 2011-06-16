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

import java.io.File;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Defines common methods to check for required application state.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface IRequirements {

    /**
     * Checks that all elements of the specified collection are instances of the
     * specified class.
     *
     * @param collParam     The specified collection.
     * @param klassParam    The class which all specified collection's elements should be
     *                      instances of.
     * @param messagesParam Additional messages with more detail.
     */
    <T extends Collection<?>> T requireAllInstanceOf(final T collParam,
                                                     final Class<?> klassParam, final String... messagesParam);

    /**
     * Requires that all predicates are {@code true}. At least one
     * predicate must be specified.
     *
     * @param predicatesParam The specified predicates.
     * @return {@code true} if all predicates are {@code true}.
     */
    boolean requireConjunction(final boolean... predicatesParam);

    /**
     * Checks that the specified {@code File} instance refers to a
     * directory.
     *
     * @param fileParam     The specified file. Must not be {@code null}.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file.
     */
    File requireDirectory(final File fileParam, final String... messagesParam);

    /**
     * Checks that the specified {@code String} instance is a path that
     * refers to a directory.
     *
     * @param filePathParam The specified file path. Must not be blank.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file path.
     */
    String requireDirectory(final String filePathParam,
                            final String... messagesParam);

    /**
     * Checks that there is a disjunction between the specified predicates. In
     * case there is only one predicate, the disjunction is present if the
     * predicate is {@code true}. Remember that the values of the
     * predicates are calculated eagerly, before the execution of the method.
     *
     * @param predicatesParam The specified predicates.
     * @return Returns {@code true} if at least one predicate is
     *         {@code true}.
     */
    boolean requireDisjunction(final boolean... predicatesParam);

    /**
     * Checks that there is a disjunction between the two specified predicates.
     *
     * @param firstPredicateParam  The first predicate.
     * @param secondPredicateParam The second predicate.
     * @return Returns {@code true} if exactly one predicate is
     *         {@code true}.
     */
    boolean requireExclusiveDisjunction(final boolean firstPredicateParam,
                                        final boolean secondPredicateParam);

    /**
     * Checks that the specified {@code File} instance refers to an
     * existing file.
     *
     * @param fileParam     The specified file. Must not be {@code null}.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file.
     */
    File requireExistingFile(final File fileParam,
                             final String... messagesParam);

    /**
     * Checks that the specified {@code String} instance is a path that
     * refers to an existing file.
     *
     * @param filePathParam The specified file path. Must not be blank.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file path.
     */
    String requireExistingFile(final String filePathParam,
                               final String... messagesParam);

    /**
     * Checks that the specified expression returns false.
     *
     * @param boolParam     The expression.
     * @param messagesParam additional messages with more detail.
     */
    boolean requireFalse(final boolean boolParam, final String... messagesParam);

    Calendar requireFutureInstant(final Calendar calendarParam,
                                  final String... messagesParam);

    Date requireFutureInstant(final Date dateParam,
                              final String... messagesParam);

    /**
     * Checks that the specified object is an instance of the specified class.
     *
     * @param objParam      The specified object.
     * @param klassParam    The class which the specified object should be an instance of.
     * @param messagesParam additional messages with more detail.
     */
    <T> T requireInstanceOf(final T objParam, final Class<?> klassParam,
                            final String... messagesParam);

    /**
     * Checks that at least one reference is not null.
     *
     * @param objectsParam The references to objects that may be null.
     */
    Object[] requireNotAllSimultaneouslyNull(final Object... objectsParam);

    /**
     * Checks that at least one of the specified objects is not {@code null}.
     *
     * @param <T>           The type of the collection of specified objects.
     * @param coll          The collection of specified objects.
     * @param messagesParam additional messages with more detail.
     * @return The collection of specified objects.
     */
    <T extends Collection<?>> T requireNotAllSimultaneouslyNull(final T coll,
                                                                final String... messagesParam);

    /**
     * Checks that a string object is not blank (null or empty or only spaces).
     *
     * @param strParam      The string.
     * @param messagesParam additional messages with more detail.
     */
    String requireNotBlank(final String strParam, final String... messagesParam);

    /**
     * Checks that a collection is not empty. The specified collection must not
     * be null.
     *
     * @param collParam     The collection to check for emptyness.
     * @param messagesParam additional messages with more detail.
     */
    <T extends Collection<?>> T requireNotEmpty(final T collParam,
                                                final String... messagesParam);

    /**
     * Checks that the specified {@code File} instance refers to a non
     * existing file.
     *
     * @param fileParam     The specified file. Must not be {@code null}.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file.
     */
    File requireNotExistingFile(final File fileParam,
                                final String... messagesParam);

    /**
     * Checks that the specified {@code String} instance is a path that
     * refers to a non existing file.
     *
     * @param filePathParam The specified file path. Must not be blank.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file path.
     */
    String requireNotExistingFile(final String filePathParam,
                                  final String... messagesParam);

    /**
     * Checks that the specified number is not negative (&lt;0).
     *
     * @param n             The specified number.
     * @param messagesParam additional messages with more detail.
     */
    <T extends Number> T requireNotNegative(final T n,
                                            final String... messagesParam);

    /**
     * Checks that the specified number is not negative (&lt;0) nor zero (0).
     *
     * @param n             The specified number.
     * @param messagesParam additional messages with more detail.
     */
    <T extends Number> T requireNotNegativeNorZero(final T n,
                                                   final String... messagesParam);

    /**
     * Checks that an object is not null. Example: <blockquote>
     * <p/>
     * <pre>
     * public Foo(Bar bar) {
     *     this.bar = Objects.requireNotNull(bar);
     * }
     * </pre>
     * <p/>
     * </blockquote>
     *
     * @param <T>           type of the object.
     * @param objParam      The object.
     * @param messagesParam additional messages with more detail.
     */
    <T> T requireNotNull(final T objParam, final String... messagesParam);

    /**
     * Checks that the specified number is not positive (&gt;0).
     *
     * @param messagesParam additional messages with more detail.
     * @param n             The specified number.
     */
    <T extends Number> T requireNotPositive(final T n,
                                            final String... messagesParam);

    /**
     * Checks that the specified number is not positive (&gt;0) nor zero (0).
     *
     * @param messagesParam additional messages with more detail.
     * @param n             The specified number.
     */
    <T extends Number> T requireNotPositiveNorZero(final T n,
                                                   final String... messagesParam);

    /**
     * Checks that the specified number is not zero (0).
     *
     * @param messagesParam additional messages with more detail.
     * @param n             The specified number.
     */
    <T extends Number> T requireNotZero(final T n,
                                        final String... messagesParam);

    /**
     * Checks that the specified object is {@code null}.
     *
     * @param <T>           The object's type.
     * @param objParam      The specified object.
     * @param messagesParam additional messages with more detail.
     * @return The specified object.
     */
    <T> T requireNull(final T objParam, final String... messagesParam);

    Calendar requirePastInstant(final Calendar dateParam,
                                final String... messagesParam);

    Date requirePastInstant(final Date dateParam, final String... messagesParam);

    /**
     * Checks that the specified expression returns true.
     *
     * @param messagesParam additional messages with more detail.
     * @param boolParam     The expression.
     */
    boolean requireTrue(final boolean boolParam, final String... messagesParam);
}