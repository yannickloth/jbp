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
import java.util.Collection;
import java.util.List;

/**
 * Interface with common data access methods.
 *
 * @param <DomainModel> The class of the entity's domain model.
 * @param <ID>          The class of the entity's identifier. Usually, this should be a
 *                      {@code java.lang.Long}.
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface IRepository<ID extends Serializable, DomainModel extends IIdentifiable<ID>> {

    /**
     * Persists the given entity.
     *
     * @param entity The entity that must be persisted. Must not be
     *               {@code null}.
     * @return Returns the persisted entity.
     */
    DomainModel create(DomainModel entity);

    /**
     * Retrieves all persisted entities.
     *
     * @return Returns a {@code java.util.List{@code true} with all persisted
     *         entities.
     */
    List<DomainModel> retrieveAll();

    /**
     * Retrieves an entity using its identifier.
     *
     * @param id The identifier.
     * @return The entity with the given identifier.
     */
    DomainModel retrieveById(ID id);

    /**
     * Retrieves persisted entities from the specified page.
     *
     * @return Returns a {@code java.util.List} with persisted entities
     *         from the specified page.
     */
    List<DomainModel> retrieveAll(final Page pageParam);

    /**
     * Checks for the existence of the specified entity.
     *
     * @param entity The entity.
     * @return Returns {@code true} if the entity is persisted,
     *         {@code false} else.
     */
    boolean exists(DomainModel entity);

    /**
     * Checks if an entity with the specified identifier exists.
     *
     * @param id The identifier.
     * @return {@code true} if the entity exists, {@code false} else.
     */
    boolean exists(ID id);

    /**
     * Updates the given entity.
     *
     * @param t The entity which must be updated.
     */
    void update(DomainModel t);

    /**
     * Updates all given entities.
     *
     * @param entities A {@code java.lang.Collection} with all entities which
     *                 must be updated. Must not be null. May be an empty.
     */
    void update(Collection<DomainModel> entities);

    /**
     * Deletes the specified entity.
     *
     * @param t The entity which must be deleted.
     */
    void delete(DomainModel t);

    /**
     * Deletes the entity with the specified identifier. If no entity has the
     * specified identifier, nothing happens.
     *
     * @param id The identifier.
     */
    void delete(ID id);

    /**
     * Deletes the specified entities.
     *
     * @param t A {@code java.util.Collection} with all entities which
     *          must be deleted.
     */
    void delete(Collection<DomainModel> t);

    /**
     * Deletes all persisted entities.
     */
    void deleteAll();
}
