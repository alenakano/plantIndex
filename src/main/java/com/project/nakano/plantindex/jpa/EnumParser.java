package com.project.nakano.plantindex.jpa;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;

import com.project.nakano.plantindex.jpa.model.ParseableEnum;

import ch.qos.logback.classic.Logger;

class EnumParser<E extends Enum<E> & ParseableEnum<E>> {
  private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EnumParser.class);
  private static final Map<Class<?>, EnumParser<?>> PARSERS = new ConcurrentHashMap<>();
  private Class<E> enumClass;
  private Map<E, Pattern> patterns;

  EnumParser(Class enumClass) {
    this.enumClass = enumClass;
    this.initPatterns();
  }

  private void initPatterns() {
    this.patterns = new EnumMap<>(this.enumClass);
    for (E value : this.enumClass.getEnumConstants()) {
      Pattern pattern;
      try {
        pattern = Pattern.compile(value.getParsePattern().orElse(value.name()), Pattern.CASE_INSENSITIVE);
      } catch (PatternSyntaxException e) {
        LOGGER.warn("Error on enum parse pattern for {}. Using name.", value);
        LOGGER.debug("Enum parse pattern error.", e);
        pattern = Pattern.compile(value.name(), Pattern.CASE_INSENSITIVE);
      }
      this.patterns.put(value, pattern);
    }
  }

  public static <T extends Enum<T> & ParseableEnum<T>> EnumParser<T> getInstance(Class<T> enumClass) {
    return (EnumParser<T>) PARSERS.computeIfAbsent(enumClass, EnumParser::new);
  }

  public Set<E> parseEnums(String input) {
    return this.findKeys(input).collect(Collectors.toCollection(() -> EnumSet.noneOf(this.enumClass)));
  }

  public Optional<E> parseEnum(String input) {
    return this.findKeys(input).findFirst();
  }

  private Stream<E> findKeys(String input) {
    return this.patterns.entrySet().stream().filter(entry -> entry.getValue().matcher(input).find()).map(Entry::getKey);
  }
}