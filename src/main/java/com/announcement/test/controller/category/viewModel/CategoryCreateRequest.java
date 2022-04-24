package com.announcement.test.controller.category.viewModel;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateRequest {

  @NotBlank
  @Schema(description = "the name of a category", example = "missing", required = true)
  private String name;

  @Schema(description = "it shows the status of a category", example = "active")
  private String status;

  @Schema(description = "the date of creating a category", example = "2021-12-27T06:30:23.149")
  private LocalDateTime createdDate;

  @Schema(description = "each category can have a parentId, PET category is the parent of MISSING category", example = "618fb5e0f2e63541a5157ea0")
  private String parentId;

  @Schema(description = "the url of category which uploaded in another service", example = "https://arvantopman.s3.ir-thr-at1.arvanstorage.com/4fc2d21")
  private String imageUrl;

  @NotNull
  @Schema(description = "you can put each attributes/feature that is required just for the current category", example = "{\n"
      + "            \"howMissing\":\"وقت پیاده روی از صدای بوق ماشین ترسید و فرار کرد\"\n" + ",\"longitude\":\"27.2046\"\n" + ",\"latitude\":\"77.4977\"\n"
      + "             ,\"date\":\"2021-12-14T15:15:46.408881\"\n" + ",\"award\":\"دویست هزار تومن\"\n" + ",\"phoneNumber\":\"09393818888\"\n"
      + "             ,\"description\":\"\"\n" + "}", required = true)
  private JsonNode schema;
}