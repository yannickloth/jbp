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

/**
 * A common interface for domain model objects/entities that are persisted to
 * some data base.
 * 
 * @author Yannick LOTH   - yannick AT littlej.biz -
 */
public interface IIdentifiable<ID extends Serializable> extends Serializable {

    /**
     * Returns the identifier of the entity.
     * 
     * @return The identifier of the entity.
     */
    ID getId();
}
