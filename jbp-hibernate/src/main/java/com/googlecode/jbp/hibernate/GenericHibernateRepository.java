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
package com.googlecode.jbp.hibernate;

import com.googlecode.jbp.common.constants.CompilerWarnings;
import com.googlecode.jbp.common.repository.IGenericRepository;
import com.googlecode.jbp.common.repository.IIdentifiable;
import com.googlecode.jbp.common.repository.Page;
import com.googlecode.jbp.common.requirements.ParamRequirements;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Generic Hibernate repository class. Not specific to a given entity class.
 * Intended to be used for usual CRUD operations.
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public class GenericHibernateRepository implements IGenericRepository {

    private static final transient Logger LOGGER = LoggerFactory
            .getLogger(AbstractHibernateRepository.class);

    private final SessionFactory sessionFactory;

    /**
     * Constructor.
     *
     * @param sessionFactoryParam Must not be {@code null}.
     */

    public GenericHibernateRepository(final SessionFactory sessionFactoryParam) {
        super();
        ParamRequirements.INSTANCE.requireNotNull(sessionFactoryParam);
        sessionFactory = sessionFactoryParam;
    }

    protected final Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public final <ID extends Serializable, DomainModel extends IIdentifiable<ID>> DomainModel create(final DomainModel entity) {
        ParamRequirements.INSTANCE.requireNotNull(entity);
        getSession().persist(entity);
        return entity;
    }

    protected final <ID extends Serializable, DomainModel extends IIdentifiable<ID>, PersistenceModel extends DomainModel> Criteria createCriteria(final Class<PersistenceModel> persistentClassParam) {
        ParamRequirements.INSTANCE.requireNotNull(persistentClassParam);
        return getSession().createCriteria(persistentClassParam);
    }

    public final <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void delete(final Collection<DomainModel> entities) {
        ParamRequirements.INSTANCE.requireNotNull(entities);
        for (final DomainModel current : entities) {
            delete(current);
        }
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void delete(final DomainModel entity) {
        ParamRequirements.INSTANCE.requireNotNull(entity);
        final DomainModel merged = (DomainModel) getSession().merge(
                entity);
        getSession().flush();
        getSession().delete(merged);
        getSession().flush();
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void delete(final ID id, final Class<DomainModel> persistentClassParam) {
        ParamRequirements.INSTANCE.requireNotNull(id);
        final DomainModel entity = (DomainModel) getSession().get(
                persistentClassParam, id);
        if (entity != null) {
            getSession().delete(entity);
        }
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void deleteAll(final Class<DomainModel> persistentClassParam) {
        delete(retrieveAll(persistentClassParam));
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> boolean exists(final DomainModel entity) {
        ParamRequirements.INSTANCE.requireNotNull(entity);
        return getSession().get(entity.getClass(), entity.getId()) != null;
    }

    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> boolean exists(final ID id, final Class<DomainModel> persistentClassParam) {
        ParamRequirements.INSTANCE.requireNotNull(id);
        return getSession().get(persistentClassParam, id) != null;
    }

    public final void flush() {
        LOGGER.trace("Session flush.");
        getSession().flush();
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> List<DomainModel> retrieveAll(final Class<DomainModel> persistentClassParam) {
        getSession().flush();
        return getSession().createCriteria(persistentClassParam).list();
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> List<DomainModel> retrieveAll(final Class<DomainModel> persistentClassParam, final Page pageParam) {
        ParamRequirements.INSTANCE.requireNotNull(pageParam);
        ParamRequirements.INSTANCE.requireNotNegative(pageParam.getFirstResult());
        ParamRequirements.INSTANCE.requireNotNegative(pageParam.getMaxResults());
        getSession().flush();
        return addPagingToCriteria(getSession().createCriteria(persistentClassParam), pageParam)
                .list();
    }

    protected final Criteria addPagingToCriteria(final Criteria criteriaParam, final Page pageParam) {
        ParamRequirements.INSTANCE.requireNotNull(criteriaParam);
        ParamRequirements.INSTANCE.requireNotNull(pageParam);
        ParamRequirements.INSTANCE.requireNotNegative(pageParam.getFirstResult());
        ParamRequirements.INSTANCE.requireNotNegative(pageParam.getMaxResults());
        criteriaParam.setFirstResult(pageParam.getFirstResult()).setMaxResults(pageParam.getMaxResults());
        return criteriaParam;
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> DomainModel retrieveById(final Class<DomainModel> persistentClassParam, final ID id) {
        ParamRequirements.INSTANCE.requireNotNull(id);
        final DomainModel entity = (DomainModel) getSession().get(
                persistentClassParam, id);
        if (entity != null) {
            Hibernate.initialize(entity);
        }
        return entity;
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void update(final Collection<DomainModel> entities) {
        ParamRequirements.INSTANCE.requireNotNull(entities);
        for (final DomainModel current : entities) {
            final DomainModel merged = (DomainModel) getSession()
                    .merge(current);
            getSession().saveOrUpdate(merged);
        }
    }

    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public <ID extends Serializable, DomainModel extends IIdentifiable<ID>> void update(final DomainModel entity) {
        ParamRequirements.INSTANCE.requireNotNull(entity);
        final DomainModel merged = (DomainModel) getSession().merge(
                entity);
        getSession().saveOrUpdate(merged);
    }
}
