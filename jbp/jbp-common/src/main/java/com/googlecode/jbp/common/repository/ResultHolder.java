package com.googlecode.jbp.common.repository;

import be.wallonie.spw.dgarne.javatoolkit.common.requirements.ParamRequirements;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Class used to return the actual result list and the total number of results
 * of a repository search.
 *
 * @param <ID> The type of the entity's identifier.
 * @param <T>  The type of the entity that is searched for.
 */
public final class ResultHolder<ID extends Serializable, T extends IIdentifiable<ID>> {
    private final List<T> results;
    private final int resultQuantity;

    public ResultHolder(final List<T> resultsParam, final int resultQuantityParam) {
        ParamRequirements.INSTANCE.requireNotNull(resultsParam);
        ParamRequirements.INSTANCE.requireNotNegative(resultQuantityParam);
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
