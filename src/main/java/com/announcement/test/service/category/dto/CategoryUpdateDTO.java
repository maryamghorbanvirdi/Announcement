package com.announcement.test.service.category.dto;

import lombok.Value;

@Value
public class CategoryUpdateDTO {

  String id;
  String name;
  String status;
  String parentId;
  String imageId;
  String schema;
}