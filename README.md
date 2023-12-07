<img alt="logo" src="https://www.objectionary.com/cactus.svg" height="100px" />

[![Managed By Self XDSD](https://self-xdsd.com/b/mbself.svg)](https://self-xdsd.com/p/h1alexbel/cdit?provider=github)

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](https://www.rultor.com/b/h1alexbel/cdit)](https://www.rultor.com/p/h1alexbel/cdit)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)
<br>

[![mvn](https://github.com/h1alexbel/cdit/actions/workflows/mvn.yml/badge.svg)](https://github.com/h1alexbel/cdit/actions/workflows/mvn.yml)
[![maven central](http://maven-badges.herokuapp.com/maven-central/io.github.h1alexbel/cdit/badge.svg)](https://search.maven.org/artifact/io.github.h1alexbel/cdit)
[![javadoc](https://javadoc.io/badge2/io.github.h1alexbel/cdit/javadoc.svg)](https://javadoc.io/doc/io.github.h1alexbel/cdit)
[![codecov](https://codecov.io/gh/h1alexbel/cdit/branch/master/graph/badge.svg?token=4IFT0H3Y01)](https://codecov.io/gh/h1alexbel/cdit)

[![Hits-of-Code](https://hitsofcode.com/github/h1alexbel/cdit)](https://hitsofcode.com/view/github/h1alexbel/cdit)
[![Lines-of-Code](https://tokei.rs/b1/github/h1alexbel/cdit)](https://github.com/h1alexbel/cdit)
[![PDD status](http://www.0pdd.com/svg?name=h1alexbel/cdit)](http://www.0pdd.com/p?name=h1alexbel/cdit)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/h1alexbel/cdit/blob/master/LICENSE.txt)

Project architect: [@h1alexbel](https://github.com/h1alexbel)

A Collection of Pre-Configured Docker Containers for your Integration Tests.

**Motivation**. We are not happy with configuring Testcontainers again and again the same way,
so we create a "hosted" home and fill it with common pre-configured Docker containers for integration testing.

**Principles**. These are the [design principles](https://www.elegantobjects.org/#principles) behind cdit.

**How to use**. All you need is this (get the latest version [here](https://search.maven.org/artifact/io.github.h1alexbel/cdit)):

Maven:
```xml
<dependency>
  <groupId>io.github.h1alexbel</groupId>
  <artifactId>cdit</artifactId>
</dependency>
```

Gradle:
```groovy
dependencies {
    compile 'io.github.h1alexbel:cdit:<version>'
}
```

## Containers
To create Docker container, let's say PostgreSQL, you can use
```java
import org.cdit.containers.Postgres;
import org.cdit.containers.Env;

new Postgres(
  "latest",
  new Env("POSTGRES_USER", "user"),
  new Env("POSTGRES_PASSWORD", "AAAA...CCCC")
).run();
```
Now Docker container is up and running.

## Creating your own Container Class

If you want to create your own container, you can extend [ContainerEnvelope](https://github.com/h1alexbel/cdit/blob/master/src/main/java/org/cdit/ContainerEnvelope.java)
this way

```java
import org.cdit.ContainerEnvelope;

public final class MyPrivateContainer extends ContainerEnvelope {
  public MyPrivateContainer(final String tag, final Env... vars) {
    super("ecr.io/myprivate:%s".formatted(tag), vars);
  }
}
```

now, you can run it
```java
new MyPrivateContainer("0.0.1", new Env("test", "true")).run();
```

## How to Contribute

Fork repository, make changes, send us a [pull request](https://www.yegor256.com/2014/04/15/github-guidelines.html).
We will review your changes and apply them to the `master` branch shortly,
provided they don't violate our quality standards. To avoid frustration,
before sending us your pull request please run full Maven build:

```bash
$ mvn clean install -Pinvoker
```

You will need Maven 3.8.7+ Java 17+, and Docker.

Our [rultor image](https://github.com/eo-cqrs/eo-kafka-rultor-image) for CI/CD.
