/*
 * Copyright 2017 the original author or authors.
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

package org.gradle.language.cpp.internal;

import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ModuleDependency;
import org.gradle.api.artifacts.PublishArtifact;
import org.gradle.api.attributes.Usage;
import org.gradle.api.internal.component.UsageContext;

import java.util.Set;

class DefaultUsageContext implements UsageContext {
    private final Usage usage;
    private final Set<? extends PublishArtifact> artifacts;
    private final Set<? extends ModuleDependency> dependencies;

    DefaultUsageContext(Usage usage, Set<? extends PublishArtifact> artifacts, Configuration configuration) {
        this.usage = usage;
        this.artifacts = artifacts;
        this.dependencies = configuration.getAllDependencies().withType(ModuleDependency.class);
    }

    DefaultUsageContext(Usage usage, Set<? extends PublishArtifact> artifacts, Set<? extends ModuleDependency> dependencies) {
        this.usage = usage;
        this.artifacts = artifacts;
        this.dependencies = dependencies;
    }

    @Override
    public Usage getUsage() {
        return usage;
    }

    @Override
    public Set<? extends PublishArtifact> getArtifacts() {
        return artifacts;
    }

    @Override
    public Set<? extends ModuleDependency> getDependencies() {
        return dependencies;
    }
}
