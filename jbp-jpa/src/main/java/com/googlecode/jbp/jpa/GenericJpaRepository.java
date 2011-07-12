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
package com.googlecode.jbp.jpa;

import com.googlecode.jbp.common.constants.CompilerWarnings;
import com.googlecode.jbp.common.repository.IGenericRepository;
import com.googlecode.jbp.common.repository.IIdentifiable;
import com.googlecode.jbp.common.repository.Page;
import com.googlecode.jbp.common.requirements.ParamRequirements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Generic Hibernate repository class. Not specific to a given entity class.
 * Intended to be used for usual CRUD operations.
 *
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public class GenericJpaRepository implements IGenericRepository {

    private static final transient Logger LOGGER = LoggerFactory
            .getLogger(AbstractJpaRepository.class);

    private final EntityManager entityManager;

    /**
     * Constructor.
     *
     * @param entityManagerParam Must not be {@code null}.
     */

    public GenericJpaRepository(final EntityManager entityManagerParam) {
        super();
        ParamRequirements.INSTANCE.requireNotNull(entityManagerParam);
        entityManager = entityManagerParam;
    }

    protected final EntityManager getEntityManager() {
        return entityManager;
    }

    public final <ID extends Serializable, DomainModel extends IIdentifiable<ID>> DomainModel create(final DomainModel entity) {
        ParamRequirements.INSTANCE.requireNotNull(entity);
        getEntityManager().persist(entity);
        return entity;
    }

    protected final <ID extends Serializable, DomainModel extends IIdentifiable<ID>> CriteriaQuery<DomainModel> createCriteria(final Class<DomainModel> persistentClassParam) {
        ParamRequirements.INSTANCE.requireNotNull(persistentClassParam);
        return getEntityManager().getCriteriaBuilder().createQuery(persistentClassParam);
    }

    public final <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void delete(final Collection<DomainModel> entities) {
        ParamRequirements.INSTANCE.requireNotNull(entities);
        for (final DomainModel current : entities) {
            delete(current);
        }
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void delete(final DomainModel entity) {
        ParamRequirements.INSTANCE.requireNotNull(entity);
        final DomainModel merged = (DomainModel) entityManager.merge(
                entity);
        getEntityManager().flush();
        getEntityManager().remove(merged);
        getEntityManager().flush();
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void delete(final ID id, final Class<DomainModel> persistentClassParam) {
        ParamRequirements.INSTANCE.requireNotNull(id);
        final DomainModel entity = (DomainModel) getEntityManager().find(
                persistentClassParam, id);
        if (entity != null) {
            getEntityManager().remove(entity);
        }
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void deleteAll(final Class<DomainModel> persistentClassParam) {
        delete(retrieveAll(persistentClassParam));
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> boolean exists(final DomainModel entity) {
        ParamRequirements.INSTANCE.requireNotNull(entity);
        return getEntityManager().find(entity.getClass(), entity.getId()) != null;
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> boolean exists(final ID id, final Class<DomainModel> persistentClassParam) {
        ParamRequirements.INSTANCE.requireNotNull(id);
        return getEntityManager().find(persistentClassParam, id) != null;
    }

    public final void flush() {
        LOGGER.trace("Session flush.");
        getEntityManager().flush();
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> List<DomainModel> retrieveAll(final Class<DomainModel> persistentClassParam) {
        getEntityManager().flush();
        final TypedQuery<DomainModel> q = buildQueryForRetrieveAll(persistentClassParam);
        return q.getResultList();
    }

    private <ID extends Serializable, DomainModel extends IIdentifiable<ID>> TypedQuery<DomainModel> buildQueryForRetrieveAll(final Class<DomainModel> persistentClassParam) {
        final CriteriaQuery<DomainModel> cq = createCriteria(persistentClassParam);
        final Root<DomainModel> root = cq.from(persistentClassParam);
        cq.select(root);
        return getEntityManager().createQuery(cq);
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> List<DomainModel> retrieveAll(final Class<DomainModel> persistentClassParam, final Page pageParam) {
        ParamRequirements.INSTANCE.requireNotNull(pageParam);
        ParamRequirements.INSTANCE.requireNotNegative(pageParam.getFirstResult());
        ParamRequirements.INSTANCE.requireNotNegative(pageParam.getMaxResults());
        getEntityManager().flush();
        final TypedQuery<DomainModel> q = buildQueryForRetrieveAll(persistentClassParam);
        return addPagingToQuery(q, pageParam).getResultList();
    }

    protected final TypedQuery addPagingToQuery(final TypedQuery queryParam, final Page pageParam) {
        ParamRequirements.INSTANCE.requireNotNull(queryParam);
        ParamRequirements.INSTANCE.requireNotNull(pageParam);
        ParamRequirements.INSTANCE.requireNotNegative(pageParam.getFirstResult());
        ParamRequirements.INSTANCE.requireNotNegative(pageParam.getMaxResults());
        queryParam.setFirstResult(pageParam.getFirstResult()).setMaxResults(pageParam.getMaxResults());
        return queryParam;
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> DomainModel retrieveById(final Class<DomainModel> persistentClassParam, final ID id) {
        ParamRequirements.INSTANCE.requireNotNull(id);
        final DomainModel entity = getEntityManager().find(
                persistentClassParam, id);
        return entity;
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void update(final Collection<DomainModel> entities) {
        ParamRequirements.INSTANCE.requireNotNull(entities);
        for (final DomainModel current : entities) {
            getEntityManager()
                    .merge(current);
        }
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void update(final DomainModel entity) {
        ParamRequirements.INSTANCE.requireNotNull(entity);
        getEntityManager().merge(
                entity);
    }
}
