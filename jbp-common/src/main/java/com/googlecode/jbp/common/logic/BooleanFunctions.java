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
package com.googlecode.jbp.common.logic;

import static com.googlecode.jbp.common.requirements.Reqs.PARAM_REQ;

/**
 * Provides various boolean-valued methods.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public class BooleanFunctions {

    /**
     * Returns {@code true} if all specified predicates are
     * {@code true}.
     *
     * @param predicatesParam The specified predicates.
     * @returnReturns {@code true} if all specified predicates are
     * {@code true}, {@code false} else.
     */
    public static boolean conjunction(final boolean... predicatesParam) {
        PARAM_REQ.Logic.requireTrue(predicatesParam.length > 0, "The length of the predicates array must be >0.");
        for (final boolean current : predicatesParam) {
            if (!current) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns {@code true} if at least on specified predicate is
     * {@code true}.
     *
     * @param predicatesParam The specified predicates.
     * @returnReturns {@code true} if at least one specified predicate is
     * {@code true}, {@code false} else.
     */
    public static boolean disjunction(final boolean... predicatesParam) {
        PARAM_REQ.Logic.requireTrue(predicatesParam.length > 0, "The length of the predicates array must be >0.");
        boolean disjunction = false;
        for (int i = 0; i < predicatesParam.length && !disjunction; ++i) {
            disjunction = disjunction || predicatesParam[i];
        }
        return disjunction;
    }

    /**
     * Checks for predicate equivalence.
     *
     * @param predicatesParam The specified predicates.
     * @return {@code true} if all specified predicates are equivalent,
     *         {@code false} else.
     */
    public static boolean equivalent(final boolean... predicatesParam) {
        PARAM_REQ.Logic.requireTrue(predicatesParam.length > 0, "The length of the predicates array must be >0.");
        boolean equivalent = true;
        for (int i = 0; i < predicatesParam.length - 1 && equivalent; ++i) {
            equivalent = !exclusiveDisjunction(predicatesParam[i],
                    predicatesParam[i + 1]);
        }
        return equivalent;
    }

    /**
     * Checks that exactly one predicate is {@code true}.
     *
     * @param firstPredicateParam  The first predicate.
     * @param secondPredicateParam The second predicate.
     * @return {@code true} if exactly one specified predicate is
     *         {@code true}.
     */
    public static boolean exclusiveDisjunction(
            final boolean firstPredicateParam,
            final boolean secondPredicateParam) {
        return firstPredicateParam != secondPredicateParam;
    }

    /**
     * Checks that strictly more than half of the specified predicates are
     * {@code true}.
     *
     * @param predicatesParam The specified predicates.
     * @return {@code true} if strictly more than half of the specified
     *         predicates are {@code true}, {@code false} else.
     */
    public static boolean majority(final boolean... predicatesParam) {
        PARAM_REQ.Logic.requireTrue(predicatesParam.length > 0, "The length of the predicates array must be >0.");
        int count = 0;
        final int halfQuantity = predicatesParam.length / 2;
        for (int i = 0; i < predicatesParam.length && count <= halfQuantity; ++i) {
            if (predicatesParam[i]) {
                ++count;
            }
        }
        return count > halfQuantity;
    }

    /**
     * Checks that both specified predicates are not simultaneously
     * {@code true}.
     *
     * @param firstPredicateParam  The first specified predicate.
     * @param secondPredicateParam The second specified predicate.
     * @return {@code true} if both specified predicates are not
     *         simultaneously {@code true}, {@code false} else.
     */
    public static boolean nand(final boolean firstPredicateParam,
                               final boolean secondPredicateParam) {
        return firstPredicateParam && secondPredicateParam ? false : true;
    }

    /**
     * Returns {@code true} if both specified predicates are simultaneously
     * {@code false}.
     *
     * @param firstPredicateParam  The first specified predicate.
     * @param secondPredicateParam The second specified predicate.
     * @return {@code true} if both specified predicates are simultaneously
     *         {@code false}, {@code false} else.
     */
    public static boolean nor(final boolean firstPredicateParam,
                              final boolean secondPredicateParam) {
        return !firstPredicateParam && !secondPredicateParam ? true : false;
    }

    /**
     * Returns the opposite of the specified predicate.
     *
     * @param predicateParam The specified predicate.
     * @return {@code true} if the specified predicate is
     *         {@code false} or {@code false} if it's
     *         {@code true}.
     */
    public static boolean not(final boolean predicateParam) {
        return !predicateParam;
    }

    /**
     * Returns an array with the opposites of the specified predicates.
     *
     * @param predicatesParam The specified predicates.
     * @return An array with the opposites of the specified predicates. The
     *         order of the elements is unchanged.
     */
    public static boolean[] not(final boolean... predicatesParam) {
        PARAM_REQ.Logic.requireTrue(predicatesParam.length > 0, "The length of the predicates array must be >0.");
        final boolean[] notPredicates = new boolean[predicatesParam.length];
        for (int i = 0; i < predicatesParam.length; ++i) {
            notPredicates[i] = !predicatesParam[i];
        }
        return notPredicates;
    }

    private BooleanFunctions() {
        throw new IllegalStateException("This class must not be instanciated.");
    }
}
