package org.cdit.containers;

import org.cdit.SelfEnvelope;

/**
 * @since 0.0.0
 */
public final class Postgres extends SelfEnvelope {

  public Postgres(final String tag) {
    super("postgres:%s".formatted(tag));
  }
}
