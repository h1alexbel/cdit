package org.cdit;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * Container Envelope.
 *
 * @since 0.0.0
 */
public abstract class ContainerEnvelope implements Container {

  /**
   * Docker Container.
   */
  private final GenericContainer<?> container;

  /**
   * Ctor.
   *
   * @param image Docker Image
   */
  public ContainerEnvelope(final String image) {
    this(new GenericContainer<>(DockerImageName.parse(image)));
  }

  /**
   * Ctor.
   *
   * @param cntr Docker Container
   */
  public ContainerEnvelope(final GenericContainer<?> cntr) {
    this.container = cntr;
  }
}
