/*
 * Copyright 2011 yannick.
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
package com.googlecode.jbp.common.repository;

import com.googlecode.jbp.common.util.Objects;

import java.io.Serializable;

import static com.googlecode.jbp.common.requirements.Reqs.PARAM_REQ;

/**
 * This class represents paging information for use in object repositories.  The
 * page is represented using the begin position and the length of the page.
 * <p>
 * Many object retrieval methods may use pagination.  Page coordinates are thus
 * passed as parameters to these methods.  As these coordinates belong together,
 * it's better to have one single argument representing the page concept than
 * having two separate arguments.
 * </p>
 * <p>A Page instance may be instantiated like this:
 * {@code Page.newPage().begin(30).length(10);}
 * </p>
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public final class Page implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Returns a new {@code Page} instance.
     *
     * @return Returns the new instance.
     */
    public static Page newPage() {
        return new Page();
    }

    private int firstResult = 0;

    private int maxResults;

    private Page() {
    }

    public final Page firstResult(final int firstResultParam) {
        PARAM_REQ.requireNotStrictlyNegative(firstResultParam);
        firstResult = firstResultParam;
        return this;
    }

    @Override
    public final boolean equals(final Object obj) {
        return Objects.equals(this, obj);
    }

    public final int getFirstResult() {
        return firstResult;
    }

    public final int getMaxResults() {
        return maxResults;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this);
    }

    public final Page maxResults(final int maxResultsParam) {
        PARAM_REQ.requireNotNegative(maxResultsParam);
        maxResults = maxResultsParam;
        return this;
    }

    @Override
    public final String toString() {
        return new StringBuilder("Page[firstResult=").append(Objects.toString(firstResult))
                .append(",maxResults=").append(Objects.toString(maxResults))
                .append("]").toString();
    }
}
