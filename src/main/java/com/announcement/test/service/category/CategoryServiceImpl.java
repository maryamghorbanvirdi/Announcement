package com.announcement.test.service.category;

import com.announcement.test.domain.category.Category;
import com.announcement.test.domain.category.NoCategory;
import com.announcement.test.repository.category.CategoryRepository;
import com.announcement.test.service.category.dto.CategoryUpdateDTO;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService{

  private final CategoryRepository categoryRepository;

  @Override
  public Category createCategory(Category category) {
    try {
      log.info("enter createCategory() :: createCategory={}", category);

      var savedCategory = categoryRepository.save(category);

      log.info("exit createCategory() :: savedCategory={}", savedCategory);

      return savedCategory;

    } catch (Exception ex) {

      log.info("error createCategory() :: exception=" + ex);
      return NoCategory.create();
    }
  }

  @Override
  public Optional<Category> updateCategory(CategoryUpdateDTO updateDTO) {
    try {
      log.info("enter updateCategory() :: categoryUpdateDTO={}", updateDTO);

      var optionalCategory =  categoryRepository.findById(updateDTO.getId());

      if (optionalCategory.isPresent()) {
        var category = optionalCategory.get();
        category.setName(updateDTO.getName());
        category.setStatus(updateDTO.getStatus());
        category.setParentId(updateDTO.getParentId());
        category.setImageId(updateDTO.getImageId());
        category.setSchema(updateDTO.getSchema());

        log.info("exit updateCategory() :: category={}", category);
        return Optional.of(categoryRepository.save(category));
      }
      log.info("error categoryId={} :: an error occurred", updateDTO.getId());
      return Optional.of(NoCategory.create());

    } catch (Exception exception) {

      log.info("error updateCategory() :: exception=", exception);
      return Optional.of(NoCategory.create());
    }
  }

  @Override
  public Page<Category> getAllCategories(Pageable pageable) {

    log.info("enter getAllCategories() :: pageable={}", pageable);

    var categories = categoryRepository.findAll(pageable);

    log.info("exit getAllCategories() :: categories={}", categories);

    return categories;
  }

  @Override
  public Optional<Category> getCategory(String categoryId) {

    log.info("enter getCategory() :: categoryId={}", categoryId);

    var category = categoryRepository.findById(categoryId);

    log.info("exit getCategory() :: category={}", category);

    return category.isEmpty() ? Optional.of(NoCategory.create()) : category;
  }
}
