package org.mayank.inventory.service.imp;

import org.mayank.inventory.dto.CategoryDTO;
import org.mayank.inventory.entity.Category;
import org.mayank.inventory.exception.ResourceNotFoundException;
import org.mayank.inventory.repository.CategoryRepository;
import org.mayank.inventory.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryImplementation implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO rewriteCategory(CategoryDTO categoryDTO) { //put
        Category category = categoryRepository.findById(categoryDTO.getCategoryid()).orElseThrow(() -> new ResourceNotFoundException("Category","id", categoryDTO.getCategoryid()));
        category.setCategoryid(categoryDTO.getCategoryid());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setProducts(categoryDTO.getProducts());
        Category savedCategory = categoryRepository.save(category);

        return mapToDTO(savedCategory);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) { //post
        // convert DTO to entity
        Category category = mapToEntity(categoryDTO);
        Category newCategory = categoryRepository.save(category);

        // convert entity to DTO
        CategoryDTO categoryResponse = mapToDTO(newCategory);
        return categoryResponse;
    }

    @Override
    public CategoryDTO getCategoryById(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category","id", id));
        return mapToDTO(category);
    }

    @Override
    public CategoryDTO updateCategoryByID(CategoryDTO categoryDTO, String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category","id", id));
        category.setCategoryid(categoryDTO.getCategoryid());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setProducts(categoryDTO.getProducts());
        Category savedCategory = categoryRepository.save(category);

        return mapToDTO(savedCategory);
    }

    @Override
    public void deleteCategoryByID(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category","id", id));
        categoryRepository.delete(category);
    }

    private CategoryDTO mapToDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryid(category.getCategoryid());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());

        return categoryDTO;
    }

    private Category mapToEntity(CategoryDTO categoryDTO){
        Category category = new Category();

        category.setCategoryid(categoryDTO.getCategoryid());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }
}
