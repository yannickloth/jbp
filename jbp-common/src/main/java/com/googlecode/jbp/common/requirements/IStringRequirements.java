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
 * Defines string-related methods to check for required application state.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface IStringRequirements {
    /**
     * Checks that a string object is not blank (null or empty or only spaces).
     *
     * @param strParam      The string.
     * @param messagesParam Additional messages with more detail.
     */
    @Deprecated
    String requireNotBlank(final String strParam, final String... messagesParam);

    /**
     * Checks that a string object is not blank (null or empty or only spaces).
     *
     * @param strParam The string.
     * @param msgParam Additional message with more detail.
     */
    String requireNotBlank(final String strParam, final String msgParam);
}
