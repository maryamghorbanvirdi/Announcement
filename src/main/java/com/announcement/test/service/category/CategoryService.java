package com.announcement.test.service.category;

import com.announcement.test.domain.category.Category;
import com.announcement.test.service.category.dto.CategoryUpdateDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

  Category createCategory(Category category);
  Optional<Category> updateCategory(CategoryUpdateDTO updateDTO);
  Page<Category> getAllCategories(Pageable pageable);
  Optional<Category> getCategory(String categoryId);
}
