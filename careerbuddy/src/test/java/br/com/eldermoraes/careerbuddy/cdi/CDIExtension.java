/*
 * Copyright 2018 Elder Moreas and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.eldermoraes.careerbuddy.cdi;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import java.lang.reflect.Field;

public class CDIExtension implements TestInstancePostProcessor {


    private static final SeContainer CONTAINER = SeContainerInitializer.newInstance().initialize();
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws IllegalAccessException {

        for (Field field : testInstance.getClass().getDeclaredFields()) {
            if(field.getAnnotation(Inject.class) != null) {
                Object injected = CONTAINER.select(field.getType()).get();
                field.setAccessible(true);
                field.set(testInstance, injected);
            }

        }


    }



}