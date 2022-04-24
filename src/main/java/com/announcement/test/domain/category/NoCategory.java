package com.announcement.test.domain.category;

public class NoCategory extends Category{

  private static final NoCategory INSTANCE = new NoCategory();

  private NoCategory() {
    super(null, null, null, null, null, null, null);
  }

  public static NoCategory create() {
    return INSTANCE;
  }

  @Override
  public boolean isPresent(){
    return false;
  }
}