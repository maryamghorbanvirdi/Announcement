package com.announcement.test.service.announcement;

import com.announcement.test.domain.announcement.Announcement;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnnouncementService {

  Announcement createAnnouncement(Announcement announcement);
  Optional<Announcement> updateAnnouncement(Announcement announcement);
  Page<Announcement> getAllAnnouncements(Pageable pageable);
  Optional<Announcement> getAnAnnouncement(String announcementId);
}
