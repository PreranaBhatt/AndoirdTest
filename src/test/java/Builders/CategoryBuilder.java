package Builders;

import entities.request.Category;

public class CategoryBuilder {

    private Category category = new Category();// created object for category classs under entities package


    // simply creating method to access those class members

    public CategoryBuilder withId(int id) {
        category.setId(id);
        return this;
    }

    public CategoryBuilder withName(String name) {
        category.setName(name);
        return this;
    }

    public Category build() {
        return category;
    }
}
