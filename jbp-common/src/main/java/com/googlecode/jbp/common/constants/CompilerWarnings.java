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
package com.googlecode.jbp.common.constants;

/**
 * Contains compiler warning constants. Usually used with the
 * {@code @SuppressWarnings} annotation.
 * 
 * @author Yannick LOTH   - yannick AT littlej.biz -
 * 
 */
public final class CompilerWarnings {

    /**
     * Unchecked conversion, for generics.
     */
    public static final String UNCHECKED = "unchecked";
    /**
     * Unparameterized reference to parameterized object.
     */
    public static final String RAWTYPES = "rawtypes";

    /**
     * Private constructor, as the class should never be instanciated.
     */
    private CompilerWarnings() {
        throw new IllegalStateException(
                "This class should never be instanciated.");
    }
}
