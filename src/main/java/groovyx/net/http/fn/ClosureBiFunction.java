/**
 * Copyright (C) 2016 David Clark
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package groovyx.net.http.fn;

import groovy.lang.Closure;

import java.util.function.BiFunction;

/**
 * FIXME: document
 * @param <IN_0>
 * @param <IN_1>
 * @param <OUT>
 */
public class ClosureBiFunction<IN_0, IN_1, OUT> implements BiFunction<IN_0, IN_1, OUT> {

    private Closure<OUT> closure;

    public ClosureBiFunction(final Closure<OUT> closure) {
        this.closure = closure;
    }

    public Closure<OUT> getClosure() {
        return closure;
    }

    @Override
    public OUT apply(IN_0 in_0, IN_1 in_1) {
        return closure.call(closureArgs(in_0, in_1));
    }

    private Object[] closureArgs(final IN_0 in_0, final IN_1 in_1) {
        final int size = closure.getMaximumNumberOfParameters();
        final Object[] args = new Object[size];
        if (size >= 1) {
            args[0] = in_0;
        }

        if (size >= 2) {
            args[1] = in_1;
        }

        return args;
    }
}
