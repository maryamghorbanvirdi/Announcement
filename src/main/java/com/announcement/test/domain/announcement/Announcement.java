package com.announcement.test.domain.announcement;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {

  @Id
  private String id;
  private String categoryId;
  private Integer status;
  private String title;
  private LocalDateTime createdDate;
  private String comment;
  private String accountId;
  private String approvedBy;
  private Long provinceId;
  private Long cityId;
  private String phoneNumber;

  public boolean isPresent(){
    return true;
  }
}
