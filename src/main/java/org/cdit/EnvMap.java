/*
 *  Copyright (c) 2023 Aliaksei Bialiauski
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.cdit;

import org.cactoos.Scalar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Environment Map.
 *
 * @since 0.0.0
 */
public final class EnvMap implements Scalar<Map<String, String>> {

  /**
   * Variables.
   */
  private final List<Env> vars;

  /**
   * Ctor.
   *
   * @param envs Variables
   */
  public EnvMap(final List<Env> envs) {
    this.vars = envs;
  }

  @Override
  public Map<String, String> value() {
    final Map<String, String> boxed = new HashMap<>(13);
    this.vars.forEach(env -> {
      final String name = new EnvName(env).value();
      final String value = new EnvVal(env).value();
      boxed.put(name, value);
    });
    return boxed;
  }
}
