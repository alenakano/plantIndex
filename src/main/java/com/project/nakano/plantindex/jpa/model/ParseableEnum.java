package com.project.nakano.plantindex.jpa.model;

import java.util.Optional;

public interface ParseableEnum<E extends Enum<E>> {
  Optional<String> getParsePattern();
}
