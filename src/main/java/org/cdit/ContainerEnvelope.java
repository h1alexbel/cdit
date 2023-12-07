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

import org.cactoos.list.ListOf;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

/**
 * Container Envelope.
 *
 * @since 0.0.0
 */
public abstract class ContainerEnvelope implements Container {

  /**
   * Origin Container.
   */
  private final GenericContainer<?> origin;

  /**
   * Environment Variables.
   */
  private final List<Env> vars;

  /**
   * Ctor.
   *
   * @param image Image
   * @param envs  Environment Variables
   */
  public ContainerEnvelope(final String image, final Env... envs) {
    this(
      new GenericContainer<>(DockerImageName.parse(image)),
      new ListOf<>(envs)
    );
  }

  /**
   * Ctor.
   *
   * @param image Image name
   * @param envs  Environment Variables
   */
  public ContainerEnvelope(final String image, final List<Env> envs) {
    this(new GenericContainer<>(DockerImageName.parse(image)), envs);
  }

  /**
   * Ctor.
   *
   * @param orgn Origin Container
   * @param envs Environment Variables
   */
  public ContainerEnvelope(
    final GenericContainer<?> orgn,
    final List<Env> envs
  ) {
    this.origin = orgn;
    this.vars = envs;
  }

  @Override
  public final GenericContainer<?> run() {
    this.origin.withEnv(new EnvMap(this.vars).value());
    this.origin.start();
    return this.origin;
  }
}
