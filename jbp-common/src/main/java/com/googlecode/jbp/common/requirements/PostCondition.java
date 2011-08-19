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
 * Provides useful methods to check if postconditions are met.
 * <p>
 * Unless explicitly stated, these methods throw a
 * {@code PostConditionException} if the postcondition is not met.
 * </p>
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public final class PostCondition extends AbstractRequirements {
    /**
     * Singleton instance.
     */
    public static final PostCondition POST_COND = new PostCondition();

    @Deprecated
    public static final PostCondition INSTANCE = POST_COND;

    /**
     * Private constructor. Throws a {@code IllegalStateException} if the
     * singleton is already instanciated.
     */
    private PostCondition() {
        if (POST_COND != null) {
            throw new IllegalStateException(
                    "This class must not be instanciated");
        }
    }

    @Override
    protected void onConditionNotMet(final String messageParam) {
        throw new PostConditionException(messageParam);
    }
}
