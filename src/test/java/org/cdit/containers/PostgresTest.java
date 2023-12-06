package org.cdit.containers;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.shaded.org.hamcrest.MatcherAssert;
import org.testcontainers.shaded.org.hamcrest.core.IsEqual;

/**
 * Test suite for {@link Postgres}.
 *
 * @since 0.0.0
 */
final class PostgresTest {

  @Test
  void runs() {
    MatcherAssert.assertThat(
      "PostgreSQL is not running",
      new Postgres("latest").run().isRunning(),
      new IsEqual<>(true)
    );
  }

  @Test
  void checksImageName() {
    MatcherAssert.assertThat(
      "PostgreSQL image is not in the right format",
      new Postgres("16.0-bullseye").run().getImage().get(),
      new IsEqual<>("postgres:16.0-bullseye")
    );
  }

  @Test
  void stops() {
    final GenericContainer<?> started = new Postgres("latest").run();
    started.stop();
    MatcherAssert.assertThat(
      "PostgreSQL is not stopped",
      started.isRunning(),
      new IsEqual<>(false)
    );
  }
}
