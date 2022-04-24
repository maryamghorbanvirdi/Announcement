package com.announcement.test.domain.enums;

public enum  AnnouncementStatus {

  WAITING("waiting"),
  ACTIVE("Active"),
  SUSPENDED("Suspended"),
  CANCEL("cancel"),
  NO_STATUS("None");

  private String description;

  AnnouncementStatus(String description) {

    this.description = description;
  }
  public String getDescription() {

    return description;
  }
}
