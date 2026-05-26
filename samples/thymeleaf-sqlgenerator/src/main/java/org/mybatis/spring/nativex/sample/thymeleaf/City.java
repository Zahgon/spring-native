/*
 *    Copyright 2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.spring.nativex.sample.thymeleaf;

public class City {

    private Integer id;

    private String name;

    private String state;

    private String country;

    public City() {
        // NOP
    }

    public City(Integer id, String name, String state, String country) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.country = country;
    }

    public Integer getId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setId(Integer id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getState() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setState(String state) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getCountry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCountry(String country) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
