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

package org.cdit.containers;

import org.cdit.Env;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

/**
 * Test suite for {@link Postgres}.
 *
 * @since 0.0.0
 */
final class PostgresTest {

  @Test
  void runs() {
    MatcherAssert.assertThat(
      "Container is not running",
      new Postgres("16").run()
        .isRunning(),
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
      "Container is not stopped",
      started.isRunning(),
      new IsEqual<>(false)
    );
  }

  @Test
  void checksEnvs() {
    MatcherAssert.assertThat(
      "Environment Variables are not in the right format",
      new Postgres(
        "latest",
        new Env("POSTGRES_USER", "user"),
        new Env("POSTGRES_PASSWORD", "pass")
      ).run().getEnv(),
      Matchers.hasItems("POSTGRES_USER=user", "POSTGRES_PASSWORD=pass")
    );
  }
}
