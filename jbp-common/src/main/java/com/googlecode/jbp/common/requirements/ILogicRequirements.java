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
 * Defines logic-related methods to check for required application state.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface ILogicRequirements {
    /**
     * Requires that all predicates are {@code true}. At least one
     * predicate must be specified.
     *
     * @param predicatesParam The specified predicates.
     * @return {@code true} if all predicates are {@code true}.
     */
    @Deprecated
    boolean requireConjunction(final boolean... predicatesParam);


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
    @Deprecated
    boolean requireDisjunction(final boolean... predicatesParam);

    /**
     * Checks that there is a disjunction between the two specified predicates.
     *
     * @param firstPredicateParam  The first predicate.
     * @param secondPredicateParam The second predicate.
     * @return Returns {@code true} if exactly one predicate is
     *         {@code true}.
     */
    @Deprecated
    boolean requireExclusiveDisjunction(final boolean firstPredicateParam,
                                        final boolean secondPredicateParam);


    /**
     * Checks that the specified expression returns false.
     *
     * @param boolParam     The expression.
     * @param messagesParam additional messages with more detail.
     */
    @Deprecated
    boolean requireFalse(final boolean boolParam, final String... messagesParam);

    /**
     * Checks that the specified expression returns true.
     *
     * @param messagesParam additional messages with more detail.
     * @param boolParam     The expression.
     */
    @Deprecated
    boolean requireTrue(final boolean boolParam, final String... messagesParam);

    /**
     * Requires that all predicates are {@code true}. At least one
     * predicate must be specified.
     *
     * @param predicatesParam The specified predicates.
     * @param messageParam    additional message with more detail.
     * @return {@code true} if all predicates are {@code true}.
     */
    boolean requireConjunction(final String messageParam, final boolean... predicatesParam);


    /**
     * Checks that there is a disjunction between the specified predicates. In
     * case there is only one predicate, the disjunction is present if the
     * predicate is {@code true}. Remember that the values of the
     * predicates are calculated eagerly, before the execution of the method.
     *
     * @param predicatesParam The specified predicates.
     * @param messageParam    additional message with more detail.
     * @return Returns {@code true} if at least one predicate is
     *         {@code true}.
     */
    boolean requireDisjunction(final String messageParam, final boolean... predicatesParam);

    /**
     * Checks that there is a disjunction between the two specified predicates.
     *
     * @param firstPredicateParam  The first predicate.
     * @param secondPredicateParam The second predicate.
     * @param messageParam         additional message with more detail.
     * @return Returns {@code true} if exactly one predicate is
     *         {@code true}.
     */
    boolean requireExclusiveDisjunction(final boolean firstPredicateParam,
                                        final boolean secondPredicateParam, final String messageParam);


    /**
     * Checks that the specified expression returns false.
     *
     * @param boolParam    The expression.
     * @param messageParam additional message with more detail.
     */
    boolean requireFalse(final boolean boolParam, final String messageParam);

    /**
     * Checks that the specified expression returns true.
     *
     * @param messageParam additional message with more detail.
     * @param boolParam    The expression.
     */
    boolean requireTrue(final boolean boolParam, final String messageParam);
}
