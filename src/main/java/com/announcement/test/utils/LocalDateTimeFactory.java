package com.announcement.test.utils;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class LocalDateTimeFactory {

  public LocalDateTimeFactory() {
  }

  public LocalDateTime now() {

    LocalDateTime date = LocalDateTime.now();
    return date;
  }
}
