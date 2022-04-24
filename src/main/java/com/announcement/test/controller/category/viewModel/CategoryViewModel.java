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

  @Schema(description = "each category can have a parentId, PET category is the parent of MISSING category", example = "618fb5e0f2e63541a5157ea0")
  String parentId;

  @Schema(description = "the url of category which uploaded in another service", example = "https://arvantopman.s3.ir-thr-at1.arvanstorage.com/4fc2d21")
  String imageUrl;

  @Schema(description = "this returns the schema we defined in the creating as string", example = "\"howMissing\":\"وقت پیاده روی از صدای بوق ماشین ترسید و فرار کرد\",\"longitude\":\"27.2046\","
      + "\"latitude\":\"77.4977\" ,\"date\":\"2021-12-14T15:15:46.408881\",\"award\":\"دویست هزار تومن\" ,\"phoneNumber\":\"09393818888\",\"description\":\"\"")
  String schema;
}
