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

import java.util.Calendar;
import java.util.Date;

/**
 * Defines date- and time-related methods to check for required application state.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface IDateTimeRequirements {
    @Deprecated
    Calendar requireFutureInstant(final Calendar calendarParam,
                                  final String... messagesParam);

    @Deprecated
    Date requireFutureInstant(final Date dateParam,
                              final String... messagesParam);

    @Deprecated
    Calendar requirePastInstant(final Calendar dateParam,
                                final String... messagesParam);

    @Deprecated
    Date requirePastInstant(final Date dateParam, final String... messagesParam);

    Calendar requireFutureInstant(final Calendar calendarParam,
                                  final String messageParam);

    Date requireFutureInstant(final Date dateParam,
                              final String messageParam);

    Calendar requirePastInstant(final Calendar dateParam,
                                final String messageParam);

    Date requirePastInstant(final Date dateParam, final String messageParam);
}
