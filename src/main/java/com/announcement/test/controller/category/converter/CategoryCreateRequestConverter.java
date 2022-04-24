package com.announcement.test.controller.category.converter;

import com.announcement.test.controller.category.viewModel.CategoryCreateRequest;
import com.announcement.test.domain.category.Category;
import com.announcement.test.utils.LocalDateTimeFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class CategoryCreateRequestConverter {

  private final LocalDateTimeFactory localDateTimeFactory;

  public Category convert(CategoryCreateRequest createRequest) {

    log.debug("enter convert() :: categoryCreateViewModel={}", createRequest);

    var category = new Category(createRequest.getName(),
        createRequest.getStatus(),
        localDateTimeFactory.now(),
        createRequest.getParentId(),
        createRequest.getImageUrl(),
        createRequest.getSchema().toString());

    log.debug("exit convert :: category={}", category);

    return category;
  }
}