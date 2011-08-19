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

/**
 * Defines number-related methods to check for required application state.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface INumberRequirements {
    /**
     * Checks that the specified number is not negative (&lt;0).
     *
     * @param n             The specified number.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    <T extends Number> T requireNotStrictlyNegative(final T n,
                                                    final String... messagesParam);

    /**
     * Checks that the specified number is negative (&lt;0).
     *
     * @param n             The specified number.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    <T extends Number> T requireStrictlyNegative(final T n,
                                                 final String... messagesParam);

    /**
     * Checks that the specified number is negative or zero (&lt;=0).
     *
     * @param n             The specified number.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    <T extends Number> T requireNegative(final T n,
                                         final String... messagesParam);

    /**
     * Checks that the specified number is not negative (&lt;0) nor zero (0).
     *
     * @param n             The specified number.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    <T extends Number> T requireNotNegative(final T n,
                                            final String... messagesParam);

    /**
     * Checks that the specified number is not strictly positive (&gt;0).
     *
     * @param messagesParam additional messages with more detail.
     * @param n             The specified number.
     */
    @Deprecated
    <T extends Number> T requireNotStrictlyPositive(final T n,
                                                    final String... messagesParam);

    /**
     * Checks that the specified number is positive (&gt;0).
     *
     * @param n             The specified number.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    <T extends Number> T requireStrictlyPositive(final T n, final String... messagesParam);

    /**
     * Checks that the specified number is positive or zero (&gt;=0).
     *
     * @param n             The specified number.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    <T extends Number> T requirePositive(final T n, final String... messagesParam);

    /**
     * Checks that the specified number is not positive (&gt;0) nor zero (0).
     *
     * @param messagesParam additional messages with more detail.
     * @param n             The specified number.
     */
    @Deprecated
    <T extends Number> T requireNotPositive(final T n,
                                            final String... messagesParam);

    /**
     * Checks that the specified number is not zero (0).
     *
     * @param messagesParam additional messages with more detail.
     * @param n             The specified number.
     */
    @Deprecated
    <T extends Number> T requireNotZero(final T n,
                                        final String... messagesParam);

    /**
     * Checks that the specified number is not negative (&lt;0).
     *
     * @param n            The specified number.
     * @param messageParam additional message with more detail.
     */
    <T extends Number> T requireNotStrictlyNegative(final T n,
                                                    final String messageParam);

    /**
     * Checks that the specified number is negative (&lt;0).
     *
     * @param n            The specified number.
     * @param messageParam additional message with more detail.
     */
    <T extends Number> T requireStrictlyNegative(final T n,
                                                 final String messageParam);

    /**
     * Checks that the specified number is negative or zero (&lt;=0).
     *
     * @param n            The specified number.
     * @param messageParam additional message with more detail.
     */
    <T extends Number> T requireNegative(final T n,
                                         final String messageParam);

    /**
     * Checks that the specified number is not negative (&lt;0) nor zero (0).
     *
     * @param n            The specified number.
     * @param messageParam additional message with more detail.
     */
    <T extends Number> T requireNotNegative(final T n,
                                            final String messageParam);

    /**
     * Checks that the specified number is not strictly positive (&gt;0).
     *
     * @param messageParam additional message with more detail.
     * @param n            The specified number.
     */
    <T extends Number> T requireNotStrictlyPositive(final T n,
                                                    final String messageParam);

    /**
     * Checks that the specified number is positive (&gt;0).
     *
     * @param n            The specified number.
     * @param messageParam additional message with more detail.
     */
    <T extends Number> T requireStrictlyPositive(final T n, final String messageParam);

    /**
     * Checks that the specified number is positive or zero (&gt;=0).
     *
     * @param n            The specified number.
     * @param messageParam additional message with more detail.
     */
    <T extends Number> T requirePositive(final T n, final String messageParam);

    /**
     * Checks that the specified number is not positive (&gt;0) nor zero (0).
     *
     * @param messageParam additional message with more detail.
     * @param n            The specified number.
     */
    <T extends Number> T requireNotPositive(final T n,
                                            final String messageParam);

    /**
     * Checks that the specified number is not zero (0).
     *
     * @param messageParam additional message with more detail.
     * @param n            The specified number.
     */
    <T extends Number> T requireNotZero(final T n,
                                        final String messageParam);

}
