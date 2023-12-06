package org.cdit;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * @since 0.0.0
 */
public final class ContainerOf implements Container {

  private final GenericContainer<?> origin;

  public ContainerOf(final GenericContainer<?> orgn) {
    this.origin = orgn;
  }

  public ContainerOf(final String image) {
    this(new GenericContainer<>(DockerImageName.parse(image)));
  }

  @Override
  public Container run() {
    this.origin.start();
    return this;
  }

  @Override
  public Container env(final String name, final String value) {
    return new ContainerOf(this.origin.withEnv(name, value));
  }

  @Override
  public GenericContainer<?> self() {
    return this.origin;
  }
}
