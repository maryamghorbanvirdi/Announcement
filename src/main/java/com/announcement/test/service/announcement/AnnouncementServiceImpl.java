package com.announcement.test.service.announcement;

import com.announcement.test.domain.announcement.Announcement;
import com.announcement.test.domain.announcement.NoAnnouncement;
import com.announcement.test.repository.announcement.AnnouncementRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AnnouncementServiceImpl implements AnnouncementService{

  private final AnnouncementRepository announcementRepository;

  @Override
  public Announcement createAnnouncement(Announcement announcement) {
    try {
      log.info("enter createAnnouncement() :: announcement={}", announcement);

      var savedAnnouncement = announcementRepository.save(announcement);

      log.info("exit savedAnnouncement() :: announcement={}", savedAnnouncement);

      return savedAnnouncement;

    } catch (Exception ex) {

      log.info("error createAnnouncement() :: exception=" + ex);
      return NoAnnouncement.create();
    }
  }

  @Override
  public Optional<Announcement> updateAnnouncement(Announcement announcement) {
    try {
      log.info("enter updateAnnouncement() :: announcement={}", announcement);

      var optionalAnnouncement =  announcementRepository.findById(announcement.getId());

      if (optionalAnnouncement.isPresent()) {
        var updated = optionalAnnouncement.get();
        announcement.setCategoryId(updated.getCategoryId());
        announcement.setStatus(updated.getStatus());
        announcement.setComment(updated.getComment());
        announcement.setCityId(updated.getCityId());
        announcement.setApprovedBy(updated.getApprovedBy());

        log.info("exit updateAnnouncement() :: announcement={}", announcement);
        return Optional.of(announcementRepository.save(announcement));
      }
      log.info("error announcementId={} :: an error occurred", announcement.getId());
      return Optional.of(NoAnnouncement.create());

    } catch (Exception exception) {

      log.info("error updateAnnouncement() :: exception=", exception);
      return Optional.of(NoAnnouncement.create());
    }
  }

  @Override
  public Page<Announcement> getAllAnnouncements(Pageable pageable) {

    log.info("enter getAllAnnouncements() :: pageable={}", pageable);

    var announcements = announcementRepository.findAll(pageable);

    log.info("exit getAllAnnouncements() :: announcements={}", announcements);

    return announcements;
  }

  @Override
  public Optional<Announcement> getAnAnnouncement(String announcementId) {

    log.info("enter getAnAnnouncement() :: announcementId={}", announcementId);

    var announcement = announcementRepository.findById(announcementId);

    log.info("exit getAnAnnouncement() :: announcement={}", announcement);

    return announcement.isEmpty() ? Optional.of(NoAnnouncement.create()) : announcement;
  }
}
