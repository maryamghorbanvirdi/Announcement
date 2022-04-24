package com.announcement.test.domain.announcement;

public class NoAnnouncement extends Announcement {

  private static final NoAnnouncement INSTANCE = new NoAnnouncement();

  private NoAnnouncement() {

    super(null, null, null, null,null, null, null, null, null, null, null);

  }

  @Override
  public boolean isPresent() {
    return false;
  }

  public static NoAnnouncement create() {
    return INSTANCE;
  }
}
