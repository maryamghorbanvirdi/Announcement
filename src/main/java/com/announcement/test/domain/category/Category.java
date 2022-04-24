package com.announcement.test.domain.category;

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
public class Category {

  @Id
  private String id;
  private String name;
  private String status;
  private LocalDateTime createdDate;
  private String parentId;
  private String imageId;
  private String schema;

  public Category(String name, String status, LocalDateTime createdDate, String parentId, String imageId, String schema) {
    this.name = name;
    this.status = status;
    this.createdDate = createdDate;
    this.parentId = parentId;
    this.imageId = imageId;
    this.schema = schema;
  }

  public Category(String id, String name, String status, String parentId, String imageId, String schema) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.parentId = parentId;
    this.imageId = imageId;
    this.schema = schema;
  }

  public boolean isPresent(){
    return true;
  }
}
