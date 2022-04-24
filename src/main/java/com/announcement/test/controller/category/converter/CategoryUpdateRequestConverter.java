package com.announcement.test.controller.category.converter;

import com.announcement.test.controller.category.viewModel.CategoryUpdateRequest;
import com.announcement.test.service.category.dto.CategoryUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class CategoryUpdateRequestConverter {

  public CategoryUpdateDTO convert(String categoryId, CategoryUpdateRequest updateRequest) {

    log.debug("enter convert() :: categoryId={}, categoryUpdateViewModel={}", categoryId, updateRequest);

    var updatedCategory = new CategoryUpdateDTO(categoryId,
        updateRequest.getName(),
        updateRequest.getStatus(),
        updateRequest.getParentId(),
        updateRequest.getImageId(),
        updateRequest.getSchema().toString());

    log.debug("exit convert :: updatedCategory={}", updatedCategory);

    return updatedCategory;
  }
}
