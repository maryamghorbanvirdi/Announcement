package com.announcement.test.controller.category.converter;

import com.announcement.test.controller.category.viewModel.CategoryViewModel;
import com.announcement.test.domain.category.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CategoryViewModelConverter {

  public CategoryViewModel convert(Category category) {

    log.debug("enter convert() :: category={}", category);

    var categoryViewModel = new CategoryViewModel(category.getId(),
        category.getName(),
        category.getStatus(),
        category.getCreatedDate(),
        category.getParentId(),
        category.getImageId(),
        category.getSchema());

    log.debug("exit convert() :: categoryViewModel={}", categoryViewModel);

    return categoryViewModel;
  }
}
