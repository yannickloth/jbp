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
 * Provides useful methods to check if preconditions are met.
 * <p>
 * Unless explicitly stated, these methods throw a
 * {@code PreConditionException} if the precondition is not met.
 * </p>
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public final class PreCondition extends AbstractRequirements {
    /**
     * Singleton instance.
     */
    public static final PreCondition PRE_COND = new PreCondition();

    @Deprecated
    public static final PreCondition INSTANCE = PRE_COND;

    /**
     * Private constructor. Throws a {@code IllegalStateException} if the
     * singleton is already instanciated.
     */
    private PreCondition() {
        if (PRE_COND != null) {
            throw new IllegalStateException(
                    "This class must not be instanciated");
        }
    }

    @Override
    protected void onConditionNotMet(final String messageParam) {
        throw new PreConditionException(messageParam);
    }
}
