package org.cdit;

import org.testcontainers.containers.GenericContainer;

/**
 * Docker Container.
 *
 * @since 0.0.0
 */
public interface Container {

  /**
   * Start Container.
   *
   * @return GenericContainer
   */
  GenericContainer<?> run();
}
