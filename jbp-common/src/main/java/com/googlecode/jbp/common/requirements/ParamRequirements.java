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
 * Provides useful methods to check for method parameter validity.
 * <p>
 * Unless explicitly stated, these methods throw an
 * {@code java.lang.IllegalArgumentException} if the parameter is not
 * valid.
 * </p>
 * <p>
 * Example of null parameter check:
 * {@code ParamRequirements.INSTANCE.requireNotNull(firstParameter);}
 * instead of
 * {@code
 * if (firstParameter == null) {
 *    throw new IllegalArgumentException("First parameter must not be null.");
 * }      }
 * </p>
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public final class ParamRequirements extends AbstractRequirements {

    /**
     * Singleton instance.
     */
    public static final ParamRequirements PARAM_REQ = new ParamRequirements();
    @Deprecated
    public static final ParamRequirements INSTANCE = PARAM_REQ;


    /**
     * Private constructor. Throws a {@code IllegalStateException} if the
     * singleton is already instantiated.
     */
    private ParamRequirements() {
    }

    @Override
    protected void onConditionNotMet(final String messageParam) {
        throw new IllegalArgumentException(messageParam);
    }
}
