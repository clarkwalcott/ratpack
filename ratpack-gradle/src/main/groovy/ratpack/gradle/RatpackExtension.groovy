/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.gradle

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

class RatpackExtension {

  public static final String GROUP = "io.ratpack"
  private final version = getClass().classLoader.getResource("ratpack/ratpack-version.txt").text.trim()

  private final DependencyHandler dependencies

  File baseDir

  RatpackExtension(Project project) {
    this.dependencies = project.dependencies
    baseDir = project.file('src/ratpack')
  }

  Dependency getServerCore() {
    dependency("server-core")
  }

  Dependency getGroovy() {
    dependency("groovy")
  }

  Dependency getTest() {
    dependency("test")
  }

  Dependency getGroovyTest() {
    dependency("groovy-test")
  }

  Dependency dependency(String name) {
    dependencies.create("${GROUP}:ratpack-${name}:${version}")
  }
}
