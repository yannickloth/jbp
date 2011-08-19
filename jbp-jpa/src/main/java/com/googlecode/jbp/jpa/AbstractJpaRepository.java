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


import com.googlecode.jbp.common.repository.IGenericRepository;
import com.googlecode.jbp.common.repository.IIdentifiable;
import com.googlecode.jbp.common.repository.IRepository;
import com.googlecode.jbp.common.repository.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import static com.googlecode.jbp.common.requirements.ParamRequirements.PARAM_REQ;

/**
 * Abstract data access object implemented using Hibernate. This abstract class
 * should be extended by specific data access objects when Hibernate is to be
 * used for persistence.
 * <p>
 * Note that {@code @Transactional} annotations are used here as Hibernate
 * works with object graphs, thus multiple rows in multiple tables may be
 * modified in a single method. Nevertheless don't forget that normally
 * transaction should always be declared in the service layer.
 * </p>
 *
 * @param <ID>               The class of the identifier.
 * @param <DomainModel>      The domain interface of the persisted classes.
 * @param <PersistenceModel> The persisted class, which implements the domain interface.
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public abstract class AbstractJpaRepository<ID extends Serializable, DomainModel extends IIdentifiable<ID>, PersistenceModel extends DomainModel>
        implements IRepository<ID, DomainModel> {

    private static final transient Logger LOGGER = LoggerFactory
            .getLogger(AbstractJpaRepository.class);
    private final EntityManager entityManager;
    private final IGenericRepository genericHibernateRepository;

    /**
     * Constructor
     *
     * @param entityManagerParam     The JPA entity manager that this data access object
     *                               uses.
     * @param genericRepositoryParam
     */
    public AbstractJpaRepository(final EntityManager entityManagerParam, final IGenericRepository genericRepositoryParam) {
        super();
        PARAM_REQ.requireNotNull(entityManagerParam);
        PARAM_REQ.requireNotNull(genericRepositoryParam);
        genericHibernateRepository = genericRepositoryParam;
        entityManager = entityManagerParam;
    }

    public final DomainModel create(final DomainModel entity) {
        PARAM_REQ.requireNotNull(entity);
        PARAM_REQ.requireInstanceOf(entity,
                getPersistentClass());
        return genericHibernateRepository.create(entity);
    }

    /**
     * Creates a criteria with the persisted entity's class.
     *
     * @return The created criteria.
     */
    protected final <ID extends Serializable, DomainModel extends IIdentifiable<ID>> CriteriaQuery<DomainModel> createCriteria(final Class<DomainModel> persistentClassParam) {
        PARAM_REQ.requireNotNull(persistentClassParam);
        return entityManager.getCriteriaBuilder().createQuery(persistentClassParam);
    }

    public void delete(final Collection<DomainModel> entities) {
        genericHibernateRepository.delete(entities);
    }

    public void delete(final DomainModel entity) {
        PARAM_REQ.requireInstanceOf(entity, getPersistentClass());
        genericHibernateRepository.delete(entity);
    }

    public void delete(final ID id) {
        genericHibernateRepository.delete(id, getPersistentClass());
    }

    public void deleteAll() {
        genericHibernateRepository.deleteAll(getPersistentClass());
    }

    public boolean exists(final DomainModel entity) {
        PARAM_REQ.requireInstanceOf(entity,
                getPersistentClass());
        return genericHibernateRepository.exists(entity);
    }

    public boolean exists(final ID id) {
        PARAM_REQ.requireNotNull(id);
        return genericHibernateRepository.exists(id, getPersistentClass());
    }

    /**
     * Flushes the current Hibernate session.
     */
    public final void flush() {
        genericHibernateRepository.flush();
    }

    /**
     * Returns the class of the entities managed using this data access object.
     *
     * @return The class of the entities managed using this data access object.
     */
    protected abstract Class<PersistenceModel> getPersistentClass();

    public List<DomainModel> retrieveAll() {
        return (List<DomainModel>) genericHibernateRepository.retrieveAll(getPersistentClass());
    }

    public List<DomainModel> retrieveAll(final Page pageParam) {
        return (List<DomainModel>) genericHibernateRepository.retrieveAll(getPersistentClass(), pageParam);
    }

    /**
     * Adds the specified paging to the specified criteria.
     *
     * @param queryParam The query whose results must be paged.
     * @param pageParam  The paging setting.
     * @return The specified criteria, with paging set.
     */
    protected final TypedQuery addPagingToQuery(final TypedQuery queryParam, final Page pageParam) {
        PARAM_REQ.requireNotNull(queryParam);
        PARAM_REQ.requireNotNull(pageParam);
        PARAM_REQ.requireNotStrictlyNegative(pageParam.getFirstResult());
        PARAM_REQ.requireNotStrictlyNegative(pageParam.getMaxResults());
        queryParam.setFirstResult(pageParam.getFirstResult()).setMaxResults(pageParam.getMaxResults());
        return queryParam;
    }

    public DomainModel retrieveById(final ID id) {
        return genericHibernateRepository.retrieveById(getPersistentClass(), id);
    }

    public void update(final Collection<DomainModel> entities) {
        genericHibernateRepository.update(entities);
    }

    public void update(final DomainModel entity) {
        PARAM_REQ.requireInstanceOf(entity,
                getPersistentClass());
        genericHibernateRepository.update(entity);
    }
}
