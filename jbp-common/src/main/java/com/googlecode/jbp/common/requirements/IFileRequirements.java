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

/**
 * Defines File-API-related methods to check for required application state.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface IFileRequirements {
    /**
     * Checks that the specified {@code File} instance refers to a
     * directory.
     *
     * @param fileParam     The specified file. Must not be {@code null}.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file.
     */
    @Deprecated
    File requireDirectory(final File fileParam, final String... messagesParam);

    /**
     * Checks that the specified {@code String} instance is a path that
     * refers to a directory.
     *
     * @param filePathParam The specified file path. Must not be blank.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file path.
     */
    @Deprecated
    String requireDirectory(final String filePathParam,
                            final String... messagesParam);

    /**
     * Checks that the specified {@code File} instance refers to an
     * existing file.
     *
     * @param fileParam     The specified file. Must not be {@code null}.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file.
     */
    @Deprecated
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
    @Deprecated
    String requireExistingFile(final String filePathParam,
                               final String... messagesParam);

    /**
     * Checks that the specified {@code File} instance refers to a non
     * existing file.
     *
     * @param fileParam     The specified file. Must not be {@code null}.
     * @param messagesParam Additional messages with more detail.
     * @return The specified file.
     */
    @Deprecated
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
    @Deprecated
    String requireNotExistingFile(final String filePathParam,
                                  final String... messagesParam);

    /**
     * Checks that the specified {@code File} instance refers to a
     * directory.
     *
     * @param fileParam    The specified file. Must not be {@code null}.
     * @param messageParam Additional message with more detail.
     * @return The specified file.
     */
    File requireDirectory(final File fileParam, final String messageParam);

    /**
     * Checks that the specified {@code String} instance is a path that
     * refers to a directory.
     *
     * @param filePathParam The specified file path. Must not be blank.
     * @param messageParam  Additional message with more detail.
     * @return The specified file path.
     */
    String requireDirectory(final String filePathParam,
                            final String messageParam);

    /**
     * Checks that the specified {@code File} instance refers to an
     * existing file.
     *
     * @param fileParam    The specified file. Must not be {@code null}.
     * @param messageParam Additional message with more detail.
     * @return The specified file.
     */
    File requireExistingFile(final File fileParam,
                             final String messageParam);

    /**
     * Checks that the specified {@code String} instance is a path that
     * refers to an existing file.
     *
     * @param filePathParam The specified file path. Must not be blank.
     * @param messageParam  Additional message with more detail.
     * @return The specified file path.
     */
    String requireExistingFile(final String filePathParam,
                               final String messageParam);

    /**
     * Checks that the specified {@code File} instance refers to a non
     * existing file.
     *
     * @param fileParam    The specified file. Must not be {@code null}.
     * @param messageParam Additional message with more detail.
     * @return The specified file.
     */
    File requireNotExistingFile(final File fileParam,
                                final String messageParam);

    /**
     * Checks that the specified {@code String} instance is a path that
     * refers to a non existing file.
     *
     * @param filePathParam The specified file path. Must not be blank.
     * @param messageParam  Additional message with more detail.
     * @return The specified file path.
     */
    String requireNotExistingFile(final String filePathParam,
                                  final String messageParam);

}
