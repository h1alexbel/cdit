package org.cdit.containers;

import org.cdit.SelfEnvelope;

/**
 * @since 0.0.0
 */
public final class ConfluentKafka extends SelfEnvelope {

  public ConfluentKafka(final String tag) {
    super("confluentinc/cp-kafka:%s".formatted(tag));
  }
}
