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

  @Schema(description = "each category can have a parentId")
  private String parentId;
  private String imageId;

  @NotNull
  private JsonNode schema;
}