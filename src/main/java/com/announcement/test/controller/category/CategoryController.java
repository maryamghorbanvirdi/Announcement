package com.announcement.test.controller.category;

import com.announcement.test.controller.category.converter.CategoryCreateRequestConverter;
import com.announcement.test.controller.category.converter.CategoryUpdateRequestConverter;
import com.announcement.test.controller.category.converter.CategoryViewModelConverter;
import com.announcement.test.controller.category.viewModel.CategoryCreateRequest;
import com.announcement.test.controller.category.viewModel.CategoryUpdateRequest;
import com.announcement.test.controller.category.viewModel.CategoryViewModel;
import com.announcement.test.controller.common.PageableConverter;
import com.announcement.test.domain.category.Category;
import com.announcement.test.service.category.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

  @RestController
  @Slf4j
  @AllArgsConstructor
  @RequestMapping("/api/v1/")
  @Tags(value = {@Tag(name = "Category Apis", description = "Ability to add, update and search Categories ")})
  @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Bad request", content = @Content)})
  public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryCreateRequestConverter categoryCreateConverter;
    private final CategoryUpdateRequestConverter categoryUpdateConverter;
    private final CategoryViewModelConverter categoryConverter;
    private final PageableConverter pageableConverter;

    @PostMapping("/categories")
    @Operation(summary = "Create Category", description = "Ability to add a Category")
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Bad request", content = @Content)})
    public ResponseEntity<CategoryViewModel> createCategory(@PathVariable String accountId, @Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {

      log.info("enter createCategory() :: accountId={}, categoryCreateRequest={}", accountId, categoryCreateRequest);

      var category = categoryService.createCategory(categoryCreateConverter.convert(categoryCreateRequest));

      var categoryViewModel = categoryConverter.convert(category);

      log.info("exit createCategory() :: categoryViewModel={}", categoryViewModel);

      return ResponseEntity.status(HttpStatus.CREATED).body(categoryViewModel);
    }

    @PutMapping("/categories/{categoryId}")
    @Operation(summary = "Update Category", description = "Ability to update a Category")
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Bad request", content = @Content), @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    public ResponseEntity<CategoryViewModel> updateCategory(@PathVariable String accountId, @PathVariable String categoryId, @Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {

      log.info("enter updateCategory() :: accountId={}, categoryId={}, categoryUpdateRequest={}", accountId, categoryId, categoryUpdateRequest);

      var categoryViewModel = categoryService.updateCategory(categoryUpdateConverter.convert(categoryId, categoryUpdateRequest))
          .filter(Category::isPresent)
          .map(categoryConverter::convert)
          .map(category1 -> ResponseEntity.status(HttpStatus.OK).body(category1))
          .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

      log.info("exit updateCategory() :: categoryViewModel={}", categoryViewModel);
      return categoryViewModel;
    }


    @GetMapping("/categories")
    @Operation(summary = "Find All Categories", description = "Ability to search all Category")
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Bad request", content = @Content)})
    public List<CategoryViewModel> getAllCategories(@PathVariable String accountId,
        @Parameter(description = "this shows the content of selected page, if no page selected, it shows the content of page 0 by default.") @RequestParam(name = "page", defaultValue = "0") int page,
        @Parameter(description = "it means that how many categories are in a page, if no size selected, it shows 20 categories by default.")@RequestParam(name = "size", defaultValue = "20") int size,
        @RequestParam(name = "isAsc", defaultValue = "true") boolean isAsc,
        @Parameter(description = "it order categories based on their ids") @RequestParam(name = "propertiesName", defaultValue = "id") String propertiesName) {

      log.info("enter getAllCategories() :: accountId={}, page={}, size={}, isAsc={}, propertiesName={}", accountId, page, size, isAsc, propertiesName);

      var categoryViewModels = categoryService.getAllCategories(pageableConverter.convert(page, size, isAsc, propertiesName))
          .map(categoryConverter::convert)
          .getContent();

      log.info("enter getAllCategories :: categoryViewModels={}", categoryViewModels);

      return categoryViewModels;
    }

    @GetMapping("/categories/{categoryId}")
    @Operation(summary ="Find a Category", description = "Ability to search a Category")
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Bad request", content = @Content), @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)})
    public ResponseEntity<CategoryViewModel> getCategory(@PathVariable String accountId, @PathVariable String categoryId) {

      log.info("enter getCategory :: accountId={}, categoryId={}", accountId, categoryId);

      var categoryViewModel = categoryService.getCategory(categoryId)
          .filter(Category::isPresent)
          .map(categoryConverter::convert)
          .map(category1 -> ResponseEntity.status(HttpStatus.OK).body(category1))
          .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

      log.info("enter getCategory() :: categoryViewModel={}", categoryViewModel);
      return categoryViewModel;
    }
  }