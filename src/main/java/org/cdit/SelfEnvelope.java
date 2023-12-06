package org.cdit;

import org.testcontainers.containers.GenericContainer;

/**
 * @since
 */
public abstract class SelfEnvelope implements Self {

  private final Container container;

  public SelfEnvelope(final Container cntr) {
    this.container = cntr;
  }

  public SelfEnvelope(final String image) {
    this(new ContainerOf(image));
  }

  @Override
  public Container back() {
    return this.container;
  }
}
