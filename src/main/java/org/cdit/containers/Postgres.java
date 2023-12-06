package org.cdit.containers;

import org.cdit.ContainerEnvelope;

/**
 * PostgreSQL Container.
 *
 * @since 0.0.0
 */
public final class Postgres extends ContainerEnvelope {

  public Postgres(final String tg) {
    super("postgres:%s".formatted(tg));
  }
}
