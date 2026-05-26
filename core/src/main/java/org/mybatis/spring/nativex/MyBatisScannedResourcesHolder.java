/*
 *    Copyright 2022-2023 the original author or authors.
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
package org.mybatis.spring.nativex;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.nativex.hint.TypeAccess;
import org.springframework.util.ClassUtils;

/**
 * The holder class that scanned resources using {@code @MyBatisResourcesScan}.
 *
 * @author Kazuki Shimizu
 */
public class MyBatisScannedResourcesHolder {

    private Set<Class<?>> typeAliasesClasses;

    private Set<Class<?>> typeHandlerClasses;

    private Set<String> mapperLocations;

    private Set<Class<?>> reflectionClasses;

    private TypeAccess[] reflectionTypeAccesses;

    private Set<String> resourceLocations;

    /**
     * Return class list of scanned type aliases.
     *
     * @return class list of scanned type aliases
     */
    public Set<Class<?>> getTypeAliasesClasses() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set class list of scanned type aliases.
     *
     * @param typeAliasClasses
     *          class list of scanned type aliases
     */
    @SuppressWarnings("unused")
    public void setTypeAliasesClasses(Set<Class<?>> typeAliasClasses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return class list of scanned type handler.
     *
     * @return class list of scanned type handler
     */
    public Set<Class<?>> getTypeHandlerClasses() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set class list of scanned type handler.
     *
     * @param typeHandlerClasses
     *          class list of scanned type handler
     */
    @SuppressWarnings("unused")
    public void setTypeHandlerClasses(Set<Class<?>> typeHandlerClasses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return location list of scanned mapper xml file.
     *
     * @return location list of scanned mapper xml file
     */
    public Set<String> getMapperLocations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set location list of scanned mapper xml file.
     *
     * @param mapperLocations
     *          location list of scanned mapper xml file
     */
    @SuppressWarnings("unused")
    public void setMapperLocations(Set<String> mapperLocations) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set class list of scanned reflection hint type.
     *
     * @param reflectionClasses
     *          class list of scanned reflection hint type
     */
    @SuppressWarnings("unused")
    public void setReflectionClasses(Set<Class<?>> reflectionClasses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return class list of scanned reflection hint type.
     *
     * @return class list of scanned reflection hint type
     */
    public Set<Class<?>> getReflectionClasses() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set access scopes for applying reflection type that scanned.
     *
     * @param reflectionTypeAccesses
     *          access scopes for applying reflection type that scanned
     */
    @SuppressWarnings("unused")
    public void setReflectionTypeAccesses(TypeAccess[] reflectionTypeAccesses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return access scopes for applying reflection type that scanned.
     *
     * @return access scopes for applying reflection type that scanned
     */
    public TypeAccess[] getReflectionTypeAccesses() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set location list of adding resource hint file.
     *
     * @param resourceLocations
     *          location list of adding resource hint file
     */
    @SuppressWarnings("unused")
    public void setResourceLocations(Set<String> resourceLocations) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return location list of adding resource hint file.
     *
     * @return location list of adding resource hint file
     */
    public Set<String> getResourceLocations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Registrar implements ImportBeanDefinitionRegistrar {

        private static final Log LOG = LogFactory.getLog(Registrar.class);

        private static final ResourcePatternResolver RESOURCE_PATTERN_RESOLVER = new PathMatchingResourcePatternResolver();

        private static final MetadataReaderFactory METADATA_READER_FACTORY = new CachingMetadataReaderFactory();

        private static final Pattern JAR_RESOURCE_PREFIX_PATTERN = Pattern.compile(".*\\.jar!/");

        private static final boolean PRESENT_TYPE_HANDLER = ClassUtils.isPresent("org.apache.ibatis.type.TypeHandler", null);

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected void registerBeanDefinitions(AnnotationAttributes annoAttrs, BeanDefinitionRegistry registry) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Set<Class<?>> scanClasses(String[] packagePatterns, Class<?> assignableType) throws IOException {
            Set<Class<?>> classes = new HashSet<>();
            for (String packagePattern : packagePatterns) {
                Resource[] resources = RESOURCE_PATTERN_RESOLVER.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(packagePattern) + "/**/*.class");
                for (Resource resource : resources) {
                    try {
                        ClassMetadata classMetadata = METADATA_READER_FACTORY.getMetadataReader(resource).getClassMetadata();
                        Class<?> clazz = ClassUtils.forName(classMetadata.getClassName(), null);
                        if (assignableType == void.class || assignableType.isAssignableFrom(clazz)) {
                            classes.add(clazz);
                        }
                    } catch (ClassNotFoundException e) {
                        LOG.debug("Fail loading class.", e);
                    }
                }
            }
            return classes;
        }

        private Set<String> scanResources(String[] mapperLocationPatterns) {
            try {
                String baseUrl = new ClassPathResource("/").getURL().toString();
                return Stream.of(mapperLocationPatterns).flatMap(location -> Stream.of(getResources(location))).map(x -> toPath(x, baseUrl)).collect(Collectors.toSet());
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        private Resource[] getResources(String locationPattern) {
            try {
                return RESOURCE_PATTERN_RESOLVER.getResources(locationPattern);
            } catch (IOException e) {
                LOG.debug("Fail getting resources. locationPattern: " + locationPattern, e);
                return new Resource[0];
            }
        }

        private String toPath(Resource resource, String baseUrl) {
            try {
                String url = resource.getURL().toString();
                String path = url;
                if (url.startsWith(baseUrl)) {
                    path = url.replace(baseUrl, "");
                } else if (url.contains(".jar!")) {
                    path = JAR_RESOURCE_PREFIX_PATTERN.matcher(url).replaceFirst("");
                } else {
                    path = determineRelativePath(resource);
                }
                return path;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        private String determineRelativePath(Resource resource) throws IOException {
            Path path = resource.getFile().toPath();
            StringBuilder sb = new StringBuilder();
            for (int i = path.getNameCount() - 1; i >= 0; i--) {
                sb.insert(0, path.getName(i));
                String relativePath = sb.toString();
                if (RESOURCE_PATTERN_RESOLVER.getResource(relativePath).exists()) {
                    return relativePath;
                }
                sb.insert(0, '/');
            }
            return resource.getURL().toString();
        }
    }

    static class RepeatableRegistrar extends Registrar {

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
