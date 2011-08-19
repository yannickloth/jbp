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

import java.util.Collection;

/**
 * Defines object-related methods to check for required application state.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface IObjectRequirements {
    /**
     * Checks that all elements of the specified collection are instances of the
     * specified class.
     *
     * @param collParam     The specified collection.
     * @param klassParam    The class which all specified collection's elements should be
     *                      instances of.
     * @param messagesParam Additional messages with more detail.
     */
    @Deprecated
    <T extends Collection<?>> T requireAllInstanceOf(final T collParam,
                                                     final Class<?> klassParam, final String... messagesParam);

    /**
     * Checks that all elements of the specified collection are instances of the
     * specified class.
     *
     * @param collParam    The specified collection.
     * @param klassParam   The class which all specified collection's elements should be
     *                     instances of.
     * @param messageParam Additional message with more detail.
     */
    <T extends Collection<?>> T requireAllInstanceOf(final T collParam,
                                                     final Class<?> klassParam, final String messageParam);

    /**
     * Checks that the specified object is an instance of the specified class.
     *
     * @param objParam      The specified object.
     * @param klassParam    The class which the specified object should be an instance of.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    <T> T requireInstanceOf(final T objParam, final Class<?> klassParam,
                            final String... messagesParam);

    /**
     * Checks that the specified object is an instance of the specified class.
     *
     * @param objParam     The specified object.
     * @param klassParam   The class which the specified object should be an instance of.
     * @param messageParam additional message with more detail.
     */
    <T> T requireInstanceOf(final T objParam, final Class<?> klassParam,
                            final String messageParam);

    /**
     * Checks that at least one reference is not null.
     *
     * @param objectsParam The references to objects that may be null.
     */
    @Deprecated
    Object[] requireNotAllSimultaneouslyNull(final Object... objectsParam);

    /**
     * Checks that at least one reference is not null.
     *
     * @param objectsParam The references to objects that may be null.
     */
    Object[] requireNotAllSimultaneouslyNull(final String msgParam, final Object... objectsParam);

    /**
     * Checks that at least one of the specified objects is not {@code null}.
     *
     * @param <T>           The type of the collection of specified objects.
     * @param coll          The collection of specified objects.
     * @param messagesParam additional messages with more detail.
     * @return The collection of specified objects.
     */
    @Deprecated
    <T extends Collection<?>> T requireNotAllSimultaneouslyNull(final T coll,
                                                                final String... messagesParam);

    /**
     * Checks that at least one of the specified objects is not {@code null}.
     *
     * @param <T>          The type of the collection of specified objects.
     * @param coll         The collection of specified objects.
     * @param messageParam additional message with more detail.
     * @return The collection of specified objects.
     */
    <T extends Collection<?>> T requireNotAllSimultaneouslyNull(final T coll,
                                                                final String messageParam);

    /**
     * Checks that a collection is not empty. The specified collection must not
     * be null.
     *
     * @param collParam     The collection to check for emptyness.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    <T extends Collection<?>> T requireNotEmpty(final T collParam,
                                                final String... messagesParam);

    /**
     * Checks that a collection is not empty. The specified collection must not
     * be null.
     *
     * @param collParam    The collection to check for emptyness.
     * @param messageParam additional message with more detail.
     */
    <T extends Collection<?>> T requireNotEmpty(final T collParam,
                                                final String messageParam);

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
    @Deprecated
    <T> T requireNotNull(final T objParam, final String... messagesParam);

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
     * @param <T>          type of the object.
     * @param objParam     The object.
     * @param messageParam additional message with more detail.
     */
    <T> T requireNotNull(final T objParam, final String messageParam);

    /**
     * Checks that the specified object is {@code null}.
     *
     * @param <T>           The object's type.
     * @param objParam      The specified object.
     * @param messagesParam additional messages with more detail.
     * @return The specified object.
     */
    @Deprecated
    <T> T requireNull(final T objParam, final String... messagesParam);

    /**
     * Checks that the specified object is {@code null}.
     *
     * @param <T>          The object's type.
     * @param objParam     The specified object.
     * @param messageParam additional message with more detail.
     * @return The specified object.
     */
    <T> T requireNull(final T objParam, final String messageParam);
}
