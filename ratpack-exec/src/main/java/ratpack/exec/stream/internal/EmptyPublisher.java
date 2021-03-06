/*
 * Copyright 2016 the original author or authors.
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

package ratpack.exec.stream.internal;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import ratpack.exec.stream.TransformablePublisher;

public class EmptyPublisher<T> implements TransformablePublisher<T> {

  public static final TransformablePublisher<?> INSTANCE = new EmptyPublisher<>();

  @Override
  public void subscribe(Subscriber<? super T> s) {
    s.onSubscribe(new Subscription() {
      @Override
      public void request(long n) {
        if (n < 1) {
          s.onError(new IllegalArgumentException("3.9 While the Subscription is not cancelled, Subscription.request(long n) MUST throw a java.lang.IllegalArgumentException if the argument is <= 0."));
        }
      }

      @Override
      public void cancel() {

      }
    });
    s.onComplete();
  }

}
