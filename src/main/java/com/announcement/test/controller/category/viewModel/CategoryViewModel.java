package com.announcement.test.controller.category.viewModel;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryViewModel {

  @Schema(description = "the id of a category", example = "618fb5e0f2e63541a5157ea7")
  String id;

  @Schema(description = "the name of a category", example = "missing")
  String name;

  @Schema(description = "it shows the status of a category", example = "active")
  String status;

  @Schema(description = "the date of creating a category", example = "2021-12-27T06:30:23.149")
  LocalDateTime createdDate;

  @Schema(description = "each category can have a parentId")
  String parentId;
  String imageId;
  String schema;
}
