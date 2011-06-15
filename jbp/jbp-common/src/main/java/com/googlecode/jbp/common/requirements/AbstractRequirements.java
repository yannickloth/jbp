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

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Abstract implementation of {@code IRequirements} which provides the
 * checks but not the action that has to be taken if a condition is not met. All
 * methods that accept a vararg {@code String...} parameter will
 * concatenate all elements of this array to each other and to the default
 * message associated to the check and then transmit this {@code String} to
 * the {@code conditionNotMet} methods. Thus, the user of these methods may
 * specify additional information.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public abstract class AbstractRequirements implements IRequirements {

    private String concatenateStrings(final String stringParam,
                                      final String... stringsParam) {
        ParamRequirements.INSTANCE.requireNotNull(stringParam);
        String result = stringParam;
        if (stringsParam != null) {
            final StringBuilder sb = new StringBuilder(stringParam);
            for (final String current : stringsParam) {
                sb.append(" ").append(current);
            }
            result = sb.toString();
        }
        return result;
    }

    /**
     * Called if a condition is not met. Usually throws a
     * {@code RequirementException}.
     *
     * @param messageParam The associated message.
     */
    protected abstract void onConditionNotMet(final String messageParam);

    public final <T extends Collection<?>> T requireAllInstanceOf(
            final T collParam, final Class<?> klassParam,
            final String... messagesParam) {
        requireNotNull(collParam);
        requireNotNull(klassParam);
        for (final Object current : collParam) {
            if (!klassParam.isAssignableFrom(current.getClass())) {
                final String message = concatenateStrings(
                        "Requires all collection elements of class: ".concat(klassParam.getName()), messagesParam);
                onConditionNotMet(message);
            }
        }
        return collParam;
    }

    public final boolean requireConjunction(final boolean... predicatesParam) {
        ParamRequirements.INSTANCE.requireTrue(predicatesParam.length > 0);
        for (final boolean current : predicatesParam) {
            if (!current) {
                onConditionNotMet("Requires the conjunction of all predicates (all must be 'true').");
            }
        }
        return true;
    }

    public final File requireDirectory(final File fileParam,
                                       final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotNull(fileParam);
        if (!fileParam.isDirectory()) {
            final String message = concatenateStrings(
                    "Requires that file is a directory: ".concat(fileParam.getPath()), messagesParam);
            onConditionNotMet(message);
        }
        return fileParam;
    }

    public final String requireDirectory(final String filePathParam,
                                         final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotBlank(filePathParam);
        final File file = new File(filePathParam);
        if (!file.isDirectory()) {
            final String message = concatenateStrings(
                    "Requires that file is a directory: ".concat(filePathParam),
                    messagesParam);
            onConditionNotMet(message);
        }
        return filePathParam;
    }

    public final boolean requireDisjunction(final boolean... predicatesParam) {
        ParamRequirements.INSTANCE.requireTrue(predicatesParam.length > 0);
        boolean currentDisjunction = false;
        for (int i = 0; i < predicatesParam.length && !currentDisjunction; ++i) {
            currentDisjunction = predicatesParam[i];
        }
        if (!currentDisjunction) {
            onConditionNotMet("Requires the disjunction of all predicates (at least one 'true').");
        }
        return true;
    }

    public final boolean requireExclusiveDisjunction(
            final boolean firstPredicateParam,
            final boolean secondPredicateParam) {
        if (firstPredicateParam == secondPredicateParam) {
            onConditionNotMet("Requires an exclusive disjunction of the predicates (at least one true, but not both at once).");
        }
        return true;
    }

    public final File requireExistingFile(final File fileParam,
                                          final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotNull(fileParam);
        if (!fileParam.exists()) {
            final String message = concatenateStrings(
                    "Requires that file exists: ".concat(fileParam.getPath()),
                    messagesParam);
            onConditionNotMet(message);
        }
        return fileParam;
    }

    public final String requireExistingFile(final String filePathParam,
                                            final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotBlank(filePathParam);
        final File file = new File(filePathParam);
        if (!file.exists()) {
            final String message = concatenateStrings(
                    "Requires that file exists: ".concat(filePathParam),
                    messagesParam);
            onConditionNotMet(message);
        }
        return filePathParam;
    }

    public final boolean requireFalse(final boolean boolParam,
                                      final String... messagesParam) {
        if (boolParam) {
            final String message = concatenateStrings(
                    "Requires that the specified expression returns false.",
                    messagesParam);
            onConditionNotMet(message);

        }
        return false;
    }

    public final Calendar requireFutureInstant(final Calendar calendarParam,
                                               final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotNull(calendarParam);
        if (calendarParam.before(new Date())) {
            final String message = "Passed calendar must not be a past date.";
            onConditionNotMet(message);
        }
        return calendarParam;
    }

    public final Date requireFutureInstant(final Date dateParam,
                                           final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotNull(dateParam);
        if (dateParam.before(new Date())) {
            final String message = "Passed date must not be a past date.";
            onConditionNotMet(message);
        }
        return dateParam;
    }

    public final <T> T requireInstanceOf(final T objParam,
                                         final Class<?> klassParam, final String... messagesParam) {
        requireNotNull(objParam);
        requireNotNull(klassParam);
        if (!klassParam.isAssignableFrom(objParam.getClass())) {
            final String message = concatenateStrings(
                    "Requires parameter is instance of class: ".concat(klassParam.getName()), messagesParam);
            onConditionNotMet(message);
        }
        return objParam;
    }

    public final Object[] requireNotAllSimultaneouslyNull(
            final Object... objectsParam) {
        boolean oneNotNull = false;
        for (final Object current : objectsParam) {
            if (current != null) {
                oneNotNull = true;
                break;
            }
        }
        if (!oneNotNull) {
            onConditionNotMet("At least one object must not be null.");
        }
        return objectsParam;
    }

    public final <T extends Collection<?>> T requireNotAllSimultaneouslyNull(
            final T coll, final String... messagesParam) {
        boolean oneNotNull = false;
        for (final Object current : coll) {
            if (current != null) {
                oneNotNull = true;
                break;
            }
        }
        if (!oneNotNull) {
            final String message = concatenateStrings(
                    "Requires at least one non null element in collection.",
                    messagesParam);
            onConditionNotMet(message);
        }
        return coll;
    }

    public final String requireNotBlank(final String strParam,
                                        final String... messagesParam) {
        if (strParam == null || StringUtils.isBlank(strParam)) {
            final String message = concatenateStrings("Requires non blank String.",
                    messagesParam);
            onConditionNotMet(message);
        }
        return strParam;
    }

    public final <T extends Collection<?>> T requireNotEmpty(final T collParam,
                                                             final String... messagesParam) {
        requireNotNull(collParam);
        if (collParam.isEmpty()) {
            final String message = concatenateStrings(
                    "Requires not empty collection.", messagesParam);
            onConditionNotMet(message);
        }
        return collParam;
    }

    public final File requireNotExistingFile(final File fileParam,
                                             final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotNull(fileParam);
        if (fileParam.exists()) {
            final String message = concatenateStrings(
                    "Requires that file does not exist: ".concat(fileParam.getPath()), messagesParam);
            onConditionNotMet(message);

        }
        return fileParam;
    }

    public final String requireNotExistingFile(final String filePathParam,
                                               final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotBlank(filePathParam);
        final File file = new File(filePathParam);
        if (file.exists()) {
            final String message = concatenateStrings(
                    "Requires that file is a directory: ".concat(filePathParam),
                    messagesParam);
            onConditionNotMet(message);
        }
        return filePathParam;
    }

    public final <T extends Number> T requireNotNegative(final T n,
                                                         final String... messagesParam) {
        requireNotNull(n);
        if (0 > n.doubleValue()) {
            final String message = concatenateStrings(
                    "Requires a number that is not negative.", messagesParam);
            onConditionNotMet(message);
        }
        return n;
    }

    public final <T extends Number> T requireNotNegativeNorZero(final T n,
                                                                final String... messagesParam) {
        requireNotNull(n);
        if (0 >= n.doubleValue()) {
            final String message = concatenateStrings(
                    "Requires a number that is not negative nor zero.",
                    messagesParam);
            onConditionNotMet(message);
        }
        return n;
    }

    public final <T> T requireNotNull(final T objParam,
                                      final String... messagesParam) {
        if (objParam == null) {
            final String message = concatenateStrings("Requires a non null object.",
                    messagesParam);
            onConditionNotMet(message);
        }
        return objParam;
    }

    public final <T extends Number> T requireNotPositive(final T n,
                                                         final String... messagesParam) {
        requireNotNull(n);
        if (0 < n.doubleValue()) {
            final String message = concatenateStrings(
                    "Requires a number that is not positive.", messagesParam);
            onConditionNotMet(message);
        }
        return n;
    }

    public final <T extends Number> T requireNotPositiveNorZero(final T n,
                                                                final String... messagesParam) {
        requireNotNull(n);
        if (0 <= n.doubleValue()) {
            final String message = concatenateStrings(
                    "Requires a number that is not positive nor zero.",
                    messagesParam);
            onConditionNotMet(message);
        }
        return n;
    }

    public final <T extends Number> T requireNotZero(final T n,
                                                     final String... messagesParam) {
        requireNotNull(n);
        if (0 == n.doubleValue()) {
            final String message = concatenateStrings(
                    "Requires a number that is not zero.", messagesParam);
            onConditionNotMet(message);
        }
        return n;
    }

    public final <T> T requireNull(final T objParam,
                                   final String... messagesParam) {
        if (objParam != null) {
            final String message = concatenateStrings("Requires a null object.",
                    messagesParam);
            onConditionNotMet(message);
        }
        return objParam;
    }

    public final Calendar requirePastInstant(final Calendar calendarParam,
                                             final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotNull(calendarParam);
        if (calendarParam.after(new Date())) {
            final String message = "Passed calendar must not be a past date.";
            onConditionNotMet(message);
        }
        return calendarParam;
    }

    public final Date requirePastInstant(final Date dateParam,
                                         final String... messagesParam) {
        ParamRequirements.INSTANCE.requireNotNull(dateParam);
        if (dateParam.after(new Date())) {
            final String message = "Passed date must not be a future date.";
            onConditionNotMet(message);
        }
        return dateParam;
    }

    public final boolean requireTrue(final boolean boolParam,
                                     final String... messagesParam) {
        if (!boolParam) {
            final String message = concatenateStrings(
                    "Requires that the specified expression returns true.",
                    messagesParam);
            onConditionNotMet(message);
        }
        return true;
    }
}
