/*
  copied from https://github.com/eugenp/tutorials/blob/master/testing-modules/testing-assertions/src/test/java/com/baeldung/junit/log/MemoryAppender.java
  see the above repo for any reserved copy rights
 */
package com.deensoft.mathfun.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

/**
 * In memory slf4j appender<br/>
 * Convenient appender to be able to check slf4j invocations
 */
public class MemoryAppender extends ListAppender<ILoggingEvent> {
    public void reset() {
        this.list.clear();
    }

    public boolean contains(String string, Level level) {
        return this.list.stream()
                .anyMatch(event -> event.getMessage().contains(string)
                        && event.getLevel().equals(level));
    }

    public int countEventsForLogger(String loggerName) {
        return (int) this.list.stream()
                .filter(event -> event.getLoggerName().contains(loggerName)).count();
    }

    public List<ILoggingEvent> search(String string) {
        return this.list.stream()
                .filter(event -> event.getMessage().contains(string))
                .collect(Collectors.toList());
    }

    public List<ILoggingEvent> search(String string, Level level) {
        return this.list.stream()
                .filter(event -> event.getFormattedMessage().contains(string)
                        && event.getLevel().equals(level))
                .collect(Collectors.toList());
    }

    public int getSize() {
        return this.list.size();
    }

    public List<ILoggingEvent> getLoggedEvents() {
        return Collections.unmodifiableList(this.list);
    }
}