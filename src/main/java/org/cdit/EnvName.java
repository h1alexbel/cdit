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

/**
 * Environment Variable's Name.
 *
 * @since 0.0.0
 */
public final class EnvName implements Scalar<String> {

  /**
   * Environment Variable.
   */
  private final Scalar<String> variable;

  /**
   * Ctor.
   *
   * @param env Environment Variable
   */
  public EnvName(final Scalar<String> env) {
    this.variable = env;
  }

  @Override
  public String value() {
    try {
      return this.variable.value().split(":")[0];
    } catch (final Exception ex) {
      throw new IllegalStateException(
        "Can't parse env %s".formatted(this.variable),
        ex
      );
    }
  }
}
