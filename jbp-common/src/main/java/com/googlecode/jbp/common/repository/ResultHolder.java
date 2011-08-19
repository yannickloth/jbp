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
package com.googlecode.jbp.common.repository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static com.googlecode.jbp.common.requirements.Reqs.PARAM_REQ;

/**
 * Class used to return the actual result list and the total number of results
 * of a repository search.
 *
 * @param <ID> The type of the entity's identifier.
 * @param <T>  The type of the entity that is searched for.
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public final class ResultHolder<ID extends Serializable, T extends IIdentifiable<ID>> implements Serializable {

    private static final long serialVersionUID = 1L;
    private final List<T> results;
    private final int resultQuantity;

    public ResultHolder(final List<T> resultsParam, final int resultQuantityParam) {
        PARAM_REQ.requireNotNull(resultsParam);
        PARAM_REQ.requireNotStrictlyNegative(resultQuantityParam);
        results = Collections.unmodifiableList(resultsParam);
        resultQuantity = resultQuantityParam;
    }

    public List<T> getResults() {
        return results;
    }

    public int getResultQuantity() {
        return resultQuantity;
    }
}
