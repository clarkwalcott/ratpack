/*
 * Copyright 2014-2015 the original author or authors.
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

package ratpack.spring.config;

import java.util.Collections;
import java.util.List;

import ratpack.func.Action;
import ratpack.guice.BindingsSpec;
import ratpack.server.core.handling.Chain;
import ratpack.server.core.ServerConfigBuilder;

public class RatpackServerCustomizerAdapter implements RatpackServerCustomizer {

  @Override
  public List<Action<Chain>> getHandlers() {
    return Collections.emptyList();
  }

  @Override
  public Action<BindingsSpec> getBindings() {
    return spec -> {
    };
  }

  @Override
  public Action<ServerConfigBuilder> getServerConfig() {
    return server -> {
    };
  }

}
